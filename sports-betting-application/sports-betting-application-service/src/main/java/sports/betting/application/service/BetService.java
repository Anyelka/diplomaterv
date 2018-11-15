package sports.betting.application.service;

import java.util.List;

import sports.betting.application.dal.bet.dao.BetDao;
import sports.betting.application.dal.sportevent.dao.SportEventDao;
import sports.betting.application.domain.bet.Bet;
import sports.betting.application.domain.bet.BetType;
import sports.betting.application.domain.sportevent.SportEvent;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;

public class BetService {

    @Autowired
    private SportEventDao sportEventDao;

    @Autowired
    private BetDao betDao;

    public void createBet(String eventTitle, String description, BetType betType) {
        SportEvent event = sportEventDao.getByTitle(eventTitle);
        String fullDescription = (eventTitle + " -- " + description);
        Bet bet = new Bet(event, fullDescription, betType);
        betDao.save(bet);
    }

    public void createBet(String fullDescription, BetType betType) {
        String eventTitle = fullDescription.substring(0, fullDescription.indexOf("--"));
        SportEvent event = sportEventDao.getByTitle(eventTitle);
        Bet bet = new Bet(event, fullDescription, betType);
        betDao.save(bet);
    }

    public List<Bet> getAllByEvent(SportEvent event) {
        Iterable<Bet> bets = betDao.getAllByEvent(event);
        return Lists.newArrayList(bets);
    }

    public Bet getByDescription(String description) {
        return betDao.getByDescription(description);
    }

}

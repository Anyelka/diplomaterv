package sports.betting.application.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import sports.betting.application.dal.bet.dao.BetDao;
import sports.betting.application.dal.outcome.dao.OutcomeDao;
import sports.betting.application.domain.bet.Bet;
import sports.betting.application.domain.outcome.Outcome;
import org.springframework.beans.factory.annotation.Autowired;

public class OutcomeService {

    @Autowired
    private BetDao betDao;
    
    @Autowired
    private OutcomeDao outcomeDao;
    
    public Outcome createOutcome(String betDescription, String value, double odd) {
        Bet bet = betDao.getByDescription(betDescription);
        Outcome outcome = new Outcome(bet, value, odd);
        outcomeDao.save(outcome);
        return outcome;
    }

    public List<Outcome> getAllByBet(Bet bet) {
        return outcomeDao.getAllByBet(bet);
    }
    
    public Outcome getOutcome(int id) {
        return outcomeDao.getById(id);
    }
    
    public Outcome getByBetAndValue(Bet bet, String value) {
        return outcomeDao.getByBetAndValue(bet, value);
    }
    
    public Outcome getByFullDescription(String description) {
        String betDescription = description.substring(0, description.lastIndexOf("--") - 1);
        String value = description.substring(description.lastIndexOf("--") + 3);
        Bet bet = betDao.getByDescription(betDescription);
        return getByBetAndValue(bet,value);
    }
    
}
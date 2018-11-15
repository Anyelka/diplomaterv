package sports.betting.application.dal.bet.dao;

import java.util.List;
import java.util.stream.Collectors;

import sports.betting.application.dal.bet.dao.converter.BetBackConverter;
import sports.betting.application.dal.bet.dao.converter.BetConverter;
import sports.betting.application.dal.bet.repository.BetRepository;
import sports.betting.application.dal.sportevent.dao.converter.SportEventBackConverter;
import sports.betting.application.domain.bet.Bet;
import sports.betting.application.domain.sportevent.SportEvent;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;

public class DefaultBetDao implements BetDao {

    @Autowired
    private BetConverter betConverter;
    
    @Autowired
    private BetBackConverter betBackConverter;

    @Autowired
    private SportEventBackConverter sportEventBackConverter;

    @Autowired
    private BetRepository betRepository;

    @Override
    public Bet getByDescription(String description) {
        return betConverter.convert(betRepository.findByDescription(description));
    }

    @Override
    public List<Bet> getAllByEvent(SportEvent event) {
        return Lists.newArrayList(betRepository.findAllByEvent(sportEventBackConverter.convert(event))).stream().map(b -> betConverter.convert(b))
                .collect(Collectors.toList());
    }

    @Override
    public void save(Bet bet) {
        betRepository.save(betBackConverter.convert(bet));
    }

}

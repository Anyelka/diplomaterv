package sports.betting.application.dal.bet.dao;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import sports.betting.application.dal.bet.dao.converter.BetBackConverter;
import sports.betting.application.dal.bet.dao.converter.BetConverter;
import sports.betting.application.dal.bet.entity.BetEntity;
import sports.betting.application.dal.bet.repository.BetRepository;
import sports.betting.application.dal.sportevent.dao.converter.SportEventBackConverter;
import sports.betting.application.domain.bet.Bet;
import sports.betting.application.domain.sportevent.SportEvent;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public Optional<Bet> getByDescription(String description) {
        Optional<BetEntity> bet = betRepository.findByDescription(description);
        return bet.isPresent() ? Optional.of(betConverter.convert(bet.get())) : Optional.empty();
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

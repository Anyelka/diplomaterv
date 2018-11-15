package sports.betting.application.dal.outcome.dao;

import java.util.List;
import java.util.stream.Collectors;

import sports.betting.application.dal.bet.dao.converter.BetBackConverter;
import sports.betting.application.dal.outcome.dao.converter.OutcomeBackConverter;
import sports.betting.application.dal.outcome.dao.converter.OutcomeConverter;
import sports.betting.application.dal.outcome.repository.OutcomeRepository;
import sports.betting.application.dal.result.repository.ResultRepository;
import sports.betting.application.domain.bet.Bet;
import sports.betting.application.domain.outcome.Outcome;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;

public class DefaultOutcomeDao implements OutcomeDao {

    @Autowired
    private OutcomeRepository outcomeRepository;
    
    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private OutcomeConverter outcomeConverter;
    
    @Autowired
    private OutcomeBackConverter outcomeBackConverter;

    @Autowired
    private BetBackConverter betBackConverter;

    @Override
    public Outcome getById(int id) {
        return outcomeConverter.convert(outcomeRepository.findById(id));
    }

    @Override
    public Outcome getByBetAndValue(Bet bet, String value) {
        return outcomeConverter.convert(outcomeRepository.findByBetAndValue(betBackConverter.convert(bet), value));
    }

    @Override
    public Outcome getResultOutcomeByBet(Bet bet) {
        return outcomeConverter.convert(resultRepository.findByBet(betBackConverter.convert(bet)).getOutcome());
    }

    @Override
    public List<Outcome> getAllByBet(Bet bet) {
        return Lists.newArrayList(outcomeRepository.findAllByBet(betBackConverter.convert(bet))).stream().map(o -> outcomeConverter.convert(o))
                .collect(Collectors.toList());
    }

    @Override
    public void save(Outcome outcome) {
        outcomeRepository.save(outcomeBackConverter.convert(outcome));
    }

}

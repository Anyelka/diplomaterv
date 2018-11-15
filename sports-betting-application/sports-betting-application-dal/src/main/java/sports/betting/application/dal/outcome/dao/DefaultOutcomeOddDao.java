package sports.betting.application.dal.outcome.dao;

import sports.betting.application.dal.outcome.dao.converter.OutcomeOddBackTransformer;
import sports.betting.application.dal.outcome.dao.converter.OutcomeOddConverter;
import sports.betting.application.dal.outcome.repository.OutcomeOddRepository;
import sports.betting.application.domain.outcome.OutcomeOdd;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultOutcomeOddDao implements OutcomeOddDao {

    @Autowired
    private OutcomeOddRepository outcomeOddRepository;
    
    @Autowired
    private OutcomeOddBackTransformer outcomeOddBackConverter;
    
    @Autowired
    private OutcomeOddConverter outcomeOddConverter;

    @Override
    public void save(OutcomeOdd outcomeOdd) {
        outcomeOddRepository.save(outcomeOddBackConverter.convert(outcomeOdd));
    }

    @Override
    public OutcomeOdd getById(int id) {
        return outcomeOddConverter.convert(outcomeOddRepository.findById(id));
    }

}

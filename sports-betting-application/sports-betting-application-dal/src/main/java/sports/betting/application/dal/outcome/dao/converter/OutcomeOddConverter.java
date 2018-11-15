package sports.betting.application.dal.outcome.dao.converter;

import sports.betting.application.dal.outcome.entity.OutcomeOddEntity;
import sports.betting.application.domain.outcome.OutcomeOdd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OutcomeOddConverter implements Converter<OutcomeOddEntity, OutcomeOdd> {

    @Autowired
    private OutcomeConverter outcomeConverter;
    
    @Override
    public OutcomeOdd convert(OutcomeOddEntity outcomeOddEntity) {
        if(outcomeOddEntity == null) {
            return null;
        }
        OutcomeOdd outcomeOdd = new OutcomeOdd();
        outcomeOdd.setId(outcomeOddEntity.getId());
        outcomeOdd.setOutcome(outcomeConverter.convert(outcomeOddEntity.getOutcome()));
        outcomeOdd.setValue(outcomeOddEntity.getValue());
        outcomeOdd.setValidFrom(outcomeOddEntity.getValidFrom());
        outcomeOdd.setValidTo(outcomeOddEntity.getValidTo());
        return outcomeOdd;
    }

}

package sports.betting.application.dal.outcome.dao.converter;

import sports.betting.application.dal.bet.dao.converter.BetBackConverter;
import sports.betting.application.dal.outcome.entity.OutcomeEntity;
import sports.betting.application.domain.outcome.Outcome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OutcomeBackConverter {

    @Autowired
    private BetBackConverter betBackConverter;
    
    public OutcomeEntity convert(Outcome outcome) {
        OutcomeEntity outcomeEntity = new OutcomeEntity();
        outcomeEntity.setId(outcome.getId());
        outcomeEntity.setValue(outcome.getValue());
        outcomeEntity.setBet(betBackConverter.convert(outcome.getBet()));
        outcomeEntity.setCurrentOdd(outcome.getCurrentOdd());
        return outcomeEntity;
    }

}

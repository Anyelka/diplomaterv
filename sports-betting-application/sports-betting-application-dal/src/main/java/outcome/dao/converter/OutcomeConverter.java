package org.sports.betting.application.dal.outcome.dao.converter;

import org.sports.betting.application.dal.bet.dao.converter.BetConverter;
import org.sports.betting.application.dal.outcome.entity.OutcomeEntity;
import outcome.Outcome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OutcomeConverter implements Converter<OutcomeEntity, Outcome>{

    @Autowired
    private BetConverter betConverter;
    
    @Autowired
    private OutcomeOddConverter outcomeOddConverter;
    
    @Override
    public Outcome convert(OutcomeEntity outcomeEntity) {
        if(outcomeEntity == null) {
            return null;
        }
        Outcome outcome = new Outcome();
        outcome.setId(outcomeEntity.getId());
        outcome.setValue(outcomeEntity.getValue());
        outcome.setBet(betConverter.convert(outcomeEntity.getBet()));
        outcome.setCurrentOdd(outcomeOddConverter.convert(outcomeEntity.getCurrentOdd()));
        return outcome;
    }

}

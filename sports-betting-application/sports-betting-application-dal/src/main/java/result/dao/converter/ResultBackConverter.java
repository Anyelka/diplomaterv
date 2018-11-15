package org.sports.betting.application.dal.result.dao.converter;

import org.sports.betting.application.dal.bet.dao.converter.BetBackConverter;
import org.sports.betting.application.dal.outcome.dao.converter.OutcomeBackConverter;
import org.sports.betting.application.dal.result.entity.ResultEntity;
import result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ResultBackConverter implements Converter<Result, ResultEntity> {

    @Autowired
    private BetBackConverter betBackConverter;
  
    @Autowired
    private OutcomeBackConverter outcomeBackConverter;
    
    @Override
    public ResultEntity convert(Result source) {
        ResultEntity result = new ResultEntity();
        result.setId(source.getId());
        result.setBet(betBackConverter.convert(source.getBet()));
        result.setOutcome(outcomeBackConverter.convert(source.getOutcome()));
        return result;
    }

}

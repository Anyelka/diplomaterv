package org.sports.betting.application.dal.result.dao.converter;

import org.sports.betting.application.dal.bet.dao.converter.BetConverter;
import org.sports.betting.application.dal.outcome.dao.converter.OutcomeConverter;
import org.sports.betting.application.dal.result.entity.ResultEntity;
import result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ResultConverter implements Converter<ResultEntity, Result> {

    @Autowired
    private BetConverter betConverter;
  
    @Autowired
    private OutcomeConverter outcomeConverter;
    
    @Override
    public Result convert(ResultEntity source) {
        Result result = new Result();
        result.setId(source.getId());
        result.setBet(betConverter.convert(source.getBet()));
        result.setOutcome(outcomeConverter.convert(source.getOutcome()));
        return result;
    }

}

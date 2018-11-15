package org.sports.betting.application.dal.result.dao;

import org.sports.betting.application.dal.bet.dao.converter.BetBackConverter;
import org.sports.betting.application.dal.result.dao.converter.ResultBackConverter;
import org.sports.betting.application.dal.result.dao.converter.ResultConverter;
import org.sports.betting.application.dal.result.repository.ResultRepository;
import bet.Bet;
import result.Result;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultResultDao implements ResultDao {

    @Autowired 
    private ResultRepository resultRepository;
    
    @Autowired
    private ResultConverter resultConverter;
    
    @Autowired
    private ResultBackConverter resultBackConverter;

    @Autowired
    private BetBackConverter betBackConverter;
    
    @Override
    public void save(Result result) {
        resultRepository.save(resultBackConverter.convert(result));
    }

    @Override
    public Result getByBet(Bet bet) {
        return resultConverter.convert(resultRepository.findByBet(betBackConverter.convert(bet)));
    }

}

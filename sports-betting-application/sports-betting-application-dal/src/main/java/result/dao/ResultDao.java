package org.sports.betting.application.dal.result.dao;

import bet.Bet;
import result.Result;

public interface ResultDao {
    public void save(Result result);
    public Result getByBet(Bet bet);
}

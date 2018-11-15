package org.sports.betting.application.dal.result.repository;

import org.sports.betting.application.dal.bet.entity.BetEntity;
import org.sports.betting.application.dal.result.entity.ResultEntity;
import org.springframework.data.repository.CrudRepository;

public interface ResultRepository extends CrudRepository<ResultEntity, Integer> {
    public ResultEntity findByBet(BetEntity bet);
}

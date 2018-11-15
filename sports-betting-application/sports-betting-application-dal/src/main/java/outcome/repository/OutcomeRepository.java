package org.sports.betting.application.dal.outcome.repository;

import java.util.List;

import org.sports.betting.application.dal.bet.entity.BetEntity;
import org.sports.betting.application.dal.outcome.entity.OutcomeEntity;
import org.springframework.data.repository.CrudRepository;

public interface OutcomeRepository extends CrudRepository<OutcomeEntity, Integer> {
    public OutcomeEntity findById(int id);
    public List<OutcomeEntity> findAllByBet(BetEntity bet);
    public OutcomeEntity findByBetAndValue(BetEntity bet, String value);
}

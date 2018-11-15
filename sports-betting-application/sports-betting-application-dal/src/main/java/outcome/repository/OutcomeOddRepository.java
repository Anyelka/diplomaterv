package org.sports.betting.application.dal.outcome.repository;

import org.sports.betting.application.dal.outcome.entity.OutcomeOddEntity;
import org.springframework.data.repository.CrudRepository;

public interface OutcomeOddRepository extends CrudRepository<OutcomeOddEntity, Integer> {    
//    public OutcomeOddEntity findByOutcome(OutcomeEntity outcome);
    public OutcomeOddEntity findById(int id);
}

package org.sports.betting.application.dal.outcome.dao;

import outcome.OutcomeOdd;

public interface OutcomeOddDao {
    public OutcomeOdd getById(int id);
    public void save(OutcomeOdd outcomeOdd);
}

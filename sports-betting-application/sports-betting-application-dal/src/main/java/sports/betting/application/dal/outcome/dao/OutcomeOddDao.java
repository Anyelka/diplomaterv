package sports.betting.application.dal.outcome.dao;

import sports.betting.application.domain.outcome.OutcomeOdd;

public interface OutcomeOddDao {
    public OutcomeOdd getById(int id);
    public void save(OutcomeOdd outcomeOdd);
}

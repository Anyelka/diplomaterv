package sports.betting.application.dal.outcome.repository;

import sports.betting.application.dal.outcome.entity.OutcomeOddEntity;
import org.springframework.data.repository.CrudRepository;

public interface OutcomeOddRepository extends CrudRepository<OutcomeOddEntity, Integer> {
//    public OutcomeOddEntity findByOutcome(OutcomeEntity sports.betting.application.domain.outcome);
    public OutcomeOddEntity findById(int id);
}

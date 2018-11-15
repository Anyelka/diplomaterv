package sports.betting.application.dal.outcome.repository;

import java.util.List;

import sports.betting.application.dal.bet.entity.BetEntity;
import sports.betting.application.dal.outcome.entity.OutcomeEntity;
import org.springframework.data.repository.CrudRepository;

public interface OutcomeRepository extends CrudRepository<OutcomeEntity, Integer> {
    public OutcomeEntity findById(int id);
    public List<OutcomeEntity> findAllByBet(BetEntity bet);
    public OutcomeEntity findByBetAndValue(BetEntity bet, String value);
}

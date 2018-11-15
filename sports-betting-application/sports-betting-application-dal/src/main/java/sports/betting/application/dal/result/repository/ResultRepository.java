package sports.betting.application.dal.result.repository;

import sports.betting.application.dal.bet.entity.BetEntity;
import sports.betting.application.dal.result.entity.ResultEntity;
import org.springframework.data.repository.CrudRepository;

public interface ResultRepository extends CrudRepository<ResultEntity, Integer> {
    public ResultEntity findByBet(BetEntity bet);
}

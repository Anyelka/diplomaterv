package sports.betting.application.dal.result.repository;

import org.springframework.data.jpa.repository.Query;
import sports.betting.application.dal.bet.entity.BetEntity;
import sports.betting.application.dal.result.entity.ResultEntity;
import org.springframework.data.repository.CrudRepository;
import sports.betting.application.dal.sportevent.entity.SportEventEntity;

import java.util.List;

public interface ResultRepository extends CrudRepository<ResultEntity, Integer> {
    public ResultEntity findByBet(BetEntity bet);

    @Query("SELECT r FROM ResultEntity r WHERE r.bet.event = ?1")
    public List<ResultEntity> findAllByEvent(SportEventEntity convert);
}

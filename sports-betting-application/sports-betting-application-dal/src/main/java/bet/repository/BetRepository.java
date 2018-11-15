package org.sports.betting.application.dal.bet.repository;

import java.util.List;



import org.sports.betting.application.dal.bet.entity.BetEntity;
import org.sports.betting.application.dal.sportevent.entity.SportEventEntity;
import org.springframework.data.repository.CrudRepository;

public interface BetRepository extends CrudRepository<BetEntity, Integer> {
    public BetEntity findByDescription(String description);
    public List<BetEntity> findAllByEvent(SportEventEntity event);
}

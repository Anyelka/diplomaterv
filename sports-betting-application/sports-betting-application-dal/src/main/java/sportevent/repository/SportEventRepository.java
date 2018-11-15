package org.sports.betting.application.dal.sportevent.repository;

import org.sports.betting.application.dal.sportevent.entity.SportEventEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportEventRepository extends CrudRepository<SportEventEntity,Integer>{
    SportEventEntity findByTitle(String title);
    SportEventEntity findById(int id);
}

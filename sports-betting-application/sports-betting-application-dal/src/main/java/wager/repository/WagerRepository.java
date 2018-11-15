package wager.repository;

import java.util.List;

import org.sports.betting.application.dal.user.entity.UserEntity;
import wager.entity.WagerEntity;
import org.springframework.data.repository.CrudRepository;

public interface WagerRepository extends CrudRepository<WagerEntity, Integer> {
    public List<WagerEntity> findAllByPlayer(UserEntity player);
}

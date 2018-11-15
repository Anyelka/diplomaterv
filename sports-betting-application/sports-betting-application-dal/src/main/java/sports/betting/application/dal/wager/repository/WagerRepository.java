package sports.betting.application.dal.wager.repository;

import java.util.List;

import sports.betting.application.dal.user.entity.UserEntity;
import sports.betting.application.dal.wager.entity.WagerEntity;
import org.springframework.data.repository.CrudRepository;

public interface WagerRepository extends CrudRepository<WagerEntity, Integer> {
    public List<WagerEntity> findAllByPlayer(UserEntity player);
}

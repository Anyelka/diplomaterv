package sports.betting.application.dal.user.repository;

import sports.betting.application.dal.user.entity.PlayerDataEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerDataRepository extends CrudRepository<PlayerDataEntity, Integer>{

}

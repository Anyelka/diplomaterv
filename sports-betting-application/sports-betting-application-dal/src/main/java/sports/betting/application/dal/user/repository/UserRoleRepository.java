package sports.betting.application.dal.user.repository;

import sports.betting.application.dal.user.entity.UserRoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRoleEntity, Long>{
    public UserRoleEntity findByName(String name);
}

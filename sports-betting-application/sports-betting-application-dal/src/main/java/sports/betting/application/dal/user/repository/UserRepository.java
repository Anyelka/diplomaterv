package sports.betting.application.dal.user.repository;

import sports.betting.application.dal.user.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    public UserEntity findByUsername(String username);
}

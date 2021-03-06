package sports.betting.application.dal.user.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import sports.betting.application.dal.user.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    public List<UserEntity> findAll();
    public UserEntity findByUsername(String username);
    @Transactional
    public void deleteByUsername(String username);
}

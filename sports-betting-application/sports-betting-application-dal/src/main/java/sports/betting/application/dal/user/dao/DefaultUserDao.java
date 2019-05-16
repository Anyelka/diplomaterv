package sports.betting.application.dal.user.dao;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import sports.betting.application.dal.user.dao.converter.PlayerDataBackConverter;
import sports.betting.application.dal.user.dao.converter.UserBackConverter;
import sports.betting.application.dal.user.dao.converter.UserConverter;
import sports.betting.application.dal.user.entity.PlayerDataEntity;
import sports.betting.application.dal.user.entity.UserEntity;
import sports.betting.application.dal.user.repository.PlayerDataRepository;
import sports.betting.application.dal.user.repository.UserRepository;
import sports.betting.application.domain.user.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DefaultUserDao implements UserDao {

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private UserBackConverter userBackConverter;

    @Autowired
    private PlayerDataBackConverter playerDataBackConverter;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlayerDataRepository playerDataRepository;

    @Override
    public List<User> getAll() {
        return userConverter.convert(userRepository.findAll());
    }

    @Override
    public User getById(int id) {
        return userConverter.convert(userRepository.findById(id).get());
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return Optional.ofNullable(userConverter.convert(userRepository.findByUsername(username)));
    }

    @Override
    public User getPlayerByFullName(String name) {
        return userConverter.convert(Lists.newArrayList(userRepository.findAll()).stream().filter(user -> user.getPlayerData().getName().equals(name)).findFirst().get());
    }

    @Override
    public void save(User user) {
        UserEntity userEntity = userBackConverter.convert(user);
        PlayerDataEntity playerDataEntity = playerDataBackConverter.convert(user.getPlayerData());
        userEntity.setPlayerData(playerDataEntity);
        if (playerDataEntity != null) {
            playerDataRepository.save(playerDataEntity);
        }
        userRepository.save(userEntity);
    }

    @Override
    public boolean checkIfUserExists(String username) {
        return userRepository.findByUsername(username) != null;
    }

    @Override
    public boolean checkIfDifferentUserExistsWithSameUsername(String username, int userId) {
        UserEntity userByUsername = userRepository.findByUsername(username);
        Optional<UserEntity> userById = userRepository.findById(userId);
        if(userRepository.findByUsername(username) == null){
            return false;
        } else {
            return userById.filter(userEntity -> userByUsername.getId() != userEntity.getId()).isPresent();
        }
    }

    @Override
    public void delete(String username) {
        userRepository.deleteByUsername(username);
    }

}

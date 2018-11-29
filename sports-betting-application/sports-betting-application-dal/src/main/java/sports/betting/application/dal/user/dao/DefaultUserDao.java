package sports.betting.application.dal.user.dao;

import sports.betting.application.dal.user.dao.converter.PlayerDataBackConverter;
import sports.betting.application.dal.user.dao.converter.UserBackConverter;
import sports.betting.application.dal.user.dao.converter.UserConverter;
import sports.betting.application.dal.user.entity.PlayerDataEntity;
import sports.betting.application.dal.user.entity.UserEntity;
import sports.betting.application.dal.user.repository.PlayerDataRepository;
import sports.betting.application.dal.user.repository.UserRepository;
import sports.betting.application.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;

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
    public User getById(int id) {
        return userConverter.convert(userRepository.findById(id).get());
    }

    @Override
    public User getByUsername(String username) {
        return userConverter.convert(userRepository.findByUsername(username));
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
        playerDataRepository.save(playerDataEntity);
        userRepository.save(userEntity);
    }

    @Override
    public boolean checkIfUserExists(String username) {
        return userRepository.findByUsername(username) == null ? false : true;
    }

}

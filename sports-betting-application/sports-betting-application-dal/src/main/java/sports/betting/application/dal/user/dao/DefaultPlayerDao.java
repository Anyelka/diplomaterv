package sports.betting.application.dal.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import sports.betting.application.dal.user.dao.converter.PlayerDataBackConverter;
import sports.betting.application.dal.user.dao.converter.UserBackConverter;
import sports.betting.application.dal.user.dao.converter.UserConverter;
import sports.betting.application.dal.user.entity.PlayerDataEntity;
import sports.betting.application.dal.user.entity.UserEntity;
import sports.betting.application.dal.user.repository.PlayerDataRepository;
import sports.betting.application.dal.user.repository.UserRepository;
import sports.betting.application.domain.user.PlayerData;
import sports.betting.application.domain.user.User;

import java.util.Optional;

public class DefaultPlayerDao implements PlayerDao {

    @Autowired
    private PlayerDataRepository playerDataRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserBackConverter userBackConverter;

    @Autowired
    private PlayerDataBackConverter playerDataBackConverter;

    @Autowired
    private UserConverter userConverter;

    @Override
    public void updatePlayerData(Integer id, PlayerData playerData) {
        UserEntity userEntity = userRepository.findById(id).get();
        PlayerDataEntity playerDataEntity = playerDataBackConverter.convert(Optional.of(playerData));

        playerDataRepository.save(playerDataEntity);

        userEntity.setPlayerData(playerDataEntity);
        userRepository.save(userEntity);
    }

    @Override
    public User getById(Integer id) {
        final Optional<UserEntity> userEntity = userRepository.findById(id);
        if(userEntity.isPresent()) {
            return userConverter.convert(userEntity.get());
        }
        return null;
    }
}

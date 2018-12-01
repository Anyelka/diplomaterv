package sports.betting.application.dal.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import sports.betting.application.dal.user.dao.converter.PlayerDataBackConverter;
import sports.betting.application.dal.user.dao.converter.UserBackConverter;
import sports.betting.application.dal.user.entity.PlayerDataEntity;
import sports.betting.application.dal.user.entity.UserEntity;
import sports.betting.application.dal.user.repository.PlayerDataRepository;
import sports.betting.application.dal.user.repository.UserRepository;
import sports.betting.application.domain.user.PlayerData;

public class DefaultPlayerDao implements PlayerDao {

    @Autowired
    private PlayerDataRepository playerDataRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserBackConverter userBackConverter;

    @Autowired
    private PlayerDataBackConverter playerDataBackConverter;

    @Override
    public void updatePlayerData(String username, PlayerData playerData) {
        UserEntity userEntity = userRepository.findByUsername(username);
        PlayerDataEntity playerDataEntity = playerDataBackConverter.convert(playerData);

        playerDataRepository.save(playerDataEntity);

        userEntity.setPlayerData(playerDataEntity);
        userRepository.save(userEntity);
    }
}

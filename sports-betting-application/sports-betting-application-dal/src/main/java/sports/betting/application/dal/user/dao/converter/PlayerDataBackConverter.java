package sports.betting.application.dal.user.dao.converter;

import sports.betting.application.dal.user.entity.PlayerDataEntity;
import sports.betting.application.domain.user.PlayerData;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PlayerDataBackConverter implements Converter<PlayerData, PlayerDataEntity> {

    @Override
    public PlayerDataEntity convert(PlayerData playerData) {
        PlayerDataEntity playerDataEntity = new PlayerDataEntity();
        playerDataEntity.setName(playerData.getName());
        playerDataEntity.setAccountNumber(playerData.getAccountNumber());
        playerDataEntity.setBalance(playerData.getBalance());
        playerDataEntity.setCurrency(playerData.getCurrency());
        playerDataEntity.setDateOfBirth(playerData.getDateOfBirth());
        return playerDataEntity;
    }

}
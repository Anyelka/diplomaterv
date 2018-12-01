package sports.betting.application.dal.user.dao.converter;

import sports.betting.application.dal.user.entity.PlayerDataEntity;
import sports.betting.application.domain.user.PlayerData;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PlayerDataConverter implements Converter<PlayerDataEntity, PlayerData> {

    @Override
    public PlayerData convert(PlayerDataEntity source) {
        PlayerData playerData = new PlayerData();
        playerData.setName(source.getName());
        playerData.setAccountNumber(source.getAccountNumber());
        playerData.setBalance(source.getBalance());
        playerData.setCurrency(source.getCurrency().toString());
        playerData.setDateOfBirth(source.getDateOfBirth().toString());
        return playerData;
    }

}

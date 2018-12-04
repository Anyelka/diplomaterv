package sports.betting.application.dal.user.dao.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sports.betting.application.dal.user.entity.PlayerDataEntity;
import sports.betting.application.domain.user.PlayerData;
import sports.betting.application.lib.formatter.DateFormatter;

import java.util.Currency;

@Component
public class PlayerDataBackConverter implements Converter<PlayerData, PlayerDataEntity> {

    @Autowired
    private DateFormatter dateFormatter;

    @Override
    public PlayerDataEntity convert(PlayerData playerData) {
        PlayerDataEntity playerDataEntity = new PlayerDataEntity();
        playerDataEntity.setName(playerData.getName());
        playerDataEntity.setAccountNumber(playerData.getAccountNumber());
        playerDataEntity.setBalance(playerData.getBalance());
        playerDataEntity.setCurrency(Currency.getInstance(playerData.getCurrency()));
        playerDataEntity.setDateOfBirth(dateFormatter.parseDate(playerData.getDateOfBirth()));
        return playerDataEntity;
    }

}
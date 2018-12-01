package sports.betting.application.dal.user.dao.converter;

import sports.betting.application.dal.user.entity.PlayerDataEntity;
import sports.betting.application.domain.user.PlayerData;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Currency;

@Component
public class PlayerDataBackConverter implements Converter<PlayerData, PlayerDataEntity> {

    @Override
    public PlayerDataEntity convert(PlayerData playerData) {
        PlayerDataEntity playerDataEntity = new PlayerDataEntity();
        playerDataEntity.setName(playerData.getName());
        playerDataEntity.setAccountNumber(playerData.getAccountNumber());
        playerDataEntity.setBalance(playerData.getBalance());
        playerDataEntity.setCurrency(Currency.getInstance(playerData.getCurrency()));
        playerDataEntity.setDateOfBirth(LocalDate.parse(playerData.getDateOfBirth()));
        return playerDataEntity;
    }

}
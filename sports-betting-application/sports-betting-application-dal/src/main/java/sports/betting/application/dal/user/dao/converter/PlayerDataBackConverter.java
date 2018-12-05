package sports.betting.application.dal.user.dao.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sports.betting.application.dal.user.entity.PlayerDataEntity;
import sports.betting.application.domain.user.PlayerData;
import sports.betting.application.lib.formatter.DateFormatter;

import java.util.Currency;
import java.util.Optional;

@Component
public class PlayerDataBackConverter implements Converter<Optional<PlayerData>, PlayerDataEntity> {

    @Autowired
    private DateFormatter dateFormatter;

    @Override
    public PlayerDataEntity convert(Optional<PlayerData> playerData) {
        if(playerData.isPresent()){
            PlayerDataEntity playerDataEntity = new PlayerDataEntity();
            playerDataEntity.setName(playerData.get().getName());
            playerDataEntity.setAccountNumber(playerData.get().getAccountNumber());
            playerDataEntity.setBalance(playerData.get().getBalance());
            playerDataEntity.setCurrency(Currency.getInstance(playerData.get().getCurrency()));
            playerDataEntity.setDateOfBirth(dateFormatter.parseDate(playerData.get().getDateOfBirth()));
            return playerDataEntity;
        }
        return null;
    }

}
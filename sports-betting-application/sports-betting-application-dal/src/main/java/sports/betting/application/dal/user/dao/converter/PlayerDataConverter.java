package sports.betting.application.dal.user.dao.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sports.betting.application.dal.user.entity.PlayerDataEntity;
import sports.betting.application.domain.user.PlayerData;

import java.util.Optional;

@Component
public class PlayerDataConverter implements Converter<PlayerDataEntity, Optional<PlayerData>> {

    @Override
    public Optional<PlayerData> convert(PlayerDataEntity source) {
        if(source != null) {
            PlayerData playerData = new PlayerData();
            playerData.setName(source.getName());
            playerData.setAccountNumber(source.getAccountNumber());
            playerData.setBalance(source.getBalance());
            playerData.setCurrency(source.getCurrency().toString());
            playerData.setDateOfBirth(source.getDateOfBirth().toString());
            return Optional.of(playerData);
        }
        return Optional.empty();
    }

}

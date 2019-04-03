package sports.betting.application.web.user.converter;

import sports.betting.application.domain.user.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sports.betting.application.web.user.model.request.SaveAccountDetailsRequest;

@Component
public class AccountDetailsConverter implements Converter<User, SaveAccountDetailsRequest> {

    @Override
    public SaveAccountDetailsRequest convert(User player) {
        SaveAccountDetailsRequest accountDetailsRequest = new SaveAccountDetailsRequest();
        accountDetailsRequest.setUsername(player.getUsername());
        accountDetailsRequest.setName(player.getPlayerData().get().getName());
        accountDetailsRequest.setDateOfBirth(player.getPlayerData().get().getDateOfBirth().toString());
        accountDetailsRequest.setAccountNumber(player.getPlayerData().get().getAccountNumber());
        accountDetailsRequest.setBalance(player.getPlayerData().get().getBalance());
        accountDetailsRequest.setCurrency(player.getPlayerData().get().getCurrency().toString());
        accountDetailsRequest.setVersion(player.getVersion());
        return accountDetailsRequest;
    }

}

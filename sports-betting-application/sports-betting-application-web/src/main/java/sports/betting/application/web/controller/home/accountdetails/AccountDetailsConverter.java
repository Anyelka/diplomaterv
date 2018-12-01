package sports.betting.application.web.controller.home.accountdetails;

import sports.betting.application.domain.user.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AccountDetailsConverter implements Converter<User, SaveAccountDetailsRequest> {

    @Override
    public SaveAccountDetailsRequest convert(User player) {
        SaveAccountDetailsRequest accountDetailsRequest = new SaveAccountDetailsRequest();
        accountDetailsRequest.setUsername(player.getUsername());
        accountDetailsRequest.setName(player.getPlayerData().getName());
        accountDetailsRequest.setDateOfBirth(player.getPlayerData().getDateOfBirth().toString());
        accountDetailsRequest.setAccountNumber(player.getPlayerData().getAccountNumber());
        accountDetailsRequest.setBalance(player.getPlayerData().getBalance());
        accountDetailsRequest.setCurrency(player.getPlayerData().getCurrency().toString());
        accountDetailsRequest.setVersion(player.getVersion());
        return accountDetailsRequest;
    }

}

package home.accountdetails;

import user.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AccountDetailsConverter implements Converter<User, AccountDetailsRequest> {

    @Override
    public AccountDetailsRequest convert(User player) {
        AccountDetailsRequest accountDetailsRequest = new AccountDetailsRequest();
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

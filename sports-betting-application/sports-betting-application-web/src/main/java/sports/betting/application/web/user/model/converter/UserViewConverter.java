package sports.betting.application.web.user.model.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sports.betting.application.domain.user.PlayerData;
import sports.betting.application.domain.user.User;
import sports.betting.application.web.user.model.view.UserView;

@Component
public class UserViewConverter implements Converter<User, UserView> {

    @Override
    public UserView convert(User user) {
        UserView userView = new UserView();
        userView.setId(user.getId());
        userView.setEmail(user.getEmail());
        userView.setUsername(user.getUsername());
        final PlayerData emptyPlayerData = new PlayerData("-", "-", 0, "-", "-");
        userView.setFullName(user.getPlayerData().orElse(emptyPlayerData).getName());
        userView.setAccountNumber(user.getPlayerData().orElse(emptyPlayerData).getAccountNumber());
        userView.setDateOfBirth(user.getPlayerData().orElse(emptyPlayerData).getDateOfBirth());
        userView.setBalance(user.getPlayerData().orElse(emptyPlayerData).getBalance());
        userView.setCurrency(user.getPlayerData().orElse(emptyPlayerData).getCurrency());
        return userView;
    }
}

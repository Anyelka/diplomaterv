package sports.betting.application.service.user.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import sports.betting.application.dal.user.dao.PlayerDao;
import sports.betting.application.dal.user.dao.UserDao;
import sports.betting.application.domain.user.PlayerData;
import sports.betting.application.domain.user.User;
import sports.betting.application.domain.user.UserCredentials;
import sports.betting.application.domain.user.UserRole;
import sports.betting.application.service.user.UserService;
import sports.betting.application.service.user.player.validation.PlayerDataValidator;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Currency;
import java.util.Optional;

public class PlayerService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PlayerDao playerDao;

    @Autowired
    private UserService userService;

    @Autowired
    private PlayerDataValidator playerDataValidator;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    public User createPlayer(PlayerData playerData, UserCredentials credentials, boolean enabled) {
        User player = new User();
        player.setPlayerData(Optional.of(playerData));
        player.setEnabled(enabled);

        player.setEmail(credentials.getEmail());
        player.setUsername(credentials.getUsername());
        player.setPassword(bCryptPasswordEncoder.encode(credentials.getPassword()));

        player.getRoles().add(userService.getUserRole("ROLE_PLAYER"));
        return userService.saveUser(player);
    }

    public void increaseBalance(int amount, User player) {
        int initialBalance = player.getPlayerData().get().getBalance();
        player.getPlayerData().get().setBalance(initialBalance + amount);
        userDao.save(player);
    }

    public void decreaseBalance(int amount, User player) {
        int initialBalance = player.getPlayerData().get().getBalance();
        player.getPlayerData().get().setBalance(initialBalance - amount);
        userDao.save(player);
    }

    public User getPlayerById(Integer id) {
        return playerDao.getById(id);
    }

    public User getPlayerByUsername(String username) {
        return userService.getUser(username);
    }

    public UpdatePlayerDataResponse attemptPlayerDataUpdate(String username, String fullName, String dob, String accountNumber) {
        User player = getPlayerByUsername(username);
        final PlayerData playerData = new PlayerData(fullName, accountNumber, player.getPlayerData().get().getBalance(), player.getPlayerData().get().getCurrency(), dob);

        UpdatePlayerDataResponse updatePlayerDataResponse = playerDataValidator.checkUpdatePlayerDataRequest(playerData);
        if (updatePlayerDataResponse.isValid()) {
            playerDao.updatePlayerData(username, playerData);
        }
        return updatePlayerDataResponse;
    }

}

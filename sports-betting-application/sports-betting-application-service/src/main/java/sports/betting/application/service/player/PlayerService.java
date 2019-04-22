package sports.betting.application.service.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import sports.betting.application.dal.user.dao.PlayerDao;
import sports.betting.application.dal.user.dao.UserDao;
import sports.betting.application.domain.user.PlayerData;
import sports.betting.application.domain.user.User;
import sports.betting.application.domain.user.UserCredentials;
import sports.betting.application.service.player.model.request.EditPlayerDataRequest;
import sports.betting.application.service.player.model.response.EditPlayerDataResponse;
import sports.betting.application.service.user.UserService;
import sports.betting.application.service.player.validation.PlayerDataValidator;

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
        return userService.getUser(username).get();
    }

    public EditPlayerDataResponse attemptPlayerDataEdit(EditPlayerDataRequest request) {
        User player = getPlayerById(request.getUserId());

        EditPlayerDataResponse editPlayerDataResponse = playerDataValidator.checkEditPlayerDataRequest(request);
        if (editPlayerDataResponse.isValid()) {
            final PlayerData playerData = new PlayerData(request.getFullName(), request.getAccountNumber(), player.getPlayerData().get().getBalance(), player.getPlayerData().get().getCurrency(), request.getDateOfBirth());
            playerDao.updatePlayerData(request.getUserId(), playerData);
        }
        return editPlayerDataResponse;
    }
}

package sports.betting.application.service;

import java.time.LocalDate;
import java.util.ConcurrentModificationException;
import java.util.Currency;

import sports.betting.application.dal.user.dao.UserDao;
import sports.betting.application.domain.user.PlayerData;
import sports.betting.application.domain.user.User;
import sports.betting.application.domain.user.UserCredentials;
import sports.betting.application.domain.user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;

public class PlayerService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    public User createPlayer(PlayerData playerData, UserCredentials credentials, boolean enabled) {
        User player = new User();
        player.setPlayerData(playerData);
        UserRole playerRole = userService.getUserRole(TestDataGenerator.USER_ROLE_PLAYER);
        player.setEnabled(enabled);
        userService.saveUser(player, credentials, playerRole);

        return player;
    }

    public void increaseBalance(int amount, User player) {
        int initialBalance = player.getPlayerData().getBalance();
        player.getPlayerData().setBalance(initialBalance + amount);
        userDao.save(player);
    }

    public void decreaseBalance(int amount, User player) {
        int initialBalance = player.getPlayerData().getBalance();
        player.getPlayerData().setBalance(initialBalance - amount);
        userDao.save(player);
    }

    public User getPlayerById(Integer id) {
        return userDao.getById(id);
    }

    public User getPlayerByUsername(String username) {
        return userService.getUser(username);
    }

    public User getPlayerByFullName(String name) {
        return userDao.getPlayerByFullName(name);
    }

    public void updatePlayer(String name, String dob, String accountNumber, int version) {
        User player = getPlayerByUsername(name);
        player.setVersion(version);
        player.getPlayerData().setName(name);
        player.getPlayerData().setDateOfBirth(LocalDate.parse(dob));
        player.getPlayerData().setAccountNumber(accountNumber);

        try {
            userDao.save(player);
        }

        catch (OptimisticLockingFailureException ex) {
            throw new ConcurrentModificationException(ex);
        }

    }

}

package service;

import java.time.LocalDate;
import java.util.ConcurrentModificationException;
import java.util.Currency;

import org.sports.betting.application.dal.user.dao.UserDao;
import user.PlayerData;
import user.User;
import user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;

public class PlayerService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    public User createPlayer(String[] data, String[] credentials, boolean enabled) {
        String name = data[0];
        String accountNumber = data[1];
        int balance = Integer.parseInt(data[2]);
        Currency currency = Currency.getInstance(data[3]);
        LocalDate dob = LocalDate.parse(data[4]);

        User player = new User();
        player.setPlayerData(new PlayerData(name, accountNumber, balance, currency, dob));
        UserRole playerRole = userService.getUserRole(TestDataGenerator.USER_ROLE_PLAYER);
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

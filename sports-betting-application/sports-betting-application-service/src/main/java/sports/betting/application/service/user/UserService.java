package sports.betting.application.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sports.betting.application.dal.user.dao.PlayerDao;
import sports.betting.application.dal.user.dao.UserDao;
import sports.betting.application.dal.user.dao.UserRoleDao;
import sports.betting.application.domain.user.PlayerData;
import sports.betting.application.domain.user.User;
import sports.betting.application.domain.user.UserCredentials;
import sports.betting.application.domain.user.UserRole;
import sports.betting.application.service.user.player.UpdatePlayerDataResponse;

import java.net.URLEncoder;
import java.util.Currency;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;
    private PlayerDao playerDao;

    public User saveUser(User user) {
        userDao.save(user);
        return user;
    }

    public void createUserRole(String role) {
        userRoleDao.save(new UserRole(role));
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

    public User getUser(int id) {
        return userDao.getById(id);
    }

    public User getUser(String username) {
        return userDao.getByUsername(username);
    }

    public UserRole getUserRole(String role) {
        return userRoleDao.getByName(role);
    }

    public boolean checkIfUserExists(String username) {
        return userDao.checkIfUserExists(username);
    }

    public User createAdmin(UserCredentials credentials) {
        User user = new User();
        user.setUsername(credentials.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(credentials.getPassword()));
        user.setEmail(credentials.getEmail());
        user.getRoles().add(getUserRole("ROLE_ADMIN"));
        user.setEnabled(true);
        user.setPlayerData(Optional.empty());
        return saveUser(user);
    }

    public boolean isAdmin(User user) {
        return !user.getRoles().stream().filter(role -> role.getName().equals("ROLE_ADMIN")).collect(Collectors.toList()).isEmpty();
    }

    public boolean isPlayer(User user) {
        return !user.getRoles().stream().filter(role -> role.getName().equals("ROLE_PLAYER")).collect(Collectors.toList()).isEmpty();

    }

    public UpdateUserDataResponse attemptUserDataUpdate(int id, String email, String userName, String fullName, String accountNumber, int balance, String currency, String dateOfBirth) {
        UpdateUserDataResponse updateUserDataResponse = new UpdateUserDataResponse();
        User user = userDao.getById(id);
        PlayerData playerData = new PlayerData(fullName, accountNumber, balance, currency, dateOfBirth);
        playerDao.updatePlayerData(user.getUsername(), playerData);
        user.setEmail(email);
        user.setUsername(userName);
        userDao.save(user);
        return updateUserDataResponse;
    }

}

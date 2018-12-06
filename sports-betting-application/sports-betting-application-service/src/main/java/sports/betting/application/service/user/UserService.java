package sports.betting.application.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sports.betting.application.dal.user.dao.UserDao;
import sports.betting.application.dal.user.dao.UserRoleDao;
import sports.betting.application.domain.user.PlayerData;
import sports.betting.application.domain.user.User;
import sports.betting.application.domain.user.UserCredentials;
import sports.betting.application.domain.user.UserRole;

import java.net.URLEncoder;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserService {
        
    @Autowired 
    UserDao userDao;
    
    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    public User saveUser(User user) {
        userDao.save(user);
        return user;
    }
    
    public void createUserRole(String role) {
        userRoleDao.save(new UserRole(role));
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
    
}

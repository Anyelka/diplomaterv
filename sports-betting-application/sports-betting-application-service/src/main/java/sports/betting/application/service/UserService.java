package sports.betting.application.service;

import java.util.HashSet;
import java.util.Set;

import sports.betting.application.dal.user.dao.UserDao;
import sports.betting.application.dal.user.dao.UserRoleDao;
import sports.betting.application.domain.user.User;
import sports.betting.application.domain.user.UserCredentials;
import sports.betting.application.domain.user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserService {
        
    @Autowired 
    UserDao userDao;
    
    @Autowired
    private UserRoleDao userRoleDao;
    
    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    
    public User saveUser(User user, UserCredentials credentials, UserRole role) {
        User savedUser = user;
        savedUser.setUsername(credentials.getUsername());
        savedUser.setPassword(bCryptPasswordEncoder.encode(credentials.getPassword()));
        savedUser.setEmail(credentials.getEmail());
        
        Set<UserRole> roles = new HashSet<UserRole>();
        roles.add(role);
        savedUser.setRoles(roles);
        
        userDao.save(savedUser);
        
        return savedUser;
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
    
}

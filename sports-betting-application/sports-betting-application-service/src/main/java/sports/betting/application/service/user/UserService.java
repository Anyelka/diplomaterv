package sports.betting.application.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import sports.betting.application.dal.user.dao.UserDao;
import sports.betting.application.dal.user.dao.UserRoleDao;
import sports.betting.application.domain.user.User;
import sports.betting.application.domain.user.UserRole;

public class UserService {
        
    @Autowired 
    UserDao userDao;
    
    @Autowired
    private UserRoleDao userRoleDao;
    
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
    
}

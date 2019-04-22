package sports.betting.application.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import sports.betting.application.dal.user.dao.PlayerDao;
import sports.betting.application.dal.user.dao.UserDao;
import sports.betting.application.dal.user.dao.UserRoleDao;
import sports.betting.application.domain.user.PlayerData;
import sports.betting.application.domain.user.User;
import sports.betting.application.domain.user.UserCredentials;
import sports.betting.application.domain.user.UserRole;
import sports.betting.application.service.user.model.request.DeleteUserRequest;
import sports.betting.application.service.user.model.request.EditUserRequest;
import sports.betting.application.service.user.model.response.DeleteUserResponse;
import sports.betting.application.service.user.model.response.EditUserResponse;

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

    @Autowired
    private PlayerDao playerDao;

    @Autowired
    private UserValidator userValidator;

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

    public Optional<User> getUser(String username) {
        return userDao.getByUsername(username);
    }

    public UserRole getUserRole(String role) {
        return userRoleDao.getByName(role);
    }

    public boolean checkIfUserExists(String username) {
        return userDao.checkIfUserExists(username);
    }

    public boolean checkIfDifferentUserExistsWithSameUsername(String username, int userId) {
        return userDao.checkIfDifferentUserExistsWithSameUsername(username, userId);
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

    public EditUserResponse attemptEditUser(EditUserRequest request) {
        EditUserResponse response = userValidator.checkUserEditRequest(request);
        if(response.isValid()) {
            edit(request);
        }
        return response;
    }

    private void edit(EditUserRequest request) {
        User user = getUser(request.getUserId());
        user.setEmail(request.getUserEmail());
        user.setUsername(request.getUsername());
        userDao.save(user);
        PlayerData playerData = new PlayerData(request.getUserFullName(),request.getUserAccountNumber(), request.getUserBalance(),request.getUserCurrency(),request.getUserDateOfBirth());
        playerDao.updatePlayerData(request.getUserId(), playerData);
    }

    public DeleteUserResponse attemptUserDelete(DeleteUserRequest request) {
        DeleteUserResponse response = userValidator.checkUserDeleteRequest(request);
        if(response.isValid()) {
            delete(request.getUsername());
        }
        return response;
    }

    @Transactional
    public void delete(String username) {
        userDao.delete(username);
    }
}

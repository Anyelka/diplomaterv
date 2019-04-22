package sports.betting.application.dal.user.dao;

import sports.betting.application.domain.user.User;

import java.util.Currency;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    public List<User> getAll();
    public User getById(int id);
    public Optional<User> getByUsername(String username);
    public User getPlayerByFullName(String name);
    public void save(User user);
    public boolean checkIfUserExists(String username);
    public boolean checkIfDifferentUserExistsWithSameUsername(String username, int userId);
    public void delete(String username);
}

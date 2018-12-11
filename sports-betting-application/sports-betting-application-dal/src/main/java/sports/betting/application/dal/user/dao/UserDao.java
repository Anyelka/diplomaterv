package sports.betting.application.dal.user.dao;

import sports.betting.application.domain.user.User;

import java.util.List;

public interface UserDao {
    public List<User> getAll();
    public User getById(int id);
    public User getByUsername(String username);
    public User getPlayerByFullName(String name);
    public void save(User user);
    public boolean checkIfUserExists(String username);
}

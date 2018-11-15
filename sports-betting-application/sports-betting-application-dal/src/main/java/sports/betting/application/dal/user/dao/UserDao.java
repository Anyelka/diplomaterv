package sports.betting.application.dal.user.dao;

import sports.betting.application.domain.user.User;

public interface UserDao {
    public User getById(int id);
    public User getByUsername(String username);
    public User getPlayerByFullName(String name);
    public void save(User user);
}

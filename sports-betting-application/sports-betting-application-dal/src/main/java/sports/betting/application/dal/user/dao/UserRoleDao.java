package sports.betting.application.dal.user.dao;

import sports.betting.application.domain.user.UserRole;

public interface UserRoleDao {
    public UserRole getByName(String name);
    public void save(UserRole role);
}

package org.sports.betting.application.dal.user.dao;

import user.UserRole;

public interface UserRoleDao {
    public UserRole getByName(String name);
    public void save(UserRole role);
}

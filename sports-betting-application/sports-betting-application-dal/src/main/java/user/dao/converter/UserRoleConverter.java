package org.sports.betting.application.dal.user.dao.converter;

import org.sports.betting.application.dal.user.entity.UserRoleEntity;
import user.UserRole;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserRoleConverter implements Converter<UserRoleEntity, UserRole> {

    @Override
    public UserRole convert(UserRoleEntity source) {
        UserRole userRole = new UserRole();
        userRole.setId(source.getId());
        userRole.setName(source.getName());
        return userRole;
    }

}

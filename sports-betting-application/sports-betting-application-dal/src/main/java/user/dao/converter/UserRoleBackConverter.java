package org.sports.betting.application.dal.user.dao.converter;

import org.sports.betting.application.dal.user.entity.UserRoleEntity;
import user.UserRole;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserRoleBackConverter implements Converter<UserRole, UserRoleEntity>{
    
    @Override
    public UserRoleEntity convert(UserRole source) {
        UserRoleEntity userRoleEntity = new UserRoleEntity();
        userRoleEntity.setId(source.getId());
        userRoleEntity.setName(source.getName());
        return userRoleEntity;
    }
    
}

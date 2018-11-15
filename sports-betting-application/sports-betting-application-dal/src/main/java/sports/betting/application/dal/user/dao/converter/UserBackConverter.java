package sports.betting.application.dal.user.dao.converter;

import java.util.stream.Collectors;

import sports.betting.application.dal.user.entity.UserEntity;
import sports.betting.application.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserBackConverter implements Converter<User, UserEntity> {

    @Autowired
    private UserRoleBackConverter userRoleBackConverter;
    
    @Override
    public UserEntity convert(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setEmail(user.getEmail());
        userEntity.setEnabled(user.isEnabled());
        userEntity.setRoles(user.getRoles().stream().map(userRole -> userRoleBackConverter.convert(userRole)).collect(Collectors.toSet()));
        userEntity.setVersion(user.getVersion());
        return userEntity;
    }

}

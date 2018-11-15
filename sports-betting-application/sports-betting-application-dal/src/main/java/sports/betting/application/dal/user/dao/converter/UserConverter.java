package sports.betting.application.dal.user.dao.converter;

import java.util.stream.Collectors;

import sports.betting.application.dal.user.entity.UserEntity;
import sports.betting.application.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<UserEntity, User> {

    @Autowired
    private UserRoleConverter userRoleConverter;
    
    @Autowired
    private PlayerDataConverter playerDataConverter;
    
    @Override
    public User convert(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());
        user.setEmail(userEntity.getEmail());
        user.setEnabled(userEntity.isEnabled());
        user.setRoles(userEntity.getRoles().stream().map(roleEntity -> userRoleConverter.convert(roleEntity)).collect(Collectors.toSet()));
        user.setPlayerData(playerDataConverter.convert(userEntity.getPlayerData()));
        user.setVersion(userEntity.getVersion());
        return user;
    }
    
}

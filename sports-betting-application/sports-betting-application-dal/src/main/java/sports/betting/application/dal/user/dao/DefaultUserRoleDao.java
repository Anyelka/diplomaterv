package sports.betting.application.dal.user.dao;

import sports.betting.application.dal.user.dao.converter.UserRoleBackConverter;
import sports.betting.application.dal.user.dao.converter.UserRoleConverter;
import sports.betting.application.dal.user.repository.UserRoleRepository;
import sports.betting.application.domain.user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;

public class DefaultUserRoleDao implements UserRoleDao {

    @Autowired 
    private UserRoleRepository userRoleRepository;
    
    @Autowired
    private UserRoleBackConverter userRoleBackConverter;

    @Autowired
    private UserRoleConverter userRoleConverter;
    
    @Override
    public void save(UserRole role) {
        userRoleRepository.save(userRoleBackConverter.convert(role));
    }

    @Override
    public UserRole getByName(String name) {
        return userRoleConverter.convert(userRoleRepository.findByName(name));
    }

}

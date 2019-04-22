package sports.betting.application.web.user.model.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sports.betting.application.domain.user.User;
import sports.betting.application.web.user.model.view.UserListView;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserListConverter implements Converter<List<User>, UserListView> {

    @Autowired
    private UserViewConverter userViewConverter;

    @Override
    public UserListView convert(List<User> users) {
        return new UserListView(users.stream().map(user -> userViewConverter.convert(user)).collect(Collectors.toList()));
    }
}

package sports.betting.application.web.user.model.view;

import java.util.List;

public class UserListView {

    private List<UserView> users;

    public UserListView(List<UserView> users) {
        this.users = users;
    }

    public List<UserView> getUsers() {
        return users;
    }
}

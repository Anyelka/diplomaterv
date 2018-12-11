package sports.betting.application.web.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import sports.betting.application.service.user.UserService;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserListConverter userListConverter;

    @ModelAttribute("userListView")
    public UserListView userList() {
        return userListConverter.convert(userService.getAll());
    }

    @RequestMapping("admin_users.html")
    public String usersPage() {
        return "admin_users";
    }
}

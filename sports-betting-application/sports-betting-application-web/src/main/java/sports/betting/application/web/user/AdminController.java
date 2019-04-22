package sports.betting.application.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import sports.betting.application.service.user.UserService;
import sports.betting.application.web.user.model.converter.UserListConverter;
import sports.betting.application.web.user.model.view.UserListView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserListConverter userListConverter;

    @ModelAttribute("userListView")
    public UserListView userList() {
        return userListConverter.convert(userService.getAll());
    }

    @RequestMapping("users")
    public String usersPage() {
        return "admin_users";
    }

}

package sports.betting.application.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sports.betting.application.service.user.UpdateUserDataResponse;
import sports.betting.application.service.user.UserService;
import sports.betting.application.web.user.converter.UserListConverter;
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

    @RequestMapping("editUser")
    public @ResponseBody
    UpdateUserDataResponse editUser(@RequestParam(value="userId") final int id,
                                    @RequestParam(value="userEmail") final String email,
                                    @RequestParam(value="userName") final String userName,
                                    @RequestParam(value="userFullName") final String fullName,
                                    @RequestParam(value="userAccountNumber") final String accountNumber,
                                    @RequestParam(value="userBalance") final int balance,
                                    @RequestParam(value="userCurrency") final String currency,
                                    @RequestParam(value="dateOfBirth") final String dateOfBirth
    ) {
        return userService.attemptUserDataUpdate(id, email, userName, fullName, accountNumber, balance, currency, dateOfBirth);
    }
}

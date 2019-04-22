package sports.betting.application.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sports.betting.application.service.user.UserService;
import sports.betting.application.service.user.model.request.DeleteUserRequest;
import sports.betting.application.service.user.model.request.EditUserRequest;
import sports.betting.application.service.user.model.response.DeleteUserResponse;
import sports.betting.application.service.user.model.response.EditUserResponse;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "edit", method = RequestMethod.POST, consumes = "application/json")
    public EditUserResponse editUser(@RequestBody EditUserRequest request) {
        return userService.attemptEditUser(request);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST, consumes = "application/json")
    public DeleteUserResponse deleteUser(@RequestBody DeleteUserRequest request) {
        return userService.attemptUserDelete(request);
    }

}

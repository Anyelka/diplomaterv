package sports.betting.application.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sports.betting.application.domain.user.User;
import sports.betting.application.lib.validate.FormatValidator;
import sports.betting.application.service.player.validation.PlayerDataValidator;
import sports.betting.application.service.user.model.converter.EditUserRequestConverter;
import sports.betting.application.service.user.model.converter.EditUserResponseConverter;
import sports.betting.application.service.user.model.request.DeleteUserRequest;
import sports.betting.application.service.user.model.request.EditUserRequest;
import sports.betting.application.service.user.model.response.DeleteUserResponse;
import sports.betting.application.service.user.model.response.EditUserResponse;

import java.util.Optional;

@Component
public class UserValidator {

    @Autowired
    private UserService userService;

    @Autowired
    private PlayerDataValidator playerDataValidator;

    @Autowired
    private FormatValidator validator;

    @Autowired
    private EditUserRequestConverter editUserRequestConverter;

    @Autowired
    private EditUserResponseConverter editUserResponseConverter;

    public EditUserResponse checkUserEditRequest(EditUserRequest request) {
        EditUserResponse response = editUserResponseConverter.convert(playerDataValidator.checkEditPlayerDataRequest(editUserRequestConverter.convert(request)));
        response.setUsernameError(getUsernameError(request.getUsername(), request.getUserId()));
        response.setEmailError(getEmailError(request.getUserEmail()));
        return response;
    }

    public DeleteUserResponse checkUserDeleteRequest(DeleteUserRequest request) {
        DeleteUserResponse response = new DeleteUserResponse();
        response.setUsernameError(getNonExistingUsernameError(request.getUsername()));
        return response;
    }

    private String getUsernameError(String username, int userId) {
        if (username.isEmpty()) {
            return "The username field can't be empty!";
        }
        if (userService.checkIfDifferentUserExistsWithSameUsername(username, userId)) {
            return "The given username is already used by someone else!";
        }
        if (username.length() < 4) {
            return "The username must be at least 4 characters long!";
        }
        return "";
    }

    private String getEmailError(String email) {
        if(email.isEmpty()) {
            return "The email field can't be empty!";
        }
        if(!validator.isValidEmailFormat(email)) {
            return "The email must be in the format:'example@gmail.com'";
        }
        return "";
    }

    private String getNonExistingUsernameError(String username) {
        Optional<User> user = userService.getUser(username);
        if(!user.isPresent()) {
            return "There is no user with the given username in the database!";
        }
        return "";
    }
}

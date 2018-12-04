package sports.betting.application.service.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sports.betting.application.domain.user.PlayerData;
import sports.betting.application.domain.user.UserCredentials;
import sports.betting.application.lib.validate.FormatValidator;
import sports.betting.application.service.user.UserService;

@Component
public class RegistrationValidator {

    @Autowired
    private UserService userService;

    @Autowired
    private FormatValidator validator;

    public RegistrationResponse checkRegistrationRequest(PlayerData playerData, UserCredentials credentials) {
        RegistrationResponse response = new RegistrationResponse();
        response.setUsernameError(getUsernameError(credentials.getUsername()));
        response.setEmailError(getEmailError(credentials.getEmail()));
        response.setPasswordError(getPasswordError(credentials.getPassword()));
        response.setFullNameError(getFullNameError(playerData.getName()));
        response.setAccountNumberError(getAccountNumberError(playerData.getAccountNumber()));
        response.setDateOfBirthError(getDateOfBirthError(playerData.getDateOfBirth()));
        return response;
    }

    private String getUsernameError(String username) {
        if (username.isEmpty()) {
            return "The username field can't be empty!";
        }
        if (userService.checkIfUserExists(username)) {
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

    private String getPasswordError(String password) {
        if(password.isEmpty()) {
            return "The password field can't be empty!";
        }
        if(password.length() < 6) {
            return "The password must be at least 6 characters long!";
        }
        return "";
    }

    private String getFullNameError(String name) {
        if(name.isEmpty()) {
            return "The full name field can't be empty";
        }
        return "";
    }

    private String getAccountNumberError(String accountNumber) {
        if(accountNumber.isEmpty()) {
            return "The account number field can't be empty";
        }
        return "";
    }

    private String getDateOfBirthError(String dateOfBirth) {
        if(dateOfBirth.isEmpty()) {
            return "The date of birth field can't be empty!";
        }
        if (!validator.isValidDateFormat(dateOfBirth)) {
            return "The given birth date is in wrong format!";
        }
        if(validator.isDateLessThanEighteenYearsAgo(dateOfBirth)) {
            return "You must be at least 18 years old to register!";
        }
        return "";
    }

}

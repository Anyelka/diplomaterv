package sports.betting.application.service.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sports.betting.application.domain.user.PlayerData;
import sports.betting.application.domain.user.UserCredentials;
import sports.betting.application.service.formatter.DateFormatter;
import sports.betting.application.service.user.UserService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Component
public class RegistrationValidator {

    @Autowired
    private UserService userService;

    @Autowired
    private DateFormatter dateFormatter;

    public RegistrationResponse checkRegistrationRequest(PlayerData playerData, UserCredentials credentials) {
        RegistrationResponse response = new RegistrationResponse();
        response.setUsernameError(getUsernameError(credentials.getUsername()));
        response.setDateOfBirthError(getDateOfBirthError(playerData.getDateOfBirth()));
        /*TODO:
        * check email format
        * check password complexity
        * check what ???
        * */
        return response;
    }


    private String getUsernameError(String username) {
        if(userService.checkIfUserExists(username)) {
            return "The given username is already used by someone else!";
        }
        return "";
    }

    private String getDateOfBirthError(String dateOfBirth) {
        try{
            dateFormatter.parseDate(dateOfBirth);
        } catch (DateTimeParseException e){
            return "The given birth date is in wrong format!";
        }
        return "";
    }
}

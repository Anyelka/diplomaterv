package sports.betting.application.service.user.player.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sports.betting.application.domain.user.PlayerData;
import sports.betting.application.lib.validate.FormatValidator;
import sports.betting.application.service.user.player.UpdatePlayerDataResponse;

@Component
public class PlayerDataValidator {

    @Autowired
    private FormatValidator validator;

    public UpdatePlayerDataResponse checkUpdatePlayerDataRequest(PlayerData playerData) {
        UpdatePlayerDataResponse response= new UpdatePlayerDataResponse();
        response.setFullNameError(getFullNameError(playerData.getName()));
        response.setDateOfBirthError(getDateOfBirthError(playerData.getDateOfBirth()));
        response.setAccountNumberError(getAccountNumberError(playerData.getAccountNumber()));
        return response;
    }

    private String getFullNameError(String name) {
        if(name.isEmpty()) {
            return "The full name field can't be empty";
        }
        return "";
    }

    private String getDateOfBirthError(String dateOfBirth) {
        if(dateOfBirth.isEmpty()) {
            return "The date of birth field can't be empty!";
        }
        if(!validator.isValidDateFormat(dateOfBirth)){
            return "The given date of birth was in the wrong format!";
        }
        if(validator.isDateLessThanEighteenYearsAgo(dateOfBirth)) {
            return "You must be at least 18 years old to play!";
        }
        return "";
    }

    private String getAccountNumberError(String accountNumber) {
        if(accountNumber.isEmpty()) {
            return "The account number field can't be empty";
        }
        return "";
    }
}

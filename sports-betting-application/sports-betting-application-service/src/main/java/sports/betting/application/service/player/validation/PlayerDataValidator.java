package sports.betting.application.service.player.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sports.betting.application.domain.user.PlayerData;
import sports.betting.application.lib.validate.FormatValidator;
import sports.betting.application.service.player.model.request.EditPlayerDataRequest;
import sports.betting.application.service.player.model.response.EditPlayerDataResponse;

@Component
public class PlayerDataValidator {

    @Autowired
    private FormatValidator validator;

    public EditPlayerDataResponse checkEditPlayerDataRequest(EditPlayerDataRequest request) {
        EditPlayerDataResponse response= new EditPlayerDataResponse();
        response.setFullNameError(getFullNameError(request.getFullName()));
        response.setDateOfBirthError(getDateOfBirthError(request.getDateOfBirth()));
        response.setAccountNumberError(getAccountNumberError(request.getAccountNumber()));
        response.setBalanceError(getBalanceError(request.getBalance()));
        response.setCurrencyError(getCurrencyError(request.getCurrency()));
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
            return "The account number field can't be empty!";
        }
        return "";
    }

    private String getBalanceError(String balance) {
        if (!validator.isValidMoneyFormat(balance)) {
            return "The balance field is not a number!";
        } else if(!validator.isPositiveMoney(balance)) {
            return "The balance must be positive!";
        }
        return "";
    }

    private String getCurrencyError(String currency) {
        if(!validator.isValidCurrencyFormat(currency)){
            return "The given currency is not valid!";
        }
        return "";
    }
}

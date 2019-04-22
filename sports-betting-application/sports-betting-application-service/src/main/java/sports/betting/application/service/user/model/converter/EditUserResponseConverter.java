package sports.betting.application.service.user.model.converter;

import org.springframework.stereotype.Component;
import sports.betting.application.service.player.model.response.EditPlayerDataResponse;
import sports.betting.application.service.user.model.response.EditUserResponse;

@Component
public class EditUserResponseConverter {

    public EditUserResponse convert(EditPlayerDataResponse editPlayerDataResponse) {
        EditUserResponse editUserResponse = new EditUserResponse();
        editUserResponse.setFullNameError(editPlayerDataResponse.getFullNameError());
        editUserResponse.setAccountNumberError(editPlayerDataResponse.getAccountNumberError());
        editUserResponse.setBalanceError(editPlayerDataResponse.getBalanceError());
        editUserResponse.setCurrencyError(editPlayerDataResponse.getCurrencyError());
        editUserResponse.setDateOfBirthError(editPlayerDataResponse.getDateOfBirthError());
        return editUserResponse;
    }
}

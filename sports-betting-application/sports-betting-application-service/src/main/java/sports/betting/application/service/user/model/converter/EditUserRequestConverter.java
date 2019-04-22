package sports.betting.application.service.user.model.converter;

import org.springframework.stereotype.Component;
import sports.betting.application.service.player.model.request.EditPlayerDataRequest;
import sports.betting.application.service.user.model.request.EditUserRequest;

@Component
public class EditUserRequestConverter {

    public EditPlayerDataRequest convert(EditUserRequest editUserRequest) {
        EditPlayerDataRequest editPlayerDataRequest = new EditPlayerDataRequest();
        editPlayerDataRequest.setUserId(editUserRequest.getUserId());
        editPlayerDataRequest.setFullName(editUserRequest.getUserFullName());
        editPlayerDataRequest.setAccountNumber(editUserRequest.getUserAccountNumber());
        editPlayerDataRequest.setBalance(editUserRequest.getUserBalance());
        editPlayerDataRequest.setCurrency(editUserRequest.getUserCurrency());
        editPlayerDataRequest.setDateOfBirth(editUserRequest.getUserDateOfBirth());
        return editPlayerDataRequest;
    }

}

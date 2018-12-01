package sports.betting.application.service.user.player.validation;

import org.springframework.stereotype.Component;
import sports.betting.application.domain.user.PlayerData;
import sports.betting.application.service.user.player.UpdatePlayerDataResponse;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Optional;

@Component
public class PlayerDataValidator {

    public UpdatePlayerDataResponse checkUpdatePlayerDataRequest(PlayerData playerData) {
        UpdatePlayerDataResponse updatePlayerDataResponse = new UpdatePlayerDataResponse();
        updatePlayerDataResponse.setDateOfBirthError(checkDateOfBirthErrors(playerData.getDateOfBirth()));
        return updatePlayerDataResponse;
    }

    private Optional<String> checkDateOfBirthErrors(String dateOfBirth) {
        try {
            LocalDate.parse(dateOfBirth);
        } catch (DateTimeParseException e) {
            return Optional.of("The given date of birth was in the wrong format!");
        }
        return Optional.empty();
    }
}

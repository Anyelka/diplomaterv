package sports.betting.application.service.user.player;

import java.util.Optional;

public class UpdatePlayerDataResponse {

    private Optional<String> dateOfBirthError;

    public UpdatePlayerDataResponse() {
        this.dateOfBirthError = Optional.empty();
    }

    public boolean isValid(){
        return !dateOfBirthError.isPresent();
    }

    public Optional<String> getDateOfBirthError() {
        return dateOfBirthError;
    }

    public void setDateOfBirthError(Optional<String> dateOfBirthError) {
        this.dateOfBirthError = dateOfBirthError;
    }

}

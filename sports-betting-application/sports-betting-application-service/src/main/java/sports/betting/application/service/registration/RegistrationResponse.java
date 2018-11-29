package sports.betting.application.service.registration;

import java.util.Optional;

public class RegistrationResponse {

    private Optional<String> usernameError;
    private Optional<String> emailError;
    private Optional<String> passwordError;

    private Optional<String> dateOfBirthError;

    public RegistrationResponse() {
        this.usernameError = Optional.empty();
        this.emailError = Optional.empty();
        this.passwordError = Optional.empty();
        this.dateOfBirthError = Optional.empty();
    }

    public boolean isValid() {
        return !usernameError.isPresent() && !emailError.isPresent() && !passwordError.isPresent() && !dateOfBirthError.isPresent();
    }

    public Optional<String> getUsernameError() {
        return usernameError;
    }

    public void setUsernameError(Optional<String> usernameError) {
        this.usernameError = usernameError;
    }
}

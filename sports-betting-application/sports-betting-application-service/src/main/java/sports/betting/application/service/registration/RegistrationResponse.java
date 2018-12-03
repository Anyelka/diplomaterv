package sports.betting.application.service.registration;

public class RegistrationResponse {

    private boolean valid;

    private String usernameError;
    private String emailError;
    private String passwordError;

    private String dateOfBirthError;

    public RegistrationResponse() {
        this.valid = true;
        this.usernameError = "";
        this.emailError = "";
        this.passwordError = "";
        this.dateOfBirthError = "";
    }

    public boolean isValid() {
        return this.valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getUsernameError() {
        return usernameError;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
        this.setValid(getValid());
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
        this.setValid(getValid());
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
        this.setValid(getValid());
    }

    public String getDateOfBirthError() {
        return dateOfBirthError;
    }

    public void setDateOfBirthError(String dateOfBirthError) {
        this.dateOfBirthError = dateOfBirthError;
        this.setValid(getValid());
    }

    private boolean getValid() {
        return usernameError.isEmpty() && emailError.isEmpty() && passwordError.isEmpty() && dateOfBirthError.isEmpty();
    }
}

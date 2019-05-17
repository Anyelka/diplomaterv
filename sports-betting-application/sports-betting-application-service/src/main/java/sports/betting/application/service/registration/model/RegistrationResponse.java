package sports.betting.application.service.registration.model;

public class RegistrationResponse {

    private boolean valid;

    private String emailError;
    private String usernameError;
    private String passwordError;

    private String fullNameError;
    private String accountNumberError;
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

    public String getFullNameError() {
        return fullNameError;
    }

    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
        this.setValid(getValid());
    }

    public String getAccountNumberError() {
        return accountNumberError;
    }

    public void setAccountNumberError(String accountNumberError) {
        this.accountNumberError = accountNumberError;
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

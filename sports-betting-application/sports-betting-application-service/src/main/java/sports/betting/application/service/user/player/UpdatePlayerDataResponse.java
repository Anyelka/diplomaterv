package sports.betting.application.service.user.player;

public class UpdatePlayerDataResponse {

    private boolean valid;

    private String fullNameError;
    private String dateOfBirthError;
    private String accountNumberError;

    public UpdatePlayerDataResponse() {
        this.fullNameError = "";
        this.dateOfBirthError = "";
        this.accountNumberError = "";
    }

    public boolean getValid() {
        return fullNameError.isEmpty() && dateOfBirthError.isEmpty() && accountNumberError.isEmpty();
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getDateOfBirthError() {
        return dateOfBirthError;
    }

    public void setDateOfBirthError(String dateOfBirthError) {
        this.dateOfBirthError = dateOfBirthError;
        setValid(getValid());
    }

    public String getFullNameError() {
        return fullNameError;
    }

    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
        setValid(getValid());
    }

    public String getAccountNumberError() {
        return accountNumberError;
    }

    public void setAccountNumberError(String accountNumberError) {
        this.accountNumberError = accountNumberError;
        setValid(getValid());
    }
}

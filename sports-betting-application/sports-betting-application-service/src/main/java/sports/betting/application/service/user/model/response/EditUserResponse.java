package sports.betting.application.service.user.model.response;

public class EditUserResponse {
    private boolean valid;
    private String emailError;
    private String usernameError;
    private String fullNameError;
    private String accountNumberError;
    private String balanceError;
    private String currencyError;
    private String dateOfBirthError;

    public EditUserResponse() {
        this.valid = true;
        this.emailError = "";
        this.usernameError = "";
        this.fullNameError = "";
        this.balanceError = "";
        this.currencyError = "";
        this.accountNumberError = "";
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

    public String getBalanceError() {
        return balanceError;
    }

    public void setBalanceError(String balanceError) {
        this.balanceError = balanceError;
        this.setValid(getValid());
    }

    public String getCurrencyError() {
        return currencyError;
    }

    public void setCurrencyError(String currencyError) {
        this.currencyError = currencyError;
        this.setValid(getValid());
    }

    private boolean getValid() {
        return usernameError.isEmpty() && emailError.isEmpty() && dateOfBirthError.isEmpty()
                && fullNameError.isEmpty() && accountNumberError.isEmpty() && balanceError.isEmpty()
                && currencyError.isEmpty();
    }
}

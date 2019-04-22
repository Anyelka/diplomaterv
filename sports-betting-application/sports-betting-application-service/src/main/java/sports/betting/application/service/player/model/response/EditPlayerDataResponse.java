package sports.betting.application.service.player.model.response;

public class EditPlayerDataResponse {

    private boolean valid;

    private String fullNameError;
    private String accountNumberError;
    private String dateOfBirthError;
    private String balanceError;
    private String currencyError;

    public EditPlayerDataResponse() {
        this.valid = true;
        this.fullNameError = "";
        this.dateOfBirthError = "";
        this.accountNumberError = "";
        this.balanceError = "";
        this.currencyError = "";
    }

    public boolean getValid() {
        return fullNameError.isEmpty() && dateOfBirthError.isEmpty() && accountNumberError.isEmpty()
                && balanceError.isEmpty() && currencyError.isEmpty();
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

    public String getBalanceError() {
        return balanceError;
    }

    public void setBalanceError(String balanceError) {
        this.balanceError = balanceError;
        setValid(getValid());
    }

    public String getCurrencyError() {
        return currencyError;
    }

    public void setCurrencyError(String currencyError) {
        this.currencyError = currencyError;
        setValid(getValid());
    }
}

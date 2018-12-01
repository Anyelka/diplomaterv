package sports.betting.application.web.controller.home.accountdetails;

public class SaveAccountDetailsResponse {

    private boolean successful;
    private String status;

    private String playerNameError;
    private String dateOfBirthError;
    private String accountNumberError;

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
        this.setStatus(this.successful ?"Changes successfully saved!":"There were some errors in your input data!");
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPlayerNameError() {
        return playerNameError;
    }

    public void setPlayerNameError(String playerNameError) {
        this.playerNameError = playerNameError;
    }

    public String getDateOfBirthError() {
        return dateOfBirthError;
    }

    public void setDateOfBirthError(String dateOfBirthError) {
        this.dateOfBirthError = dateOfBirthError;
    }

    public String getAccountNumberError() {
        return accountNumberError;
    }

    public void setAccountNumberError(String accountNumberError) {
        this.accountNumberError = accountNumberError;
    }
}

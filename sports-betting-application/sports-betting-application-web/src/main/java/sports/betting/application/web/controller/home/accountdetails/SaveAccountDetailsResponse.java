package sports.betting.application.web.controller.home.accountdetails;

public class SaveAccountDetailsResponse {

    private boolean successful;
    private String status;

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
        if(this.successful) {
            this.setStatus("Changes successfully saved!");
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

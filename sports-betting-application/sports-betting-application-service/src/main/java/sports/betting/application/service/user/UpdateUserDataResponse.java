package sports.betting.application.service.user;

public class UpdateUserDataResponse {

    private boolean valid;

    public UpdateUserDataResponse() {
        this.valid = true;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}

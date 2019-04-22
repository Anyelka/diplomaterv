package sports.betting.application.service.user.model.response;

public class DeleteUserResponse {
    private boolean valid;
    private String usernameError;

    public boolean getValid() {
        return usernameError.isEmpty();
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getUsernameError() {
        return usernameError;
    }

    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
        setValid(getValid());
    }
}

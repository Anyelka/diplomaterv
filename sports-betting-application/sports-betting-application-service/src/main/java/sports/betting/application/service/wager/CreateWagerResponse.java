package sports.betting.application.service.wager;

public class CreateWagerResponse {

    private boolean valid;

    private String stakeError;

    public CreateWagerResponse() {
        this.valid = true;
        this.stakeError = "";
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getStakeError() {
        return stakeError;
    }

    public void setStakeError(String stakeError) {
        this.stakeError = stakeError;
        this.setValid(this.getValid());
    }

    public boolean getValid() {
        return stakeError.isEmpty();
    }
}

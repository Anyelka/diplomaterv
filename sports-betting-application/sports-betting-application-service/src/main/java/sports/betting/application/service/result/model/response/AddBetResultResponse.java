package sports.betting.application.service.result.model.response;

public class AddBetResultResponse {
    private boolean valid;

    private String betDescriptionError;
    private String outcomeValueError;
    private String existingResultError;

    public AddBetResultResponse() {
        this.betDescriptionError= "";
        this.outcomeValueError = "";
        this.existingResultError = "";
    }

    public boolean getValid() {
        return betDescriptionError.isEmpty() && outcomeValueError.isEmpty() && existingResultError.isEmpty();
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getBetDescriptionError() {
        return betDescriptionError;
    }

    public void setBetDescriptionError(String betDescriptionError) {
        this.betDescriptionError = betDescriptionError;
        setValid(getValid());
    }

    public String getOutcomeValueError() {
        return outcomeValueError;
    }

    public void setOutcomeValueError(String outcomeValueError) {
        this.outcomeValueError = outcomeValueError;
        setValid(getValid());
    }

    public String getExistingResultError() {
        return existingResultError;
    }

    public void setExistingResultError(String existingResultError) {
        this.existingResultError = existingResultError;
        setValid(getValid());
    }
}

package sports.betting.application.service.result.model.response;

public class AddFullTimeResultResponse {

    private boolean valid;

    private String eventIdError;
    private String fullTimeResultError;
    private String existingResultError;

    public AddFullTimeResultResponse() {
        this.eventIdError = "";
        this.fullTimeResultError = "";
        this.existingResultError = "";
    }

    public boolean getValid() {
        return eventIdError.isEmpty() && fullTimeResultError.isEmpty() && existingResultError.isEmpty();
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getEventIdError() {
        return eventIdError;
    }

    public void setEventIdError(String eventIdError) {
        this.eventIdError = eventIdError;
        setValid(getValid());
    }

    public String getFullTimeResultError() {
        return fullTimeResultError;
    }

    public void setFullTimeResultError(String fullTimeResultError) {
        this.fullTimeResultError = fullTimeResultError;
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

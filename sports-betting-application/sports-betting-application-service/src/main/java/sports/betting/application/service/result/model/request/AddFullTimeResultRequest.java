package sports.betting.application.service.result.model.request;

public class AddFullTimeResultRequest {

    private int eventId;
    private String fullTimeResult;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getFullTimeResult() {
        return fullTimeResult;
    }

    public void setFullTimeResult(String fullTimeResult) {
        this.fullTimeResult = fullTimeResult;
    }
}

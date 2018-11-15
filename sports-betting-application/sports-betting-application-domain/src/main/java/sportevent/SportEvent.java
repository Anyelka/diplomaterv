package sportevent;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SportEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String title;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private EventType eventType;
    private boolean ended;

    public SportEvent() {
    };

    public SportEvent(String title, LocalDateTime startDate, LocalDateTime endDate, EventType type) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.eventType = type;
        this.ended = false;
    };

    public int getId() {
        return id;
    }

    public void setId(int eventID) {
        this.id = eventID;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getStartDate() {
        return this.startDate;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }

}

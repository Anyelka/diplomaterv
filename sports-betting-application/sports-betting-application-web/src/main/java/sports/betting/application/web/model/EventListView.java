package sports.betting.application.web.model;

import java.util.List;


public class EventListView {
    private List<SportEventView> events;

    public EventListView(List<SportEventView> events) {
        this.events = events;
    }

    public List<SportEventView> getEvents() {
        return events;
    }
    public void setEvents(List<SportEventView> events) {
        this.events = events;
    }
}

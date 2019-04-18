package sports.betting.application.service.result.model.request;

public class AddBetResultForEventRequest {
    
    private String eventTitle;
    private AddSingleBetResultRequest bet;
    
    public String getEventTitle() {
        return eventTitle;
    }
    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }
    public AddSingleBetResultRequest getBet() {
        return bet;
    }
    public void setBet(AddSingleBetResultRequest bets) {
        this.bet = bets;
    }
    
}

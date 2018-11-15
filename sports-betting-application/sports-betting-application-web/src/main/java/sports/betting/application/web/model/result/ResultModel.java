package sports.betting.application.web.model.result;

public class ResultModel {
    
    private String eventTitle;
    private ResultBetModel bet;
    
    public String getEventTitle() {
        return eventTitle;
    }
    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }
    public ResultBetModel getBet() {
        return bet;
    }
    public void setBet(ResultBetModel bets) {
        this.bet = bets;
    }
    
}

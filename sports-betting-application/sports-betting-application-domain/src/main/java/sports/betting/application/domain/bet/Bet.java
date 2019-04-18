package sports.betting.application.domain.bet;

import sports.betting.application.domain.sportevent.SportEvent;

public class Bet {
    private int id;
    private SportEvent sportEvent;
    private String description;
    private BetType betType;
    private boolean ended;
    private String result;

    public Bet() {
    }

    public Bet(SportEvent sportEvent, String description, BetType betType) {
        this.sportEvent = sportEvent;
        this.description = description;
        this.betType = betType;
    }

    public int getId() {
        return id;
    }
    public void setId(int betId) {
        this.id = betId;
    }
    public SportEvent getEvent() {
        return sportEvent;
    }
    public void setEvent(SportEvent event) {
        this.sportEvent = event;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public BetType getBetType() {
        return betType;
    }
    public void setBetType(BetType betType) {
        this.betType = betType;
    }
    public boolean isEnded() {
        return ended;
    }
    public void setEnded(boolean ended) {
        this.ended = ended;
    }
    public SportEvent getSportEvent() {
        return sportEvent;
    }
    public void setSportEvent(SportEvent sportEvent) {
        this.sportEvent = sportEvent;
    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
}

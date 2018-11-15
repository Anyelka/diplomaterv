package sports.betting.application.domain.bet;

import sports.betting.application.domain.sportevent.SportEvent;

public class Bet {
    private int id;
    private SportEvent sportEvent;
    private String description;
    private BetType betType;

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
}

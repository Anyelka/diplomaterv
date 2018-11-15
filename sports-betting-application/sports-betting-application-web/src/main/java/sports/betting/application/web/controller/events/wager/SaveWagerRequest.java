package sports.betting.application.web.controller.events.wager;

public class SaveWagerRequest {
    int outcomeId;
    int stake;
    String playerUsername;
    
    public int getOutcomeId() {
        return outcomeId;
    }
    public void setOutcomeId(int outcomeId) {
        this.outcomeId = outcomeId;
    }
    public int getStake() {
        return stake;
    }
    public void setStake(int stake) {
        this.stake = stake;
    }
    public String getPlayerUsername() {
        return playerUsername;
    }
    public void setPlayerUsername(String playerUsername) {
        this.playerUsername = playerUsername;
    }
    
}

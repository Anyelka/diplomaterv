package sports.betting.application.service.wager;

public class SaveWagerRequest {
    private int outcomeId;
    private int stake;
    private String playerUsername;

    public SaveWagerRequest() {
    }

    public SaveWagerRequest(String playerUsername, int outcomeId, int stake) {
        this.outcomeId = outcomeId;
        this.stake = stake;
        this.playerUsername = playerUsername;
    }

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

package sports.betting.application.service.wager;

public class SaveWagerRequest {
    private int outcomeId;
    private String stake;
    private String playerUsername;

    public SaveWagerRequest() {
    }

    public SaveWagerRequest(String playerUsername, int outcomeId, String stake) {
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
    public String getStake() {
        return stake;
    }
    public void setStake(String stake) {
        this.stake = stake;
    }
    public String getPlayerUsername() {
        return playerUsername;
    }
    public void setPlayerUsername(String playerUsername) {
        this.playerUsername = playerUsername;
    }
    
}

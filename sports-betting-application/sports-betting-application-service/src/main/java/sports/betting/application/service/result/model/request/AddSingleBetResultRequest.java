package sports.betting.application.service.result.model.request;

public class AddSingleBetResultRequest {
    
    private String betDescription;
    private String outcomeValue;
    
    public String getBetDescription() {
        return betDescription;
    }
    public void setBetDescription(String betDescription) {
        this.betDescription = betDescription;
    }
    public String getOutcomeValue() {
        return outcomeValue;
    }
    public void setOutcomeValue(String outcomeValue) {
        this.outcomeValue = outcomeValue;
    }
    
    
}

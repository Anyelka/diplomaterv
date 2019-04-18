package sports.betting.application.web.model;

public class OutcomeOddView {
    
    private String outcomeFullDescription;
    private double value;

    public String getOutcomeFullDescription() {
        return outcomeFullDescription;
    }
    public void setOutcomeFullDescription(String outcomeFullDescription) {
        this.outcomeFullDescription = outcomeFullDescription;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    
}

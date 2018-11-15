package model;

public class OutcomeOddModel {
    
    private String  outcomeFullDescription;
    private double value;
    private String validFrom;
    private String validTo;

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
    public String getValidFrom() {
        return validFrom;
    }
    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }
    public String getValidTo() {
        return validTo;
    }
    public void setValidTo(String validTo) {
        this.validTo = validTo;
    }
    
}

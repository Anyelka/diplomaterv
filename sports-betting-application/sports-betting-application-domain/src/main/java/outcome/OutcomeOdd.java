package outcome;

import java.time.LocalDateTime;

public class OutcomeOdd {
    private int id;
    private Outcome outcome;
    private double value;
    private LocalDateTime validFrom;
    private LocalDateTime validTo;

    public OutcomeOdd() {
    }
    
    public OutcomeOdd(double value) {
        this.value = value;
    }

    public OutcomeOdd(Outcome outcome, double value, LocalDateTime validFrom, LocalDateTime validTo) {
        this.outcome = outcome;
        this.value = value;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double odd) {
        this.value = odd;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDateTime getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDateTime validTo) {
        this.validTo = validTo;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }
}

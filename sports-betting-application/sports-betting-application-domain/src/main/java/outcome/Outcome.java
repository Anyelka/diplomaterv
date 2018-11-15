package outcome;

import bet.Bet;

public class Outcome {
    private int id;
    private Bet bet;
    private String value;
    private OutcomeOdd currentOdd;

    public Outcome() {
    };

    public Outcome(Bet bet, String value, OutcomeOdd currentOdd) {
        this.bet = bet;
        this.value = value;
        this.currentOdd = currentOdd;
    }

    public int getId() {
        return id;
    }

    public void setId(int outcomeId) {
        this.id = outcomeId;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }
    
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public OutcomeOdd getCurrentOdd() {
        return currentOdd;
    }

    public void setCurrentOdd(OutcomeOdd currentOdd) {
        this.currentOdd = currentOdd;
    }

}

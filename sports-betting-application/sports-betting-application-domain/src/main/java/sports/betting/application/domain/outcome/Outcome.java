package sports.betting.application.domain.outcome;

import sports.betting.application.domain.bet.Bet;

public class Outcome {
    private int id;
    private Bet bet;
    private String value;
    private double currentOdd;

    public Outcome() {}

    public Outcome(Bet bet, String value, double currentOdd) {
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
    public double getCurrentOdd() {
        return currentOdd;
    }
    public void setCurrentOdd(double currentOdd) {
        this.currentOdd = currentOdd;
    }

    public String toCapitalizedString() {
        return value.substring(0,1).toUpperCase().concat(value.substring(1).toLowerCase());
    }
}

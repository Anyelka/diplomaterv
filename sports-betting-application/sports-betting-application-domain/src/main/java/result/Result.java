package result;

import bet.Bet;
import outcome.Outcome;

public class Result {

    private int id;
    private Bet bet;
    private Outcome outcome;
    
    public Result() {
        super();
    }
    public Result(Bet bet, Outcome outcome) {
        this.bet = bet;
        this.outcome = outcome;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Bet getBet() {
        return bet;
    }
    public void setBet(Bet bet) {
        this.bet = bet;
    }
    public Outcome getOutcome() {
        return outcome;
    }
    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }


}

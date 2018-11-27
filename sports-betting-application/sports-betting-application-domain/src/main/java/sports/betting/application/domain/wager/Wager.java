package sports.betting.application.domain.wager;

import java.time.LocalDateTime;
import java.util.Currency;

import sports.betting.application.domain.bet.Bet;
import sports.betting.application.domain.outcome.Outcome;
import sports.betting.application.domain.user.User;

public class Wager {
        
    private int id;
    private User player;
    private Bet bet;
    private Outcome outcome;
    private double outcomeOdd;
    private int stake;
    private Currency currency;
    private LocalDateTime timestamp;
    private boolean processed;
    private boolean winner;

    public Wager() {
    }

    public Wager(User player, Bet chosenBet, Outcome outcome, double outcomeOdd, int amount, Currency currency, LocalDateTime date) {
        this.bet = chosenBet;
        this.player = player;
        this.outcome = outcome;
        this.outcomeOdd = outcomeOdd;
        this.stake = amount;
        this.currency = currency;
        this.timestamp = date;
        this.processed = false;
    }
    
    public Wager(User player, Bet chosenBet, Outcome outcome, double outcomeOdd, int amount, Currency currency, LocalDateTime date, boolean isProcessed, boolean isWinner) {
        this.bet = chosenBet;
        this.player = player;
        this.outcome = outcome;
        this.outcomeOdd = outcomeOdd;
        this.stake = amount;
        this.currency = currency;
        this.timestamp = date;
        this.processed = isProcessed;
        this.winner = isWinner;
    }

    public User getPlayer() {
        return player;
    }

    public void setPlayer(User player) {
        this.player = player;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet chosenBet) {
        this.bet = chosenBet;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    public double getOutcomeOdd() {
        return outcomeOdd;
    }

    public void setOutcomeOdd(double outcomeOdd) {
        this.outcomeOdd = outcomeOdd;
    }

    public int getStake() {
        return stake;
    }

    public void setStake(int stake) {
        this.stake = stake;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime date) {
        this.timestamp = date;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean isWinner) {
        this.winner = isWinner;
    }

    public int getId() {
        return id;
    }

    public void setId(int wagerId) {
        this.id = wagerId;
    }

}

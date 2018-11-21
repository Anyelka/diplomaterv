package sports.betting.application.dal.wager.entity;

import java.time.LocalDateTime;
import java.util.Currency;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import sports.betting.application.dal.bet.entity.BetEntity;
import sports.betting.application.dal.outcome.entity.OutcomeEntity;
import sports.betting.application.dal.user.entity.UserEntity;

@Entity
@Table(name = "wager")
public class WagerEntity {
        
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @ManyToOne
    private UserEntity player;
    
    @ManyToOne
    private BetEntity bet;
    
    @ManyToOne
    private OutcomeEntity outcome;
    
    private int stake;
    private Currency currency;
    private LocalDateTime timestamp;
    private boolean processed;
    private boolean winner;

    public WagerEntity() {
    }

    public WagerEntity(UserEntity player, BetEntity chosenBet, OutcomeEntity outcome, int amount, Currency currency, LocalDateTime date) {
        this.bet = chosenBet;
        this.player = player;
        this.outcome = outcome;
        this.stake = amount;
        this.currency = currency;
        this.timestamp = date;
        this.processed = false;
    }
    
    public WagerEntity(UserEntity player, BetEntity chosenBet, OutcomeEntity outcome, int amount, Currency currency, LocalDateTime date,boolean isProcessed, boolean isWinner) {
        this.bet = chosenBet;
        this.player = player;
        this.outcome = outcome;
        this.stake = amount;
        this.currency = currency;
        this.timestamp = date;
        this.processed = isProcessed;
        this.winner = isWinner;
    }

    public UserEntity getPlayer() {
        return player;
    }

    public void setPlayer(UserEntity player) {
        this.player = player;
    }

    public BetEntity getBet() {
        return bet;
    }

    public void setBet(BetEntity chosenBet) {
        this.bet = chosenBet;
    }

    public OutcomeEntity getOutcome() {
        return outcome;
    }

    public void setOutcome(OutcomeEntity outcome) {
        this.outcome = outcome;
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

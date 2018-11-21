package sports.betting.application.dal.outcome.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import sports.betting.application.dal.bet.entity.BetEntity;

@Entity
@Table(name = "outcome")
public class OutcomeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private BetEntity bet;
    private String value;
    private double currentOdd;

    public OutcomeEntity() {
    };

    public OutcomeEntity(BetEntity bet, String value) {
        this.bet = bet;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int outcomeId) {
        this.id = outcomeId;
    }

    public BetEntity getBet() {
        return bet;
    }
    
    public void setBet(BetEntity bet) {
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
    
}

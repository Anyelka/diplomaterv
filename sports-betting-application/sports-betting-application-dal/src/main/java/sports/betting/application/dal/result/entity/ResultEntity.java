package sports.betting.application.dal.result.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import sports.betting.application.dal.bet.entity.BetEntity;
import sports.betting.application.dal.outcome.entity.OutcomeEntity;

@Entity
@Table(name = "result")
public class ResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    private BetEntity bet;

    @OneToOne(fetch = FetchType.EAGER)
    private OutcomeEntity outcome;

    public ResultEntity() {
        super();
    }

    public ResultEntity(int id, BetEntity bet, OutcomeEntity outcome) {
        super();
        this.id = id;
        this.bet = bet;
        this.outcome = outcome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BetEntity getBet() {
        return bet;
    }

    public void setBet(BetEntity bet) {
        this.bet = bet;
    }

    public OutcomeEntity getOutcome() {
        return outcome;
    }

    public void setOutcome(OutcomeEntity outcome) {
        this.outcome = outcome;
    }

}

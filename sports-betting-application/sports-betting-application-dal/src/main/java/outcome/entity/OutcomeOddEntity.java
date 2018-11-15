package org.sports.betting.application.dal.outcome.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "outcome_odd")
public class OutcomeOddEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @OneToOne
    private OutcomeEntity outcome;
    private double value;
    private LocalDateTime validFrom;
    private LocalDateTime validTo;

    public OutcomeOddEntity() {
    }
    
    public OutcomeOddEntity(double value) {
        this.value = value;
    }

    public OutcomeOddEntity(OutcomeEntity outcome, double value, LocalDateTime validFrom, LocalDateTime validTo) {
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

    public OutcomeEntity getOutcome() {
        return outcome;
    }

    public void setOutcome(OutcomeEntity outcome) {
        this.outcome = outcome;
    }
}

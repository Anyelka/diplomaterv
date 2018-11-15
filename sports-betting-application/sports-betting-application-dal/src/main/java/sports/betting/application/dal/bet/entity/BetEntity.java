package sports.betting.application.dal.bet.entity;

import java.util.HashSet;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import sports.betting.application.dal.outcome.entity.OutcomeEntity;
import sports.betting.application.dal.sportevent.entity.SportEventEntity;
import sports.betting.application.domain.bet.BetType;

@Entity
@Table(name = "bet")
public class BetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private SportEventEntity event;
    private String description;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<OutcomeEntity> outcomes = new HashSet<OutcomeEntity>();

    @Enumerated(EnumType.STRING)
    private BetType betType;

    public BetEntity() {
    }

    public BetEntity(SportEventEntity event, String description, BetType betType) {
        this.event = event;
        this.description = description;
        this.betType = betType;
    }

    public int getId() {
        return id;
    }

    public void setId(int betId) {
        this.id = betId;
    }

    public SportEventEntity getEvent() {
        return event;
    }

    public void setEvent(SportEventEntity event) {
        this.event = event;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<OutcomeEntity> getOutcomes() {
        return outcomes;
    }

    public void setOutcomes(Set<OutcomeEntity> outcomes) {
        this.outcomes = outcomes;
    }

    public BetType getBetType() {
        return betType;
    }

    public void setBetType(BetType betType) {
        this.betType = betType;
    }
}

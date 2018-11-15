package org.sports.betting.application.dal.outcome.dao;

import java.util.List;

import bet.Bet;
import outcome.Outcome;

public interface OutcomeDao {
    public Outcome getById(int id);
    public Outcome getByBetAndValue(Bet bet, String value);
    public Outcome getResultOutcomeByBet(Bet bet);
    public List<Outcome> getAllByBet(Bet bet);
    public void save(Outcome outcome);
}

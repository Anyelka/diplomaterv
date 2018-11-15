package service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.sports.betting.application.dal.bet.dao.BetDao;
import org.sports.betting.application.dal.outcome.dao.OutcomeDao;
import org.sports.betting.application.dal.outcome.dao.OutcomeOddDao;
import bet.Bet;
import outcome.Outcome;
import outcome.OutcomeOdd;
import org.springframework.beans.factory.annotation.Autowired;

public class OutcomeService {

    @Autowired
    private DateTimeFormatter formatter;
    
    @Autowired
    private BetDao betDao;
    
    @Autowired
    private OutcomeDao outcomeDao;
    
    @Autowired
    private OutcomeOddDao outcomeOddDao;
    
    public Outcome createOutcome(String betDescription, String value) {
        Bet bet = betDao.getByDescription(betDescription);
        Outcome outcome = new Outcome(bet, value, new OutcomeOdd());
        outcomeDao.save(outcome);
        return outcome;
    }

    public void createOutcomeOdd(Outcome outcome, double oddValue, String validFrom, String validTo) {
        LocalDateTime from = LocalDateTime.parse(validFrom, formatter);
        LocalDateTime to = LocalDateTime.parse(validTo, formatter);
        OutcomeOdd outcomeOdd = new OutcomeOdd(outcome, oddValue, from, to);
        outcomeOddDao.save(outcomeOdd);
        setCurrentOutcomeOddOfOutcome(outcome, outcomeOdd);
    }

    private void setCurrentOutcomeOddOfOutcome(Outcome outcome, OutcomeOdd outcomeOdd) {
        outcome.setCurrentOdd(outcomeOdd);
        outcomeDao.save(outcome);
    }

    public Outcome getResultOutcomeOfBet(Bet bet) {
        return outcomeDao.getResultOutcomeByBet(bet);
    }
    
    public List<Outcome> getAllByBet(Bet bet) {
        return outcomeDao.getAllByBet(bet);
    }
    
    public Outcome getOutcome(int id) {
        return outcomeDao.getById(id);
    }
    
    public Outcome getByBetAndValue(Bet bet, String value) {
        return outcomeDao.getByBetAndValue(bet, value);
    }
    
    public Outcome getByFullDescription(String description) {
        String betDescription = description.substring(0, description.lastIndexOf("--") - 1);
        String value = description.substring(description.lastIndexOf("--") + 3);
        Bet bet = betDao.getByDescription(betDescription);
        return getByBetAndValue(bet,value);
    }
    
    public OutcomeOdd getOutcomeOddById(int id) {
        return outcomeOddDao.getById(id);
    }
    
}
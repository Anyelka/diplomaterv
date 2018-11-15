package service;

import java.util.function.DoubleSupplier;

import org.sports.betting.application.dal.bet.dao.BetDao;
import org.sports.betting.application.dal.outcome.dao.OutcomeDao;
import org.sports.betting.application.dal.result.dao.ResultDao;
import org.sports.betting.application.dal.sportevent.dao.SportEventDao;
import bet.Bet;
import outcome.Outcome;
import result.Result;
import sportevent.SportEvent;
import org.springframework.beans.factory.annotation.Autowired;

public class ResultDataGenerator {

    private final DoubleSupplier numberGenerator;

    @Autowired
    private SportEventDao sportEventDao;

    @Autowired
    private ResultDao resultDao;

    @Autowired
    private BetDao betDao;

    @Autowired
    private OutcomeDao outcomeDao;

    public ResultDataGenerator(DoubleSupplier numberGenerator) {
        super();
        this.numberGenerator = numberGenerator;
    }

    public void generateRandomResults() {
        for (SportEvent event : sportEventDao.getAll()) {
            generateRandomResultForAllBetsOfEvent(event);
        }
//        sportEventDao.getAll().stream().peek(event -> generateRandomResultForAllBetsOfEvent(event));
    }

    private void generateRandomResultForAllBetsOfEvent(SportEvent event) {
        for (Bet bet : betDao.getAllByEvent(event)) {
            resultDao.save(new Result(bet, generateRandomOutcome(bet)));
        }
    }

    protected Outcome generateRandomOutcome(Bet bet) {
        Outcome outcome = null;
        Object[] outcomes = outcomeDao.getAllByBet(bet).toArray();
        int totalIndexes = outcomes.length;
        int randomIndex = (int) (totalIndexes * numberGenerator.getAsDouble());
        for (int currentIndex = 0; currentIndex < totalIndexes; currentIndex++) {
            if (currentIndex == randomIndex) {
                outcome = (Outcome) outcomes[currentIndex];
            }
        }
        return outcome;
    }
    

}

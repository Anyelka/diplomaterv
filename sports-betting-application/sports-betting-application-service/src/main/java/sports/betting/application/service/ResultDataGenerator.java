package sports.betting.application.service;

import java.util.function.DoubleSupplier;

import sports.betting.application.dal.bet.dao.BetDao;
import sports.betting.application.dal.outcome.dao.OutcomeDao;
import sports.betting.application.dal.result.dao.ResultDao;
import sports.betting.application.dal.sportevent.dao.SportEventDao;
import sports.betting.application.domain.bet.Bet;
import sports.betting.application.domain.outcome.Outcome;
import sports.betting.application.domain.result.Result;
import sports.betting.application.domain.sportevent.SportEvent;
import org.springframework.beans.factory.annotation.Autowired;

public class ResultDataGenerator {

    private final DoubleSupplier numberGenerator;

    @Autowired
    private SportEventDao sportEventDao;

    @Autowired
    private ResultService resultService;

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
    }

    private void generateRandomResultForAllBetsOfEvent(SportEvent event) {
        for (Bet bet : betDao.getAllByEvent(event)) {
            resultService.save(new Result(bet, generateRandomOutcome(bet)));
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

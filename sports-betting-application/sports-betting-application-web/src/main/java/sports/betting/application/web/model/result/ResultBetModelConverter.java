package sports.betting.application.web.model.result;

import sports.betting.application.service.BetService;
import sports.betting.application.service.OutcomeService;
import sports.betting.application.domain.bet.Bet;
import sports.betting.application.domain.outcome.Outcome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResultBetModelConverter{
    
    @Autowired
    private BetService betService;
    
    @Autowired
    private OutcomeService outcomeService;
    
    public Outcome transferBet(ResultBetModel betModel) {
        Bet bet = betService.getByDescription(betModel.getBetDescription());
        String value = betModel.getValue();
        return outcomeService.getByBetAndValue(bet, value);
    }
}

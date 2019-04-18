package sports.betting.application.service.result.model.converter;

import sports.betting.application.service.bet.BetService;
import sports.betting.application.service.outcome.OutcomeService;
import sports.betting.application.domain.bet.Bet;
import sports.betting.application.domain.outcome.Outcome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sports.betting.application.service.result.model.request.AddSingleBetResultRequest;

@Component
public class ResultBetModelConverter{
    
    @Autowired
    private BetService betService;
    
    @Autowired
    private OutcomeService outcomeService;
    
    public Outcome transferBet(AddSingleBetResultRequest betModel) {
        Bet bet = betService.getByDescription(betModel.getBetDescription()).get();
        String value = betModel.getOutcomeValue();
        return outcomeService.getByBetAndValue(bet, value);
    }
}

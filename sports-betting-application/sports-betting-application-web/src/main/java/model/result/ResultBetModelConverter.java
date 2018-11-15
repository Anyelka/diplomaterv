package model.result;

import service.BetService;
import service.OutcomeService;
import bet.Bet;
import outcome.Outcome;
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

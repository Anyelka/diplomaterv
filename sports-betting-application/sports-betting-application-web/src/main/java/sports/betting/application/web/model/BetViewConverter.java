package sports.betting.application.web.model;

import java.util.ArrayList;
import java.util.List;

import sports.betting.application.service.OutcomeService;
import sports.betting.application.domain.bet.Bet;
import sports.betting.application.domain.outcome.Outcome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BetViewConverter implements Converter<Bet, BetModel> {

    @Autowired
    OutcomeService outcomeService;
    
    @Autowired 
    private OutcomeViewConverter outcomeConverter;
    
    @Override
    public BetModel convert(Bet bet) {
        BetModel betModel = new BetModel();        
        List<Outcome> outcomes = outcomeService.getAllByBet(bet);
        betModel.setOutcomes(transferOutcomes(outcomes));
        betModel.setId(bet.getId());
        betModel.setDescription(bet.getDescription());
        return betModel;
    }

    private List<OutcomeModel> transferOutcomes(List<Outcome> outcomes) {
        List<OutcomeModel> transferredOutcomes = new ArrayList<OutcomeModel>();
        for(Outcome outcome : outcomes) {
            transferredOutcomes.add(outcomeConverter.convert(outcome));
        }
        return transferredOutcomes;
    }
}

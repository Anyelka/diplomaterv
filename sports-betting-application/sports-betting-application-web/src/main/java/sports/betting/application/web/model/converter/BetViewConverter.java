package sports.betting.application.web.model.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import sports.betting.application.service.outcome.OutcomeService;
import sports.betting.application.domain.bet.Bet;
import sports.betting.application.domain.outcome.Outcome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sports.betting.application.web.model.BetView;
import sports.betting.application.web.model.OutcomeView;

@Component
public class BetViewConverter implements Converter<Bet, BetView> {

    @Autowired
    OutcomeService outcomeService;
    
    @Autowired 
    private OutcomeViewConverter outcomeConverter;
    
    @Override
    public BetView convert(Bet bet) {
        BetView betView = new BetView();
        List<Outcome> outcomes = outcomeService.getAllByBet(bet);
        betView.setOutcomes(outcomeConverter.convert(outcomes));
        betView.setId(bet.getId());
        betView.setDescription(bet.getDescription());
        betView.setEnded(bet.isEnded());
        betView.setResult(bet.getResult());
        return betView;
    }

    public List<BetView> convert(List<Bet> bets) {
        return bets.stream().map(this::convert).collect(Collectors.toList());
    }
}

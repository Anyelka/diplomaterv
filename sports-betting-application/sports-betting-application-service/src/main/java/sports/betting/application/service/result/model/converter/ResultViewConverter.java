package sports.betting.application.service.result.model.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sports.betting.application.domain.bet.Bet;
import sports.betting.application.domain.outcome.Outcome;
import sports.betting.application.domain.result.Result;
import sports.betting.application.service.bet.BetService;
import sports.betting.application.service.result.model.request.AddBetResultForEventRequest;
import sports.betting.application.service.result.model.request.AddSingleBetResultRequest;

@Component
public class ResultViewConverter implements Converter<AddBetResultForEventRequest, Result>{
    
    @Autowired
    private BetService betService;
    
    @Autowired
    private ResultBetModelConverter betConverter;

    @Override
    public Result convert(AddBetResultForEventRequest model) {
        Bet bet = betService.getByDescription(model.getBet().getBetDescription()).get();
        Outcome outcome = betConverter.transferBet(model.getBet());
        return new Result(bet, outcome);
    }

    public Result convert(AddSingleBetResultRequest model) {
        Bet bet = betService.getByDescription(model.getBetDescription()).get();
        Outcome outcome = betConverter.transferBet(model);
        return new Result(bet, outcome);
    }
}

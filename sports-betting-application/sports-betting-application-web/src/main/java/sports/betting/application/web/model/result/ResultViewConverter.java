package sports.betting.application.web.model.result;

import sports.betting.application.service.BetService;
import sports.betting.application.domain.bet.Bet;
import sports.betting.application.domain.outcome.Outcome;
import sports.betting.application.domain.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ResultViewConverter implements Converter<ResultModel, Result>{
    
    @Autowired
    private BetService betService;
    
    @Autowired
    private ResultBetModelConverter betConverter;
    
    @Override
    public Result convert(ResultModel model) {
        Bet bet = betService.getByDescription(model.getBet().getBetDescription());
        Outcome outcome = betConverter.transferBet(model.getBet());
        return new Result(bet, outcome);
    }

}

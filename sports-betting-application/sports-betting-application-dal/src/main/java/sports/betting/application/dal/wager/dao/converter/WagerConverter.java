package sports.betting.application.dal.wager.dao.converter;

import sports.betting.application.dal.bet.dao.converter.BetConverter;
import sports.betting.application.dal.outcome.dao.converter.OutcomeConverter;
import sports.betting.application.dal.user.dao.converter.UserConverter;
import sports.betting.application.dal.wager.entity.WagerEntity;
import sports.betting.application.domain.outcome.Outcome;
import sports.betting.application.domain.wager.Wager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WagerConverter implements Converter<WagerEntity, Wager>{

    @Autowired
    private UserConverter userConverter;
    
    @Autowired
    private BetConverter betConverter;
    
    @Autowired
    private OutcomeConverter outcomeConverter;
    
    @Override
    public Wager convert(WagerEntity wagerEntity) {
        Wager wager = new Wager();
        wager.setId(wagerEntity.getId());
        wager.setPlayer(userConverter.convert(wagerEntity.getPlayer()));
        wager.setBet(betConverter.convert(wagerEntity.getBet()));
        Outcome outcome = outcomeConverter.convert(wagerEntity.getOutcome());
        wager.setOutcome(outcome);
        wager.setOutcomeOdd(outcome.getCurrentOdd());
        wager.setStake(wagerEntity.getStake());
        wager.setCurrency(wagerEntity.getCurrency());
        wager.setTimestamp(wagerEntity.getTimestamp());
        wager.setProcessed(wagerEntity.isProcessed());
        wager.setWinner(wagerEntity.isWinner());
        return wager;
    }

}

package wager.dao.converter;

import org.sports.betting.application.dal.bet.dao.converter.BetBackConverter;
import org.sports.betting.application.dal.outcome.dao.converter.OutcomeBackConverter;
import org.sports.betting.application.dal.user.dao.converter.UserBackConverter;
import wager.entity.WagerEntity;
import wager.Wager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class WagerBackConverter implements Converter<Wager, WagerEntity>{

    @Autowired
    private UserBackConverter userBackConverter;
    
    @Autowired
    private BetBackConverter betBackConverter;
    
    @Autowired
    private OutcomeBackConverter outcomeBackConverter;
    
    @Override
    public WagerEntity convert(Wager wager) {
        WagerEntity wagerEntity = new WagerEntity();
        wagerEntity.setId(wager.getId());
        wagerEntity.setPlayer(userBackConverter.convert(wager.getPlayer()));
        wagerEntity.setBet(betBackConverter.convert(wager.getBet()));
        wagerEntity.setOutcome(outcomeBackConverter.convert(wager.getOutcome()));
        wagerEntity.setStake(wager.getStake());
        wagerEntity.setCurrency(wager.getCurrency());
        wagerEntity.setTimestamp(wager.getTimestamp());
        wagerEntity.setProcessed(wager.isProcessed());
        wagerEntity.setWinner(wagerEntity.isWinner());
        return wagerEntity;
    }

}

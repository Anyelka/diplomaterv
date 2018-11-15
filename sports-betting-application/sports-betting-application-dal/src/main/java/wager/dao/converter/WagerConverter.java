package wager.dao.converter;

import org.sports.betting.application.dal.bet.dao.converter.BetConverter;
import org.sports.betting.application.dal.outcome.dao.converter.OutcomeConverter;
import org.sports.betting.application.dal.user.dao.converter.UserConverter;
import wager.entity.WagerEntity;
import wager.Wager;
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
        wager.setOutcome(outcomeConverter.convert(wagerEntity.getOutcome()));
        wager.setStake(wagerEntity.getStake());
        wager.setCurrency(wagerEntity.getCurrency());
        wager.setTimestamp(wagerEntity.getTimestamp());
        wager.setProcessed(wagerEntity.isProcessed());
        wager.setWinner(wager.isWinner());
        return wager;
    }

}

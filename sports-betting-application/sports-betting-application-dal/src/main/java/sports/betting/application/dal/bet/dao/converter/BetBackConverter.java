package sports.betting.application.dal.bet.dao.converter;

import sports.betting.application.dal.bet.entity.BetEntity;
import sports.betting.application.dal.sportevent.dao.converter.SportEventBackConverter;
import sports.betting.application.domain.bet.Bet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BetBackConverter implements Converter<Bet, BetEntity>{

    @Autowired
    private SportEventBackConverter sportEventBackConverter;

    @Override
    public BetEntity convert(Bet bet) {
        BetEntity betEntity = new BetEntity();
        betEntity.setId(bet.getId());
        betEntity.setEvent(sportEventBackConverter.convert(bet.getEvent()));
        betEntity.setDescription(bet.getDescription());
        betEntity.setBetType(bet.getBetType());
        betEntity.setEnded(bet.isEnded());
        betEntity.setResult(bet.getResult());
        return betEntity;
    }

}
package sports.betting.application.dal.bet.dao.converter;

import sports.betting.application.dal.bet.entity.BetEntity;
import sports.betting.application.dal.sportevent.dao.converter.SportEventConverter;
import sports.betting.application.domain.bet.Bet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BetConverter implements Converter<BetEntity, Bet>{

    @Autowired
    private SportEventConverter sportEventConverter;

    @Override
    public Bet convert(BetEntity betEntity) {
        Bet bet = new Bet();
        bet.setId(betEntity.getId());
        bet.setEvent(sportEventConverter.convert(betEntity.getEvent()));
        bet.setDescription(betEntity.getDescription());
        bet.setBetType(betEntity.getBetType());
        bet.setEnded(betEntity.isEnded());
        bet.setResult(betEntity.getResult());
        return bet;
    }

}

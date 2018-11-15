package org.sports.betting.application.dal.bet.dao.converter;

import org.sports.betting.application.dal.bet.entity.BetEntity;
import org.sports.betting.application.dal.sportevent.dao.converter.SportEventBackConverter;
import bet.Bet;
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
        return betEntity;
    }

}
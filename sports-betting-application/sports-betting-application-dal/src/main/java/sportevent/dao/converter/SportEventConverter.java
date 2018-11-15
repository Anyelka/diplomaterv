package org.sports.betting.application.dal.sportevent.dao.converter;

import org.sports.betting.application.dal.sportevent.entity.SportEventEntity;
import sportevent.SportEvent;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SportEventConverter implements Converter<SportEventEntity, SportEvent>{

    @Override
    public SportEvent convert(SportEventEntity sportEventEntity) {
        SportEvent sportEvent = new SportEvent();
        sportEvent.setId(sportEventEntity.getId());
        sportEvent.setTitle(sportEventEntity.getTitle());
        sportEvent.setStartDate(sportEventEntity.getStartDate());
        sportEvent.setEndDate(sportEventEntity.getEndDate());
        sportEvent.setEventType(sportEventEntity.getEventType());
        sportEvent.setEnded(sportEventEntity.isEnded());
        return sportEvent;
    }


}

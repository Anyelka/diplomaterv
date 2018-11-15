package sports.betting.application.dal.sportevent.dao.converter;

import sports.betting.application.dal.sportevent.entity.SportEventEntity;
import sports.betting.application.domain.sportevent.SportEvent;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SportEventBackConverter implements Converter<SportEvent, SportEventEntity>{

    @Override
    public SportEventEntity convert(SportEvent sportEvent) {
        SportEventEntity sportEventEntity = new SportEventEntity();
        sportEventEntity.setId(sportEvent.getId());
        sportEventEntity.setTitle(sportEvent.getTitle());
        sportEventEntity.setStartDate(sportEvent.getStartDate());
        sportEventEntity.setEndDate(sportEvent.getEndDate());
        sportEventEntity.setEventType(sportEvent.getEventType());
        sportEventEntity.setEnded(sportEvent.isEnded());
        return sportEventEntity;
    }
}

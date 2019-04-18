package sports.betting.application.web.model.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import sports.betting.application.lib.formatter.DateFormatter;
import sports.betting.application.service.bet.BetService;
import sports.betting.application.domain.bet.Bet;
import sports.betting.application.domain.sportevent.SportEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sports.betting.application.web.model.BetView;
import sports.betting.application.web.model.SportEventView;
import sports.betting.application.web.model.converter.BetViewConverter;

@Component
public class SportEventViewConverter implements Converter<SportEvent, SportEventView> {

    @Autowired
    private BetService betService;
    
    @Autowired 
    private BetViewConverter betConverter;
    
    @Autowired
    private DateFormatter formatter;
    
    @Override
    public SportEventView convert(SportEvent sportEvent) {
        SportEventView sportEventView = new SportEventView();
        List<Bet> bets = betService.getAllByEvent(sportEvent);
        sportEventView.setBets(betConverter.convert(bets));
        sportEventView.setId(sportEvent.getId());
        sportEventView.setTitle(sportEvent.getTitle());
        sportEventView.setStartDate(formatter.formatDate(sportEvent.getStartDate()));
        sportEventView.setEndDate(formatter.formatDate(sportEvent.getEndDate()));
        sportEventView.setType(sportEvent.getEventType().toString());
        sportEventView.setEnded(sportEvent.isEnded());
        sportEventView.setFullTimeResult(sportEvent.getFullTimeResult());
        return sportEventView;
    }

    public List<SportEventView> convert(List<SportEvent> events) {
        return events.stream().map(this::convert).collect(Collectors.toList());
    }
}

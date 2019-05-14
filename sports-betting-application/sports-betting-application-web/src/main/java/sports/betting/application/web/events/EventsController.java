package sports.betting.application.web.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import sports.betting.application.service.event.SportEventService;
import sports.betting.application.service.wager.SaveWagerRequest;
import sports.betting.application.web.model.EventListView;
import sports.betting.application.web.model.converter.SportEventViewConverter;

@Controller
public class EventsController {

    @Autowired
    private SportEventService sportEventService;

    @Autowired
    private SportEventViewConverter sportEventConverter;
    
    
    @ModelAttribute("eventListView")
    public EventListView createListEventsModel() {
        return new EventListView(sportEventConverter.convert(sportEventService.findAll()));
    }
    
    @ModelAttribute("saveWagerRequest")
    public SaveWagerRequest createSaveWagerRequest() {
        SaveWagerRequest saveWagerRequest = new SaveWagerRequest();
        String currentPlayerUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        saveWagerRequest.setPlayerUsername(currentPlayerUsername );
        return saveWagerRequest;
    }
    
    @RequestMapping("/player/events")
    public String eventsPage() {
        return "player_events";
    }
}

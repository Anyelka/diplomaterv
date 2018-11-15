package events;

import java.util.ArrayList;
import java.util.List;

import service.SportEventService;
import sportevent.SportEvent;
import events.wager.SaveWagerRequest;
import model.ListEventsModel;
import model.SportEventViewConverter;
import model.SportEventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventsController {

    private static final String REQUEST_MAPPING = "/events.html";

    @Autowired
    private SportEventService sportEventService;

    @Autowired
    private SportEventViewConverter sportEventConverter;
    
    
    @ModelAttribute("listEventsModel")
    public ListEventsModel createListEventsModel() {
        ListEventsModel listEventsModel = new ListEventsModel();
        List<SportEvent> sportEvents = sportEventService.findAll();
        listEventsModel.setEvents(transferEvents(sportEvents));
        return listEventsModel;
    }
    
    @ModelAttribute("saveWagerRequest")
    public SaveWagerRequest createSaveWagerRequest() {
        SaveWagerRequest saveWagerRequest = new SaveWagerRequest();
        String currentPlayerUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        saveWagerRequest.setPlayerUsername(currentPlayerUsername );
        return saveWagerRequest;
    }
    
    @RequestMapping(REQUEST_MAPPING)
    public String eventsPage() {
        return "events";
    }
    
    private List<SportEventModel> transferEvents(List<SportEvent> events) {
        List<SportEventModel> transferredEvents = new ArrayList<SportEventModel>();
        for(SportEvent event: events) {
            SportEventModel eventModel = sportEventConverter.convert(event);
            transferredEvents.add(eventModel);
        }
        return transferredEvents;
    }
}

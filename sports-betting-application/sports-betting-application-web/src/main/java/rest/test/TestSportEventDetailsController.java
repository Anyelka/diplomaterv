package rest.test;

import service.SportEventService;
import sportevent.SportEvent;
import model.SportEventViewConverter;
import model.SportEventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSportEventDetailsController {

    private static final String REQUEST_MAPPING = "/test/getEvent/{eventId}";
    
    @Autowired
    private SportEventService eventService;

    @Autowired
    private SportEventViewConverter sportEventConverter;
    
    @RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.GET, produces = "application/json")
    public SportEventModel getSportEventModel(@PathVariable("eventId") int eventId) {
        SportEvent event = eventService.getEvent(eventId);
        SportEventModel eventModel = sportEventConverter.convert(event);
        return eventModel;    
    }
}

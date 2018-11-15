package sports.betting.application.web.controller.rest.test;

import sports.betting.application.service.SportEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteSportEventRestController {

private static final String REQUEST_MAPPING = "/deleteEvent/{eventId}";
    
    @Autowired
    SportEventService eventService;
    
    @RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.DELETE)
    public String getAccountDetails(@PathVariable("eventId") int eventId) {
        eventService.deleteEvent(eventId);
        return "index";
    }
}

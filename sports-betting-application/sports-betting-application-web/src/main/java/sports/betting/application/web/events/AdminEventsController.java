package sports.betting.application.web.events;

import java.util.ArrayList;
import java.util.List;

import sports.betting.application.service.SportEventService;
import sports.betting.application.domain.sportevent.SportEvent;
import sports.betting.application.service.wager.SaveWagerRequest;
import sports.betting.application.web.model.ListEventsModel;
import sports.betting.application.web.model.SportEventViewConverter;
import sports.betting.application.web.model.SportEventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminEventsController {

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

    @RequestMapping("/admin/events")
    public String adminEventsPage() {
        return "admin_events";
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

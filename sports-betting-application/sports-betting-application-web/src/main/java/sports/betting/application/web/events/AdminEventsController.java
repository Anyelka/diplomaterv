package sports.betting.application.web.events;

import java.util.ArrayList;
import java.util.List;

import sports.betting.application.service.event.SportEventService;
import sports.betting.application.domain.sportevent.SportEvent;
import sports.betting.application.web.model.EventListView;
import sports.betting.application.web.model.SportEventView;
import sports.betting.application.web.model.converter.SportEventViewConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminEventsController {

    @Autowired
    private SportEventService sportEventService;

    @Autowired
    private SportEventViewConverter sportEventConverter;


    @ModelAttribute("eventListView")
    public EventListView createListEventsModel() {
        return new EventListView(sportEventConverter.convert(sportEventService.findAll()));
    }

    @RequestMapping("/admin/events")
    public String adminEventsPage() {
        return "admin_events";
    }
}

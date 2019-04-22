package sports.betting.application.web.events;

import sports.betting.application.service.bet.BetService;
import sports.betting.application.service.outcome.OutcomeService;
import sports.betting.application.service.event.SportEventService;
import sports.betting.application.domain.bet.BetType;
import sports.betting.application.domain.outcome.Outcome;
import sports.betting.application.domain.sportevent.EventType;
import sports.betting.application.web.model.BetView;
import sports.betting.application.web.model.OutcomeView;
import sports.betting.application.web.model.SportEventView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddSportEventRestController {

    @Autowired
    private SportEventService eventService;
    
    @Autowired
    private BetService betService;
    
    @Autowired
    private OutcomeService outcomeService;
    
    @RequestMapping(value = "/addEvent", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String getSportEventModel(@RequestBody SportEventView eventModel) {
        eventService.createEvent(eventModel.getTitle(), eventModel.getStartDate(), eventModel.getEndDate(),
                                                    EventType.valueOf(eventModel.getType()));
        for(BetView betView : eventModel.getBets()) {
            betService.createBet(betView.getDescription(), BetType.valueOf(betView.getType()));
            for (OutcomeView outcomeView : betView.getOutcomes()) {
                Outcome outcome = outcomeService.createOutcome(betView.getDescription(), outcomeView.getValue(), Double.parseDouble(outcomeView.getOdd()));
            }
        }
            
        return "The event: "+ eventModel.getTitle() +" was added succesfully.";    
    }
    
}

package sports.betting.application.web.rest;

import sports.betting.application.service.BetService;
import sports.betting.application.service.OutcomeService;
import sports.betting.application.service.SportEventService;
import sports.betting.application.domain.bet.BetType;
import sports.betting.application.domain.outcome.Outcome;
import sports.betting.application.domain.sportevent.EventType;
import sports.betting.application.web.model.BetModel;
import sports.betting.application.web.model.OutcomeModel;
import sports.betting.application.web.model.SportEventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddSportEventRestController {

    private static final String REQUEST_MAPPING = "/addEvent";
    
    @Autowired
    private SportEventService eventService;
    
    @Autowired
    private BetService betService;
    
    @Autowired
    private OutcomeService outcomeService;
    
    @RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String getSportEventModel(@RequestBody SportEventModel eventModel) {
        eventService.createEvent(eventModel.getTitle(), eventModel.getStartDate(), eventModel.getEndDate(),
                                                    EventType.valueOf(eventModel.getType()));
        for(BetModel betModel : eventModel.getBets()) {
            betService.createBet(betModel.getDescription(), BetType.valueOf(betModel.getType()));
            for (OutcomeModel outcomeModel : betModel.getOutcomes()) {
                Outcome outcome = outcomeService.createOutcome(betModel.getDescription(), outcomeModel.getValue(), Double.parseDouble(outcomeModel.getOdd()));
            }
        }
            
        return "The event: "+ eventModel.getTitle() +" was added succesfully.";    
    }
    
}

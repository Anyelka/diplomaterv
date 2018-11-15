package rest;

import service.BetService;
import service.OutcomeService;
import service.SportEventService;
import bet.BetType;
import outcome.Outcome;
import sportevent.EventType;
import model.BetModel;
import model.OutcomeModel;
import model.SportEventModel;
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
                Outcome outcome = outcomeService.createOutcome(betModel.getDescription(), outcomeModel.getValue());
                outcomeService.createOutcomeOdd(outcome, Double.parseDouble(outcomeModel.getOdd()), "2018-06-28 00:00", "2018-06-28 12:00" );
            }
        }
            
        return "The event: "+ eventModel.getTitle() +" was added succesfully.";    
    }
    
}

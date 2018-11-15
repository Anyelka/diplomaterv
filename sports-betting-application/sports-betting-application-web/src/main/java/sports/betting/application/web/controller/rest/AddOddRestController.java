 package sports.betting.application.web.controller.rest;

import sports.betting.application.service.OutcomeService;
import sports.betting.application.domain.outcome.Outcome;
import sports.betting.application.web.model.OutcomeOddModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddOddRestController {

    private static final String REQUEST_MAPPING = "/addOdd";
    
    @Autowired
    private OutcomeService outcomeService;
    
    @RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(code=HttpStatus.CREATED)
    public String addOdd(@RequestBody OutcomeOddModel odd) {
        Outcome outcome = outcomeService.getByFullDescription(odd.getOutcomeFullDescription());
        outcomeService.createOutcomeOdd(outcome, odd.getValue(), odd.getValidFrom(), odd.getValidTo());
        return "The odd was added succesfully.";    
    }
    
}

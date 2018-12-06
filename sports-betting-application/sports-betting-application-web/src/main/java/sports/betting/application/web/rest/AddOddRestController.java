 package sports.betting.application.web.rest;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpStatus;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestMethod;
 import org.springframework.web.bind.annotation.ResponseStatus;
 import org.springframework.web.bind.annotation.RestController;
 import sports.betting.application.dal.outcome.dao.OutcomeDao;
 import sports.betting.application.domain.outcome.Outcome;
 import sports.betting.application.service.OutcomeService;
 import sports.betting.application.web.model.OutcomeOddModel;

@RestController
public class AddOddRestController {

    private static final String REQUEST_MAPPING = "/addOdd";
    
    @Autowired
    private OutcomeService outcomeService;

    @Autowired
    private OutcomeDao outcomeDao;
    
    @RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(code=HttpStatus.CREATED)
    public String addOdd(@RequestBody OutcomeOddModel odd) {
        Outcome outcome = outcomeService.getByFullDescription(odd.getOutcomeFullDescription());
        outcome.setCurrentOdd(odd.getValue());
        outcomeDao.save(outcome);
        return "The odd of the outcome was updated succesfully.";
    }
    
}

package sports.betting.application.web.controller.rest.test;

import sports.betting.application.service.OutcomeService;
import sports.betting.application.domain.outcome.OutcomeOdd;
import sports.betting.application.web.model.OutcomeOddViewConverter;
import sports.betting.application.web.model.OutcomeOddModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestOutcomeOddController {
    
    private static final String REQUEST_MAPPING = "/test/getOutcome/{outcomeOddId}";

    @Autowired
    private OutcomeService outcomeService;

    @Autowired
    private OutcomeOddViewConverter outcomeOddConverter;
    
    @RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.GET, produces="application/json")
    public OutcomeOddModel getOdd(@PathVariable("outcomeOddId") int outcomeOddId) {
        OutcomeOdd odd = outcomeService.getOutcomeOddById(outcomeOddId);

        OutcomeOddModel oddModel = outcomeOddConverter.convert(odd);
        return oddModel;
    }
}

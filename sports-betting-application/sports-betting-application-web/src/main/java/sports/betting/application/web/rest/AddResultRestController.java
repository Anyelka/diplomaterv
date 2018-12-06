package sports.betting.application.web.rest;

import sports.betting.application.service.ResultService;
import sports.betting.application.domain.result.Result;
import sports.betting.application.web.model.result.ResultViewConverter;
import sports.betting.application.web.model.result.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddResultRestController {

    private static final String REQUEST_MAPPING = "/addResult";

    @Autowired
    private ResultService resultService;
    
    @Autowired 
    private ResultViewConverter resultConverter;
    
    @RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.POST, consumes = "application/json")
    public String addResult(@RequestBody ResultModel resultModel) {
        Result result = resultConverter.convert(resultModel);
        resultService.saveResult(result);
        return "Result succesfully added";
    }
}

package sports.betting.application.web.result;

import sports.betting.application.service.result.ResultService;
import sports.betting.application.domain.result.Result;
import sports.betting.application.service.result.model.request.AddSingleBetResultRequest;
import sports.betting.application.service.result.model.request.AddFullTimeResultRequest;
import sports.betting.application.service.result.model.converter.ResultViewConverter;
import sports.betting.application.service.result.model.request.AddBetResultForEventRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sports.betting.application.service.result.model.response.AddBetResultResponse;
import sports.betting.application.service.result.model.response.AddFullTimeResultResponse;

@RestController
@RequestMapping("/addResult")
public class AddResultRestController {

    @Autowired
    private ResultService resultService;
    
    @Autowired 
    private ResultViewConverter resultConverter;
    
    @RequestMapping(value = "betResultForEvent", method = RequestMethod.POST, consumes = "application/json")
    public String addBetResultForEvent(@RequestBody AddBetResultForEventRequest resultModel) {
        Result result = resultConverter.convert(resultModel);
        resultService.save(result);
        return "Result succesfully added";
    }

    @RequestMapping(value = "fullTimeResult", method = RequestMethod.POST, consumes = "application/json")
    public AddFullTimeResultResponse addFullTimeResult(@RequestBody AddFullTimeResultRequest request) {
        return resultService.attemptFullTimeResultSave(request);
    }

    @RequestMapping(value = "betResult", method = RequestMethod.POST, consumes = "application/json")
    public AddBetResultResponse addBetResult(@RequestBody AddSingleBetResultRequest request) {
        return resultService.attemptBetResultSave(request);
    }
}

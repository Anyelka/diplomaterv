package sports.betting.application.web.rest;

import sports.betting.application.service.ResultService;
import sports.betting.application.domain.result.Result;
import sports.betting.application.web.model.result.FullTimeResultModel;
import sports.betting.application.web.model.result.ResultViewConverter;
import sports.betting.application.web.model.result.ResultModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addResult")
public class AddResultRestController {

    @Autowired
    private ResultService resultService;
    
    @Autowired 
    private ResultViewConverter resultConverter;
    
    @RequestMapping(value = "betResult", method = RequestMethod.POST, consumes = "application/json")
    public String addBetResult(@RequestBody ResultModel resultModel) {
        Result result = resultConverter.convert(resultModel);
        resultService.save(result);
        return "Result succesfully added";
    }

    @RequestMapping(value = "fullTimeResult", method = RequestMethod.POST, consumes = "application/json")
    public String addFullTimeResult(@RequestBody FullTimeResultModel resultModel) {
        resultService.saveFullTimeResult(resultModel.getEventTitle(), resultModel.getFullTimeResult());
        return "Result successfuly saved";
    }
}

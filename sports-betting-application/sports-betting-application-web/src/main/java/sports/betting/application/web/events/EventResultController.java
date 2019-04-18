package sports.betting.application.web.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sports.betting.application.service.result.ResultDataGenerator;

@Controller
public class EventResultController {

    @Autowired
    private ResultDataGenerator resultDataGenerator;

    @RequestMapping("generateResults")
    public @ResponseBody
    String generateRandomResults() {
        resultDataGenerator.generateRandomResults();
        return "Random results successfully generated for all events!";
    }
}

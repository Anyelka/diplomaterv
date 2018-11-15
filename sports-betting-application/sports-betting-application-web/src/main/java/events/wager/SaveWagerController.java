package events.wager;

import service.WagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SaveWagerController {

    private static final String REQUEST_MAPPING = "saveWager.html";

    @Autowired
    private WagerService wagerService;
    
    @RequestMapping(REQUEST_MAPPING)
    public String saveWager(SaveWagerRequest saveWagerRequest) {
        wagerService.createWager(saveWagerRequest.getPlayerUsername(), saveWagerRequest.getOutcomeId(), saveWagerRequest.getStake());
        return "redirect:/home.html";
    }
}

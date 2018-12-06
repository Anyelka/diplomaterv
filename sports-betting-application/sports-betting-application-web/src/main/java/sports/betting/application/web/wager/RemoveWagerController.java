package sports.betting.application.web.wager;

import sports.betting.application.service.wager.WagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sports.betting.application.web.wager.model.RemoveWagerRequest;

@Controller
public class RemoveWagerController {

    private static final String REQUEST_MAPPING = "/removeWager.html";

    @Autowired
    private WagerService wagerService;
    
    @RequestMapping(REQUEST_MAPPING)
    public String removeWager(RemoveWagerRequest removeWagerRequest) {
        wagerService.deleteWager(removeWagerRequest.getId());
        return "redirect:/home.html";
    }
}

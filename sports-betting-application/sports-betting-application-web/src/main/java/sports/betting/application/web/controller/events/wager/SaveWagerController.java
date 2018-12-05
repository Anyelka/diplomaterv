package sports.betting.application.web.controller.events.wager;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sports.betting.application.service.wager.CreateWagerResponse;
import sports.betting.application.service.wager.SaveWagerRequest;
import sports.betting.application.service.wager.WagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SaveWagerController {

    private static final String REQUEST_MAPPING = "saveWager";

    @Autowired
    private WagerService wagerService;

    @RequestMapping(REQUEST_MAPPING)
    public @ResponseBody
    CreateWagerResponse createWager(@RequestParam("playerUsername") final String playerUsername, @RequestParam("outcomeId") final int outcomeId,
            @RequestParam("stake") final String stake) {
        return wagerService.attemptWagerCreation(new SaveWagerRequest(playerUsername,outcomeId,stake));
    }
}

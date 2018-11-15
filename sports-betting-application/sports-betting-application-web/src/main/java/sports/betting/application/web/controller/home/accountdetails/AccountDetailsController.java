package sports.betting.application.web.controller.home.accountdetails;

import java.util.ConcurrentModificationException;

import sports.betting.application.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountDetailsController {
    private static final String REQUEST_MAPPING = "/saveAccountDetails.html";

    @Autowired
    private PlayerService playerService;
    
    @RequestMapping(REQUEST_MAPPING)
    public String saveAccountDetails(AccountDetailsRequest accountDetailsRequest) {
        try {
            playerService.updatePlayer(accountDetailsRequest.getName(),
                    accountDetailsRequest.getDateOfBirth(), accountDetailsRequest.getAccountNumber(),
                    accountDetailsRequest.getVersion());
        } catch (ConcurrentModificationException e) {
            return "redirect:/concurrentModificationError.html";
        }
        return "redirect:/home.html";
    }
}

package sports.betting.application.web.controller.home.accountdetails;

import java.util.ConcurrentModificationException;

import org.springframework.security.core.context.SecurityContextHolder;
import sports.betting.application.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.resource.spi.work.SecurityContext;

@Controller
public class AccountDetailsController {
    private static final String REQUEST_MAPPING = "/saveAccountDetails.html";

    @Autowired
    private PlayerService playerService;
    
    @RequestMapping("saveAccountDetails")
    public String saveAccountDetails(AccountDetailsRequest accountDetailsRequest) {
        try {
            playerService.updatePlayer(SecurityContextHolder.getContext().getAuthentication().getName() ,accountDetailsRequest.getName(),
                    accountDetailsRequest.getDateOfBirth(), accountDetailsRequest.getAccountNumber(),
                    accountDetailsRequest.getVersion());
        } catch (ConcurrentModificationException e) {
            return "redirect:/concurrentModificationError.html";
        }
        return "redirect:/home.html";
    }
}

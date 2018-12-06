package sports.betting.application.web.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sports.betting.application.service.user.player.PlayerService;
import sports.betting.application.service.user.player.UpdatePlayerDataResponse;

@Controller
public class AccountDetailsController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping("/saveAccountDetails")
    public @ResponseBody
    UpdatePlayerDataResponse saveAccountDetails(@RequestParam(value = "playerName") final String playerName, @RequestParam(value = "playerDateOfBirth") final String playerDateOfBirth,
            @RequestParam(value = "playerAccountNumber") final String playerAccountNumber) {
        return playerService.attemptPlayerDataUpdate(SecurityContextHolder.getContext().getAuthentication().getName(), playerName, playerDateOfBirth, playerAccountNumber);
    }

}

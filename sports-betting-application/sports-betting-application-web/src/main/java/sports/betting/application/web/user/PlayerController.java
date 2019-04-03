package sports.betting.application.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sports.betting.application.domain.user.User;
import sports.betting.application.service.user.UserService;
import sports.betting.application.service.user.player.PlayerService;
import sports.betting.application.service.user.player.UpdatePlayerDataResponse;
import sports.betting.application.service.wager.CreateWagerResponse;
import sports.betting.application.service.wager.SaveWagerRequest;
import sports.betting.application.service.wager.WagerService;
import sports.betting.application.web.user.converter.AccountDetailsConverter;
import sports.betting.application.web.user.model.request.SaveAccountDetailsRequest;
import sports.betting.application.web.user.model.view.ListWagersView;
import sports.betting.application.web.user.model.request.RemoveWagerRequest;
import sports.betting.application.web.user.converter.ListWagersConverter;

@Controller
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private AccountDetailsConverter accountDetailsConverter;

    @Autowired
    private UserService userService;

    @Autowired
    private ListWagersConverter listWagersConverter;

    @Autowired
    private WagerService wagerService;

    @ModelAttribute("accountDetailsRequest")
    public SaveAccountDetailsRequest createAccountDetailsRequest(){
        User player = getCurrentUser();
        SaveAccountDetailsRequest accountDetailsRequest = accountDetailsConverter.convert(player);
        return accountDetailsRequest;
    }

    @ModelAttribute("listWagersView")
    public ListWagersView createListWagersModel() {
        return listWagersConverter.convert(getCurrentUser());
    }

    @ModelAttribute("removeWagerRequest")
    public RemoveWagerRequest createRemoveWagerRequest() {
        return new RemoveWagerRequest();
    }

    @RequestMapping("home")
    public String homePage() {
        return "player_home";
    }

    @RequestMapping("saveAccountDetails")
    public @ResponseBody
    UpdatePlayerDataResponse saveAccountDetails(@RequestParam(value = "playerName") final String playerName, @RequestParam(value = "playerDateOfBirth") final String playerDateOfBirth,
                                                @RequestParam(value = "playerAccountNumber") final String playerAccountNumber) {
        return playerService.attemptPlayerDataUpdate(SecurityContextHolder.getContext().getAuthentication().getName(), playerName, playerDateOfBirth, playerAccountNumber);
    }

    @RequestMapping("saveWager")
    public @ResponseBody CreateWagerResponse createWager(@RequestParam("playerUsername") final String playerUsername, @RequestParam("outcomeId") final int outcomeId,
                                    @RequestParam("stake") final String stake) {
        return wagerService.attemptWagerCreation(new SaveWagerRequest(playerUsername,outcomeId,stake));
    }

    @RequestMapping("removeWager")
    public String removeWager(RemoveWagerRequest removeWagerRequest) {
        wagerService.deleteWager(removeWagerRequest.getId());
        return "redirect:home";
    }

    private User getCurrentUser() {
        return userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}

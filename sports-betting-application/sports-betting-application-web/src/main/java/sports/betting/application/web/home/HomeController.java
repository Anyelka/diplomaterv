package sports.betting.application.web.home;

import sports.betting.application.service.user.player.PlayerService;

import sports.betting.application.domain.user.User;
import sports.betting.application.web.home.model.AccountDetailsConverter;
import sports.betting.application.web.home.model.SaveAccountDetailsRequest;
import sports.betting.application.web.wager.model.converter.ListWagersConverter;
import sports.betting.application.web.wager.model.ListWagersView;
import sports.betting.application.web.wager.model.RemoveWagerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private AccountDetailsConverter accountDetailsConverter;
    
    @Autowired
    private PlayerService playerService;

    @Autowired
    private ListWagersConverter listWagersConverter;
    
    
    @ModelAttribute("accountDetailsRequest")
    public SaveAccountDetailsRequest createAccountDetailsRequest(){
        User player = getCurrentPlayer();       
        SaveAccountDetailsRequest accountDetailsRequest = accountDetailsConverter.convert(player);
        return accountDetailsRequest;
    }
    
    @ModelAttribute("listWagersModel")
    public ListWagersView createListWagersModel() {
        return listWagersConverter.convert(getCurrentPlayer());
    }
    
    @ModelAttribute("removeWagerRequest")
    public RemoveWagerRequest createRemoveWagerRequest() {
        return new RemoveWagerRequest();
    }
    
    @RequestMapping("/home.html")
    public String homePage() {
        return "home";
    }
    
    private User getCurrentPlayer() {
        return playerService.getPlayerByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}

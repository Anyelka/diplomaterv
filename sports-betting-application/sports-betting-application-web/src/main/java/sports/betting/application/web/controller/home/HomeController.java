package sports.betting.application.web.controller.home;

import sports.betting.application.service.PlayerService;

import sports.betting.application.domain.user.User;
import sports.betting.application.web.controller.home.accountdetails.AccountDetailsConverter;
import sports.betting.application.web.controller.home.accountdetails.AccountDetailsRequest;
import sports.betting.application.web.controller.home.wagers.model.ListWagersConverter;
import sports.betting.application.web.controller.home.wagers.model.ListWagersModel;
import sports.betting.application.web.controller.home.wagers.model.RemoveWagerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    private static final String REQUEST_MAPPING = "/home.html";

    @Autowired
    private AccountDetailsConverter accountDetailsConverter;
    
    @Autowired
    private PlayerService playerService;

    @Autowired
    private ListWagersConverter listWagersConverter;
    
    
    @ModelAttribute("accountDetailsRequest")
    public AccountDetailsRequest createAccountDetailsRequest(){        
        User player = getCurrentPlayer();       
        AccountDetailsRequest accountDetailsRequest = accountDetailsConverter.convert(player);
        return accountDetailsRequest;
    }
    
    @ModelAttribute("listWagersModel")
    public ListWagersModel createListWagersModel() {
        return listWagersConverter.convert(getCurrentPlayer());
    }
    
    @ModelAttribute("removeWagerRequest")
    public RemoveWagerRequest createRemoveWagerRequest() {
        return new RemoveWagerRequest();
    }
    
    @RequestMapping(REQUEST_MAPPING)
    public String homePage() {
        return "home";
    }
    
    private User getCurrentPlayer() {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        return playerService.getPlayerByUsername(currentUsername);
    }
}

package home;

import service.PlayerService;

import user.User;
import home.accountdetails.AccountDetailsConverter;
import home.accountdetails.AccountDetailsRequest;
import home.wagers.ListWagersConverter;
import home.wagers.ListWagersModel;
import home.wagers.RemoveWagerRequest;
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
        User player = getCurrentPlayer();
        return listWagersConverter.convert(player);
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

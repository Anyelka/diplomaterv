package sports.betting.application.web.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import sports.betting.application.domain.user.User;
import sports.betting.application.service.user.UserService;
import sports.betting.application.service.user.player.PlayerService;
import sports.betting.application.web.home.model.AccountDetailsConverter;
import sports.betting.application.web.home.model.SaveAccountDetailsRequest;
import sports.betting.application.web.wager.model.ListWagersView;
import sports.betting.application.web.wager.model.RemoveWagerRequest;
import sports.betting.application.web.wager.model.converter.ListWagersConverter;

@Controller
public class UserHomeController {

    @Autowired
    private AccountDetailsConverter accountDetailsConverter;

    @Autowired
    private UserService userService;

    @Autowired
    private ListWagersConverter listWagersConverter;

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

    @RequestMapping("/home.html")
    public String homePage() {
        return "home";
    }

    private User getCurrentUser() {
        return userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}

package sports.betting.application.web.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sports.betting.application.domain.user.User;
import sports.betting.application.service.user.UserService;

@Controller
public class DecideHomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/decidehome")
    public String homePage() {
        final User currentUser = getCurrentUser();
        if(userService.isAdmin(currentUser)){
            return "redirect:admin_events.html";
        }
        return "redirect:home.html";
    }

    private User getCurrentUser() {
        return userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}

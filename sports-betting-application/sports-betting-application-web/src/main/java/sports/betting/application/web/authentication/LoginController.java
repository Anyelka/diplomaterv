package sports.betting.application.web.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {

    @ModelAttribute("loginRequest")
    public LoginRequest createLoginRequest() {
        return new LoginRequest();
    }

    @RequestMapping("/index.html")
    public String showLoginPage() {
        return "index";
    }
}

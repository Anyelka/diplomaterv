package sports.betting.application.web.controller.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {

    private static final String REQUEST_MAPPING = "/index.html";

    @ModelAttribute("loginRequest")
    public LoginRequest createLoginRequest() {
        return new LoginRequest();
    }

    @RequestMapping(REQUEST_MAPPING)
    public String showLoginPage() {
        return "index";
    }
}

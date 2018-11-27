package sports.betting.application.web.controller.register;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {

    private static final String REQUEST_MAPPING = "/register.html";

    @ModelAttribute("registrationRequest")
    public RegistrationRequest createRegistrationRequest() {
        return new RegistrationRequest();
    }

    @RequestMapping(REQUEST_MAPPING)
    public String showRegistrationPage() {
        return "register";
    }

    @RequestMapping("sendRegistrationRequest")
    public void register(RegistrationRequest registrationRequest) {
        System.out.println("Registration request sent with: ");
        System.out.println("\t -> " + registrationRequest.getEmail());
        System.out.println("\t -> " + registrationRequest.getUsername());
        System.out.println("\t -> " + registrationRequest.getPassword());

    }
}

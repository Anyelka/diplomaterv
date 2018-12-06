package sports.betting.application.web.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sports.betting.application.service.registration.RegistrationRequest;
import sports.betting.application.service.registration.RegistrationResponse;
import sports.betting.application.service.registration.RegistrationService;

import java.util.Currency;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @ModelAttribute("registrationRequest")
    public RegistrationRequest createRegistrationRequest() {
        return new RegistrationRequest();
    }

    @RequestMapping("register.html")
    public String showRegistrationPage(RegistrationResponse registrationResponse) {
        return "register";
    }

    @RequestMapping("sendRegistrationRequest")
    public @ResponseBody
    RegistrationResponse register(@RequestParam("email") final String email, @RequestParam("username") final String username, @RequestParam("password") final String password,
            @RequestParam("fullName") final String fullName, @RequestParam("accountNumber") final String accountNumber, @RequestParam("dateOfBirth") final String dateOfBirth,
            @RequestParam("currency") final Currency currency) {
        RegistrationRequest request = new RegistrationRequest(email, username, password, fullName, accountNumber, currency, dateOfBirth);
        return registrationService.attemptRegistration(request);
    }

    @RequestMapping("successfulRegistration.html")
    public String showSuccessfulRegistrationPage() {
        return "successfulRegistration";
    }
}

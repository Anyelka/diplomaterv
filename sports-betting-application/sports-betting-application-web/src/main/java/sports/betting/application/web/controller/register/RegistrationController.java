package sports.betting.application.web.controller.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import sports.betting.application.domain.user.PlayerData;
import sports.betting.application.domain.user.UserCredentials;
import sports.betting.application.service.PlayerService;
import sports.betting.application.service.formatter.DateFormatter;

@Controller
public class RegistrationController {

    private static final String REQUEST_MAPPING = "/register.html";

    @Autowired
    private DateFormatter dateFormatter;

    @Autowired
    private PlayerService userService;

    @ModelAttribute("registrationRequest")
    public RegistrationRequest createRegistrationRequest() {
        return new RegistrationRequest();
    }

    @RequestMapping(REQUEST_MAPPING)
    public String showRegistrationPage() {
        return "register";
    }

    @RequestMapping("sendRegistrationRequest")
    public String register(RegistrationRequest registrationRequest) {
        UserCredentials credentials = new UserCredentials(registrationRequest.getEmail(), registrationRequest.getUsername(), registrationRequest.getPassword());
        PlayerData playerData = new PlayerData(registrationRequest.getFullName(), registrationRequest.getAccountNumber(),0, registrationRequest.getCurrency(), dateFormatter.parseDate(registrationRequest.getDateOfBirth()));
        userService.createRegisteringPlayer(credentials, playerData);
        return "successfulRegistration";
    }
}

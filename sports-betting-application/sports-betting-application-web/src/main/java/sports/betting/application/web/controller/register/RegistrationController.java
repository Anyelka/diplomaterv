package sports.betting.application.web.controller.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sports.betting.application.domain.user.PlayerData;
import sports.betting.application.domain.user.UserCredentials;
import sports.betting.application.service.formatter.DateFormatter;
import sports.betting.application.service.registration.RegistrationResponse;
import sports.betting.application.service.registration.RegistrationService;

@Controller
public class RegistrationController {

    public static final String SUCCESSFUL_REGISTRATION_URL = "successfulRegistration.html";
    public static final String REGISTRATION_URL = "register.html";

    @Autowired
    private DateFormatter dateFormatter;

    @Autowired
    private RegistrationService registrationService;

    @ModelAttribute("registrationRequest")
    public RegistrationRequest createRegistrationRequest() {
        return new RegistrationRequest();
    }

//    @ModelAttribute("registrationResponse")
//    public RegistrationResponse createRegistrationResponse() {
//        return new RegistrationResponse();
//    }

    @RequestMapping(REGISTRATION_URL)
    public String showRegistrationPage(@ModelAttribute("registrationResponse") RegistrationResponse registrationResponse) {
        return "register";
    }

    @RequestMapping(value = "sendRegistrationRequest", method = RequestMethod.POST)
    public String register(final RegistrationRequest registrationRequest, final RedirectAttributes redirectAttributes) {
        String redirectAddress;
        UserCredentials credentials = new UserCredentials(registrationRequest.getEmail(), registrationRequest.getUsername(), registrationRequest.getPassword());
        PlayerData playerData = new PlayerData(registrationRequest.getFullName(), registrationRequest.getAccountNumber(),0, registrationRequest.getCurrency(), dateFormatter.parseDate(registrationRequest.getDateOfBirth()));

        RegistrationResponse registrationResponse = registrationService.attemptRegistration(playerData, credentials);
        if(registrationResponse.isValid()) {
            redirectAddress = SUCCESSFUL_REGISTRATION_URL;
        } else {
            redirectAddress = REGISTRATION_URL;
            redirectAttributes.addFlashAttribute("registrationResponse", registrationResponse);
        }
        return "redirect:"+redirectAddress;
    }

    @RequestMapping(SUCCESSFUL_REGISTRATION_URL)
    public String showSuccessfulRegistrationPage() {
        return "successfulRegistration";
    }
}

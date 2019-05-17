package sports.betting.application.service.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sports.betting.application.domain.user.PlayerData;
import sports.betting.application.domain.user.UserCredentials;
import sports.betting.application.service.player.PlayerService;
import sports.betting.application.service.registration.model.RegistrationRequest;
import sports.betting.application.service.registration.model.RegistrationResponse;
import sports.betting.application.service.registration.validation.RegistrationValidator;

@Component
public class RegistrationService {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private RegistrationValidator registrationValidator;

    public RegistrationResponse attemptRegistration(RegistrationRequest registrationRequest) {
        UserCredentials credentials = new UserCredentials(registrationRequest.getEmail(), registrationRequest.getUsername(), registrationRequest.getPassword());
        PlayerData playerData = new PlayerData(registrationRequest.getFullName(), registrationRequest.getAccountNumber(),0, registrationRequest.getCurrency().toString(), registrationRequest.getDateOfBirth());

        RegistrationResponse response = registrationValidator.checkRegistrationRequest(playerData, credentials);

        if(response.isValid()) {
            playerService.createPlayer(playerData, credentials,true);
        }
        return response;
    }

}

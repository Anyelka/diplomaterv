package sports.betting.application.service.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sports.betting.application.domain.user.PlayerData;
import sports.betting.application.domain.user.UserCredentials;
import sports.betting.application.service.PlayerService;
import sports.betting.application.service.UserService;

import java.util.Optional;

@Component
public class RegistrationService {

    @Autowired
    private PlayerService playerService;

    @Autowired
    private UserService userService;

    public RegistrationResponse attemptRegistration(PlayerData playerData, UserCredentials credentials) {
        RegistrationResponse response = checkRegistrationRequest(playerData, credentials);
        if(response.isValid()) {
            playerService.createPlayer(playerData, credentials,true);
        }
        return response;
    }

    private RegistrationResponse checkRegistrationRequest(PlayerData playerData, UserCredentials credentials) {
        RegistrationResponse registrationResponse = new RegistrationResponse();
        registrationResponse.setUsernameError(checkUsernameErrors(credentials.getUsername()));
        return registrationResponse;
    }

    private Optional<String> checkUsernameErrors(String username) {
        if(userService.checkIfUserExists(username)) {
            return Optional.of("The given username is already used by someone else!");
        }

        return Optional.empty();
    }
}

package sports.betting.application.web.user;

import sports.betting.application.service.player.PlayerService;
import sports.betting.application.domain.user.User;
import sports.betting.application.web.user.model.converter.AccountDetailsConverter;
import sports.betting.application.web.user.model.request.SaveAccountDetailsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetAccountDetailsRestController {

    private static final String REQUEST_MAPPING = "/getAccountDetails/{userId}";
    
    @Autowired
    PlayerService playerService;

    @Autowired
    private AccountDetailsConverter accountDetailsConverter;
    
    @RequestMapping(value = REQUEST_MAPPING, method = RequestMethod.GET, produces = "application/json")
    public SaveAccountDetailsRequest getAccountDetails(@PathVariable("userId") int userId) {
        User player = playerService.getPlayerById(userId);
        return accountDetailsConverter.convert(player);
    }
}

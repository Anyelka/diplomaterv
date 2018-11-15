package rest;

import service.PlayerService;
import user.User;
import home.accountdetails.AccountDetailsConverter;
import home.accountdetails.AccountDetailsRequest;
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
    public AccountDetailsRequest getAccountDetails(@PathVariable("userId") int userId) {
        User player = playerService.getPlayerById(userId);
        return accountDetailsConverter.convert(player);
    }
}

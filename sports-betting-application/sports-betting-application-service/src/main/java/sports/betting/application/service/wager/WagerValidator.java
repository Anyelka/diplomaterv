package sports.betting.application.service.wager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sports.betting.application.domain.user.User;
import sports.betting.application.service.player.PlayerService;

@Component
public class WagerValidator {

    @Autowired
    private PlayerService playerService;

    public CreateWagerResponse checkCreateWagerRequest(SaveWagerRequest saveWagerRequest) {
        CreateWagerResponse response = new CreateWagerResponse();
        response.setStakeError(getStakeError(saveWagerRequest.getPlayerUsername(), saveWagerRequest.getStake()));
        return response;
    }

    private String getStakeError(String playerUsername, String stake) {
        if(notInt(stake)) {
            return "The stake is in the wrong format!";
        }
        if(isNonPositive(Integer.parseInt(stake))) {
            return "You must give a positive stake!";
        }
        User player = playerService.getPlayerByUsername(playerUsername);
        if(Integer.parseInt(stake) > player.getPlayerData().get().getBalance()){
            return "You don't have enough money for that stake!";
        }
        return "";
    }

    private boolean notInt(String stake) {
        try{
            Integer.parseInt(stake);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    private boolean isNonPositive(int number) {
        return number <= 0;
    }
}

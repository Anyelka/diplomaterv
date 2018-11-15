package sports.betting.application.web.controller.home.wagers;

import java.util.List;

import sports.betting.application.domain.wager.Wager;

public class ListWagersModel {
    List<Wager> wagers;

    public List<Wager> getWagers() {
        return wagers;
    }

    public void setWagers(List<Wager> wagers) {
        this.wagers = wagers;
    }
    
}

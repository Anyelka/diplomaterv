package sports.betting.application.web.wager.model;

import java.util.List;

public class ListWagersView {
    List<WagerView> wagers;

    public List<WagerView> getWagers() {
        return wagers;
    }

    public void setWagers(List<WagerView> wagers) {
        this.wagers = wagers;
    }
    
}

package sports.betting.application.web.controller.home.wagers.model;

import java.util.List;

public class ListWagersModel {
    List<WagerView> wagers;

    public List<WagerView> getWagers() {
        return wagers;
    }

    public void setWagers(List<WagerView> wagers) {
        this.wagers = wagers;
    }
    
}

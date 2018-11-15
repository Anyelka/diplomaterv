package sports.betting.application.web.controller.home.wagers;

import java.util.List;

import sports.betting.application.service.WagerService;
import sports.betting.application.domain.user.User;
import sports.betting.application.domain.wager.Wager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ListWagersConverter implements Converter<User, ListWagersModel> {

    @Autowired
    private WagerService wagerService;
    
    @Override
    public ListWagersModel convert(User player) {
        ListWagersModel listWagersModel = new ListWagersModel();
        List<Wager> wagersOfPlayer = wagerService.getWagersOfPlayer(player);
        listWagersModel.setWagers(wagersOfPlayer);
        return listWagersModel;
    }

}

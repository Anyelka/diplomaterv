package sports.betting.application.web.controller.home.wagers.model;

import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private WagerViewConverter wagerViewConverter;
    
    @Override
    public ListWagersModel convert(User player) {
        ListWagersModel listWagersModel = new ListWagersModel();
        List<Wager> wagersOfPlayer = wagerService.getWagersOfPlayer(player);
        listWagersModel.setWagers(wagersOfPlayer.stream().map(wager -> wagerViewConverter.convert(wager)).collect(Collectors.toList()));
        return listWagersModel;
    }

}

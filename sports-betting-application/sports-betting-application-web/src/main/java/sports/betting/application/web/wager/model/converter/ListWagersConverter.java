package sports.betting.application.web.wager.model.converter;

import java.util.List;
import java.util.stream.Collectors;

import sports.betting.application.service.wager.WagerService;
import sports.betting.application.domain.user.User;
import sports.betting.application.domain.wager.Wager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sports.betting.application.web.wager.model.ListWagersView;

@Component
public class ListWagersConverter implements Converter<User, ListWagersView> {

    @Autowired
    private WagerService wagerService;

    @Autowired
    private WagerViewConverter wagerViewConverter;
    
    @Override
    public ListWagersView convert(User player) {
        ListWagersView listWagersView = new ListWagersView();
        List<Wager> wagersOfPlayer = wagerService.getWagersOfPlayer(player);
        listWagersView.setWagers(wagersOfPlayer.stream().map(wager -> wagerViewConverter.convert(wager)).collect(Collectors.toList()));
        return listWagersView;
    }

}

package sports.betting.application.web.user.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sports.betting.application.domain.user.User;
import sports.betting.application.domain.wager.Wager;
import sports.betting.application.service.wager.WagerService;
import sports.betting.application.web.user.model.view.ListWagersView;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListWagersConverter {

    @Autowired
    private WagerService wagerService;

    @Autowired
    private WagerViewConverter wagerViewConverter;
    
    public ListWagersView convert(User player) {
        List<Wager> wagersOfPlayer = wagerService.getWagersOfPlayer(player);
        return new ListWagersView(wagerViewConverter.convert(wagersOfPlayer));
    }

}

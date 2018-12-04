package sports.betting.application.web.model;

import java.util.ArrayList;
import java.util.List;

import sports.betting.application.lib.formatter.DateFormatter;
import sports.betting.application.service.BetService;
import sports.betting.application.domain.bet.Bet;
import sports.betting.application.domain.sportevent.SportEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SportEventViewConverter implements Converter<SportEvent, SportEventModel> {

    @Autowired
    private BetService betService;
    
    @Autowired 
    private BetViewConverter betConverter;
    
    @Autowired
    private DateFormatter formatter;
    
    @Override
    public SportEventModel convert(SportEvent sportEvent) {
        SportEventModel sportEventModel = new SportEventModel();
        List<Bet> bets = betService.getAllByEvent(sportEvent);
        sportEventModel.setBets(transferBets(bets));
        sportEventModel.setId(sportEvent.getId());
        sportEventModel.setTitle(sportEvent.getTitle());
        sportEventModel.setStartDate(formatter.formatDate(sportEvent.getStartDate()));   
        sportEventModel.setEndDate(formatter.formatDate(sportEvent.getEndDate()));
        sportEventModel.setType(sportEvent.getEventType().toString());
        sportEventModel.setEnded(sportEvent.isEnded());
        return sportEventModel;
    }
    
    private List<BetModel> transferBets(List<Bet> bets) {
        List<BetModel> transferredBets = new ArrayList<BetModel>();
        for(Bet bet : bets) {
            transferredBets.add(betConverter.convert(bet));
        }
        return transferredBets;
    }
    
}

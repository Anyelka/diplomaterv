package sports.betting.application.dal.bet.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import sports.betting.application.domain.bet.Bet;
import sports.betting.application.domain.sportevent.SportEvent;

@Component
public interface BetDao {
    public Bet getByDescription(String description);
    public List<Bet> getAllByEvent(SportEvent event);
    public void save(Bet bet);
}

package sports.betting.application.dal.bet.dao;

import org.springframework.stereotype.Component;
import sports.betting.application.domain.bet.Bet;
import sports.betting.application.domain.sportevent.SportEvent;

import java.util.List;
import java.util.Optional;

@Component
public interface BetDao {
    public Optional<Bet> getByDescription(String description);
    public List<Bet> getAllByEvent(SportEvent event);
    public void save(Bet bet);
}

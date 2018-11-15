package bet.dao;

import java.util.List;

import bet.Bet;
import sportevent.SportEvent;

public interface BetDao {
    public Bet getByDescription(String description);
    public List<Bet> getAllByEvent(SportEvent event);
    public void save(Bet bet);
}

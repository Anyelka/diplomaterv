package sports.betting.application.dal.result.dao;

import sports.betting.application.domain.bet.Bet;
import sports.betting.application.domain.result.Result;
import sports.betting.application.domain.sportevent.SportEvent;

import java.util.List;

public interface ResultDao {
    public void save(Result result);
    public Result getByBet(Bet bet);
    public List<Result> getAllByEvent(SportEvent event);
}

package sports.betting.application.dal.result.dao;

import sports.betting.application.domain.bet.Bet;
import sports.betting.application.domain.result.Result;

public interface ResultDao {
    public void save(Result result);
    public Result getByBet(Bet bet);
}

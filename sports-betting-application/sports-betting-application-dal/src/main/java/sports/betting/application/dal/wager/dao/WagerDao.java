package sports.betting.application.dal.wager.dao;

import java.util.List;

import sports.betting.application.domain.user.User;
import sports.betting.application.domain.wager.Wager;

public interface WagerDao {
    Wager getById(int id);
    List<Wager> getAll();
    List<Wager> getAllByPlayer(User player);
    void save(Wager wager);
    void delete(Wager wager);
}

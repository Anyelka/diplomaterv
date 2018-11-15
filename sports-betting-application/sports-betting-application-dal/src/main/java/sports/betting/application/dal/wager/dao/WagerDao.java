package sports.betting.application.dal.wager.dao;

import java.util.List;

import sports.betting.application.domain.user.User;
import sports.betting.application.domain.wager.Wager;

public interface WagerDao {
    public Wager getById(int id);
    public List<Wager> getAll();
    public List<Wager> getAllByPlayer(User player);
    public void save(Wager wager);
    public void delete(Wager wager);
}

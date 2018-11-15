package sports.betting.application.dal.sportevent.dao;

import java.util.List;

import sports.betting.application.domain.sportevent.SportEvent;

public interface SportEventDao {
    public SportEvent getByTitle(String title);
    public SportEvent getById(int id);
    public List<SportEvent> getAll();
    public void save(SportEvent sportEvent);
    public void delete(SportEvent sportEvent);
    public void delete(int id);
}

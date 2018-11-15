package service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.sports.betting.application.dal.sportevent.dao.SportEventDao;
import sportevent.EventType;
import sportevent.SportEvent;
import org.springframework.beans.factory.annotation.Autowired;

public class SportEventService {
    
    @Autowired
    private DateTimeFormatter formatter;
    
    @Autowired
    private SportEventDao sportEventDao;

    public void createEvent(String title, String startDate, String endDate, EventType type) {
        LocalDateTime start = LocalDateTime.parse(startDate, formatter);
        LocalDateTime end = LocalDateTime.parse(endDate, formatter);

        SportEvent event = new SportEvent(title, start, end, type);
        sportEventDao.save(event);
    }
    
    public void deleteEvent(int id) {
        sportEventDao.delete(id);
    }
    
    public List<SportEvent> findAll() {
        return sportEventDao.getAll();
    }
    
    public SportEvent getEvent(int id) {
        return sportEventDao.getById(id);
    }
    
    public SportEvent getEvent(String title) {
        return sportEventDao.getByTitle(title);
    }

    public void updateEvent(SportEvent event) {
        event.setEnded(true);
        sportEventDao.save(event);
    }

}

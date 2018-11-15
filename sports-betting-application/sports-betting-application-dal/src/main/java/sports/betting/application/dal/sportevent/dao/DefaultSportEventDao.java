package sports.betting.application.dal.sportevent.dao;

import java.util.List;
import java.util.stream.Collectors;

import sports.betting.application.dal.sportevent.dao.converter.SportEventBackConverter;
import sports.betting.application.dal.sportevent.dao.converter.SportEventConverter;
import sports.betting.application.dal.sportevent.repository.SportEventRepository;
import sports.betting.application.domain.sportevent.SportEvent;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;

public class DefaultSportEventDao implements SportEventDao {

    @Autowired
    private SportEventRepository sportEventRepository;
    
    @Autowired
    private SportEventConverter sportEventConverter;
    
    @Autowired
    private SportEventBackConverter sportEventBackConverter;
    
    @Override
    public SportEvent getByTitle(String title) {
        return sportEventConverter.convert(sportEventRepository.findByTitle(title));
    }

    @Override
    public SportEvent getById(int id) {
        return sportEventConverter.convert(sportEventRepository.findById(id));
    }

    @Override
    public List<SportEvent> getAll() {
        return Lists.newArrayList(sportEventRepository.findAll()).stream().map(se -> sportEventConverter.convert(se)).collect(Collectors.toList());
    }

    @Override
    public void save(SportEvent sportEvent) {
        sportEventRepository.save(sportEventBackConverter.convert(sportEvent));
    }

    @Override
    public void delete(SportEvent sportEvent) {
        sportEventRepository.delete(sportEventBackConverter.convert(sportEvent));
    }

    @Override
    public void delete(int id) {
        sportEventRepository.deleteById(id);
        
    }
    
}

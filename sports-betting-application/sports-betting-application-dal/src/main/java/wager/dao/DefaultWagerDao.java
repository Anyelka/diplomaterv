package wager.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.sports.betting.application.dal.user.dao.converter.UserBackConverter;
import wager.dao.converter.WagerBackConverter;
import wager.dao.converter.WagerConverter;
import wager.repository.WagerRepository;
import user.User;
import wager.Wager;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;

public class DefaultWagerDao implements WagerDao {

    @Autowired
    private UserBackConverter userBackConverter;
    
    @Autowired
    private WagerConverter wagerConverter;
    
    @Autowired
    private WagerBackConverter wagerBackConverter;
    
    @Autowired
    private WagerRepository wagerRepository;
    
    @Override
    public Wager getById(int id) {
        return wagerConverter.convert(wagerRepository.findById(id).get());
    }

    @Override
    public List<Wager> getAll() {
        return Lists.newArrayList(wagerRepository.findAll()).stream().map(wagerEntity -> wagerConverter.convert(wagerEntity)).collect(Collectors.toList());
    }

    @Override
    public List<Wager> getAllByPlayer(User player) {
        return Lists.newArrayList(wagerRepository.findAllByPlayer(userBackConverter.convert(player))).stream().map(wagerEntity -> wagerConverter.convert(wagerEntity)).collect(Collectors.toList());
    }

    @Override
    public void save(Wager wager) {
        wagerRepository.save(wagerBackConverter.convert(wager));
    }

    @Override
    public void delete(Wager wager) {
        wagerRepository.delete(wagerBackConverter.convert(wager));
    }

}

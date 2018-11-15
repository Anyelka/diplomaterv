package sports.betting.application.service;

import sports.betting.application.dal.result.dao.ResultDao;
import sports.betting.application.domain.result.Result;
import org.springframework.beans.factory.annotation.Autowired;

public class ResultService {
    
    @Autowired
    private ResultDao resultDao;
    
    @Autowired
    private SportEventService eventService;

    @Autowired
    private WagerService wagerService;

    public void saveResult(Result result) {
        resultDao.save(result);
        
        eventService.updateEvent(result.getBet().getEvent());
            
        wagerService.updateWagers(result);
    }

}

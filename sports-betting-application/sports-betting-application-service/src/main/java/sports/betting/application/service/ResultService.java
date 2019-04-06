package sports.betting.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import sports.betting.application.dal.result.dao.ResultDao;
import sports.betting.application.domain.bet.Bet;
import sports.betting.application.domain.outcome.Outcome;
import sports.betting.application.domain.result.Result;
import sports.betting.application.domain.sportevent.SportEvent;
import sports.betting.application.service.wager.WagerService;

public class ResultService {
    
    @Autowired
    private ResultDao resultDao;
    
    @Autowired
    private SportEventService eventService;

    @Autowired
    private WagerService wagerService;

    @Autowired
    private BetService betService;

    @Autowired
    private OutcomeService outcomeService;

    public void save(Result result) {
        resultDao.save(result);
        
        eventService.updateEvent(result.getBet().getEvent());
            
        wagerService.updateWagers(result);
    }

    public void saveFullTimeResult(String eventTitle, String fullTimeResult) {
        SportEvent event = eventService.getEvent(eventTitle);
        Bet ftBet = betService.getByDescription(event.getTitle() + " -- Full Time Result");
        Bet goalsOUBet = betService.getByDescription(event.getTitle() + " -- Goals Over/Under (2.5)");
        Outcome ftOutcome = outcomeService.getByBetAndValue(ftBet, getFTResultOutcomeValue(fullTimeResult));
        Outcome goalsOUOutcome = outcomeService.getByBetAndValue(goalsOUBet, getGoalsOUResultOutcomeValue(fullTimeResult));
        Result ftResult = new Result(ftBet, ftOutcome);
        Result goalsOUResult = new Result(goalsOUBet, goalsOUOutcome);
        save(ftResult);
        save(goalsOUResult);
    }

    private String getFTResultOutcomeValue(String fullTimeResult) {
        int homeScore = Integer.parseInt(fullTimeResult.split("-")[0]);
        int awayScore = Integer.parseInt(fullTimeResult.split("-")[1]);
        String ftOutcomeValue;
        if (homeScore > awayScore) {
            ftOutcomeValue = "HOME";
        } else if (homeScore == awayScore){
            ftOutcomeValue = "DRAW";
        } else {
            ftOutcomeValue = "AWAY";
        }
        return ftOutcomeValue;
    }

    private String getGoalsOUResultOutcomeValue(String fullTimeResult) {
        int homeScore = Integer.parseInt(fullTimeResult.split("-")[0]);
        int awayScore = Integer.parseInt(fullTimeResult.split("-")[1]);
        String goalsOUOutcomeValue;
        if ((homeScore + awayScore) > 2.5) {
            goalsOUOutcomeValue = "OVER";
        } else {
            goalsOUOutcomeValue = "UNDER";
        }
        return goalsOUOutcomeValue;
    }
}

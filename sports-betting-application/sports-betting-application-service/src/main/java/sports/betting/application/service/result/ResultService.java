package sports.betting.application.service.result;

import org.springframework.beans.factory.annotation.Autowired;
import sports.betting.application.dal.result.dao.ResultDao;
import sports.betting.application.domain.bet.Bet;
import sports.betting.application.domain.outcome.Outcome;
import sports.betting.application.domain.result.Result;
import sports.betting.application.domain.sportevent.SportEvent;
import sports.betting.application.service.bet.BetService;
import sports.betting.application.service.outcome.OutcomeService;
import sports.betting.application.service.event.SportEventService;
import sports.betting.application.service.result.model.request.AddFullTimeResultRequest;
import sports.betting.application.service.result.model.request.AddSingleBetResultRequest;
import sports.betting.application.service.result.model.response.AddBetResultResponse;
import sports.betting.application.service.result.model.response.AddFullTimeResultResponse;
import sports.betting.application.service.wager.WagerService;

import java.util.Optional;

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

    @Autowired
    private ResultValidator resultValidator;

    public void save(Result result) {
        resultDao.save(result);
        betService.end(result.getBet(), result.getOutcome().toCapitalizedString());
        wagerService.updateWagers(result);
    }

    public AddFullTimeResultResponse attemptFullTimeResultSave(AddFullTimeResultRequest request) {
        AddFullTimeResultResponse response = resultValidator.checkAddFullTimeResultRequest(request);
        if(response.isValid()) {
            saveFullTimeResult(request.getEventId(), request.getFullTimeResult());
        }
        return response;
    }

    public AddBetResultResponse attemptBetResultSave(AddSingleBetResultRequest request) {
        AddBetResultResponse response = resultValidator.checkAddBetResultRequest(request);
        if(response.isValid()) {
            saveBetResult(request.getBetDescription(), request.getOutcomeValue());
        }
        return response;
    }

    private void saveFullTimeResult(int eventId, String fullTimeResult) {
        SportEvent event = eventService.getEvent(eventId);
        Optional<Bet> ftBet = betService.getByDescription(event.getTitle() + " -- Full Time Result");
        Optional<Bet> goalsOUBet = betService.getByDescription(event.getTitle() + " -- Goals Over/Under (2.5)");
        if(ftBet.isPresent()) {
            Outcome ftOutcome = outcomeService.getByBetAndValue(ftBet.get(), getFTResultOutcomeValue(fullTimeResult));
            Result ftResult = new Result(ftBet.get(), ftOutcome);
            save(ftResult);
        }
        if(goalsOUBet.isPresent()) {
            Outcome goalsOUOutcome = outcomeService.getByBetAndValue(goalsOUBet.get(), getGoalsOUResultOutcomeValue(fullTimeResult));
            Result goalsOUResult = new Result(goalsOUBet.get(), goalsOUOutcome);
            save(goalsOUResult);
        }
        eventService.addFullTimeResult(event, fullTimeResult);
    }

    private String getFTResultOutcomeValue(String fullTimeResult) {
        int homeScore = Integer.parseInt(fullTimeResult.split("-")[0].trim());
        int awayScore = Integer.parseInt(fullTimeResult.split("-")[1].trim());
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
        int homeScore = Integer.parseInt(fullTimeResult.split("-")[0].trim());
        int awayScore = Integer.parseInt(fullTimeResult.split("-")[1].trim());
        String goalsOUOutcomeValue;
        if ((homeScore + awayScore) > 2.5) {
            goalsOUOutcomeValue = "OVER";
        } else {
            goalsOUOutcomeValue = "UNDER";
        }
        return goalsOUOutcomeValue;
    }

    private void saveBetResult(String betDescription, String outcomeValue) {
        Optional<Bet> bet = betService.getByDescription(betDescription);
        Outcome outcome = outcomeService.getByBetAndValue(bet.get(), outcomeValue);
        Result result = new Result(bet.get(), outcome);
        save(result);
    }
}

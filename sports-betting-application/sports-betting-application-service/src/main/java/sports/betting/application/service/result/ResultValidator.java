package sports.betting.application.service.result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sports.betting.application.dal.result.dao.ResultDao;
import sports.betting.application.domain.bet.Bet;
import sports.betting.application.domain.bet.BetType;
import sports.betting.application.domain.result.Result;
import sports.betting.application.domain.sportevent.SportEvent;
import sports.betting.application.lib.validate.FormatValidator;
import sports.betting.application.service.bet.BetService;
import sports.betting.application.service.event.SportEventService;
import sports.betting.application.service.outcome.OutcomeService;
import sports.betting.application.service.result.model.request.AddFullTimeResultRequest;
import sports.betting.application.service.result.model.request.AddSingleBetResultRequest;
import sports.betting.application.service.result.model.response.AddBetResultResponse;
import sports.betting.application.service.result.model.response.AddFullTimeResultResponse;

import java.util.List;
import java.util.Optional;

@Component
public class ResultValidator {

    @Autowired
    private SportEventService eventService;

    @Autowired
    private BetService betService;

    @Autowired
    private OutcomeService outcomeService;

    @Autowired
    private FormatValidator formatValidator;

    @Autowired
    private ResultDao resultDao;

    public AddFullTimeResultResponse checkAddFullTimeResultRequest(AddFullTimeResultRequest request) {
        AddFullTimeResultResponse response = new AddFullTimeResultResponse();
        response.setEventIdError(getEventIdError(request.getEventId()));
        response.setFullTimeResultError(getFullTimeResultError(request.getFullTimeResult()));
        response.setExistingResultError(getExistingEventResultError(request.getEventId()));
        return response;
    }

    public AddBetResultResponse checkAddBetResultRequest(AddSingleBetResultRequest request) {
        AddBetResultResponse response = new AddBetResultResponse();
        response.setBetDescriptionError(getBetDescriptionError(request.getBetDescription()));
        response.setOutcomeValueError(getOutcomeValueError(request.getBetDescription(), request.getOutcomeValue()));
        response.setExistingResultError(getExistingBetResultError(request.getBetDescription()));
        return response;
    }

    private String getEventIdError(int eventId) {
        SportEvent event = eventService.getEvent(eventId);
        if(event == null) {
            return "There is not an event with the given id!";
        }
        return "";
    }

    private String getFullTimeResultError(String fullTimeResult) {
        if(!formatValidator.isValidFullTimeResultFormat(fullTimeResult)) {
            return "The given full time result is in wrong format!";
        } else if(!isValidScore(fullTimeResult)) {
            return "The given score is not valid!";
        }
        return "";
    }

    private String getExistingEventResultError(int eventId) {
        SportEvent event = eventService.getEvent(eventId);
        if(hasResult(event)) {
            return "The event already has a result!";
        }
        return "";
    }

    private boolean isValidScore(String fullTimeResult) {
        int homeScore = Integer.parseInt(fullTimeResult.split("-")[0].trim());
        int awayScore = Integer.parseInt(fullTimeResult.split("-")[1].trim());
        if(homeScore < 0 || awayScore < 0) {
            return false;
        }
        return true;
    }

    private boolean hasResult(SportEvent event) {
        List<Result> results = resultDao.getAllByEvent(event);
        return results.stream().anyMatch(result -> isFTResultOrGoalResult(result));
    }

    private boolean isFTResultOrGoalResult(Result result) {
        return result.getBet().getBetType() == BetType.FOOTBALL_WINNER || result.getBet().getBetType() == BetType.FOOTBALL_WINNER;
    }

    private String getBetDescriptionError(String betDescription) {
        Optional<Bet> bet = betService.getByDescription(betDescription);
        if(!bet.isPresent()) {
            return "There is no bet with the given description!";
        }
        return "";
    }

    private String getOutcomeValueError(String betDescription, String outcomeValue) {
        Optional<Bet> bet = betService.getByDescription(betDescription);
        if(bet.isPresent() && outcomeService.getAllByBet(bet.get()).stream().noneMatch(b->b.getValue().equals(outcomeValue))) {
            return "The given outcome is invalid for the selected bet!";
        }
        return "";
    }

    private String getExistingBetResultError(String betDescription) {
        Optional<Bet> bet = betService.getByDescription(betDescription);
        if(bet.isPresent() && bet.get().isEnded()) {
            return "The bet already has a result!";
        }
        return "";
    }
}

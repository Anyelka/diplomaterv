package sports.betting.application.web.wager.model.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sports.betting.application.domain.bet.BetType;
import sports.betting.application.domain.sportevent.EventType;
import sports.betting.application.domain.wager.Wager;
import sports.betting.application.web.wager.model.WagerView;

@Component
public class WagerViewConverter implements Converter<Wager, WagerView> {

    @Override
    public WagerView convert(Wager wager) {
        WagerView wagerView = new WagerView();
        wagerView.setId(wager.getId());
        wagerView.setEventTitle(wager.getBet().getEvent().getTitle());
        wagerView.setEventType(formatEventType(wager.getBet().getEvent().getEventType()));
        wagerView.setBetType(formatBetType(wager.getBet().getBetType()));
        wagerView.setOutcome(formatOutcome(wager.getOutcome().getValue()));
        wagerView.setOdd(String.valueOf(wager.getOutcomeOdd()));
        wagerView.setStake(wager.getStake());
        wagerView.setWinner(getIsWinner(wager));
        wagerView.setIsProcessed(wager.isProcessed() ? "Yes" : "-");
        return wagerView;
    }

    private String formatEventType(EventType eventTypeAsEnum) {
        String eventType = eventTypeAsEnum.toString();
        return eventType.substring(0,1).toUpperCase().concat(eventType.substring(1).toLowerCase());
    }

    private String formatBetType(BetType betTypeAsEnum) {
        String betType = betTypeAsEnum.toString();
        return betType.substring(0,1).toUpperCase().concat(betType.substring(1).toLowerCase()).replace("_", "\\s+");
    }

    private String formatOutcome(String outcomeAsString) {
        return outcomeAsString.substring(0,1).toUpperCase().concat(outcomeAsString.substring(1).toLowerCase());
    }

    private String getIsWinner(Wager wager) {
        if(!wager.isProcessed()) {
            return "";
        } else {
            if(wager.isWinner()) {
                return "Winner";
            } else {
                return "Loser";
            }
        }
    }

}

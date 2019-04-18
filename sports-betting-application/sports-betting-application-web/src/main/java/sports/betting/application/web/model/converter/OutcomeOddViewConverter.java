package sports.betting.application.web.model.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sports.betting.application.domain.outcome.Outcome;
import sports.betting.application.web.model.OutcomeOddView;

@Component
public class OutcomeOddViewConverter implements Converter<Outcome, OutcomeOddView>{

    @Override
    public OutcomeOddView convert(Outcome outcome) {
        OutcomeOddView oddModel = new OutcomeOddView();
        oddModel.setOutcomeFullDescription(outcome.getBet().getDescription()
                                    + " -- " + outcome.getValue());
        oddModel.setValue(outcome.getCurrentOdd());
        return oddModel;
    }

}

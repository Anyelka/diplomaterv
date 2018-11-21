package sports.betting.application.web.model;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sports.betting.application.domain.outcome.Outcome;

@Component
public class OutcomeOddViewConverter implements Converter<Outcome, OutcomeOddModel>{

    @Override
    public OutcomeOddModel convert(Outcome outcome) {
        OutcomeOddModel oddModel = new OutcomeOddModel();
        oddModel.setOutcomeFullDescription(outcome.getBet().getDescription()
                                    + " -- " + outcome.getValue());
        oddModel.setValue(outcome.getCurrentOdd());
        return oddModel;
    }

}

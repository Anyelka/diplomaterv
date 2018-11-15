package sports.betting.application.web.model;

import sports.betting.application.service.formatter.DateFormatter;
import sports.betting.application.domain.outcome.OutcomeOdd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OutcomeOddViewConverter implements Converter<OutcomeOdd, OutcomeOddModel>{

    @Autowired
    private DateFormatter formatter;
    @Override
    public OutcomeOddModel convert(OutcomeOdd odd) {
        OutcomeOddModel oddModel = new OutcomeOddModel();
        oddModel.setOutcomeFullDescription(odd.getOutcome().getBet().getDescription()
                                    + " -- " + odd.getOutcome().getValue());
        oddModel.setValue(odd.getValue());
        oddModel.setValidFrom(formatter.formatDate(odd.getValidFrom()));
        oddModel.setValidTo(formatter.formatDate(odd.getValidTo()));
        return oddModel;
    }

}

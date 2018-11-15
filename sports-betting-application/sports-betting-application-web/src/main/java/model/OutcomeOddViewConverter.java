package model;

import formatter.DateFormatter;
import outcome.OutcomeOdd;
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

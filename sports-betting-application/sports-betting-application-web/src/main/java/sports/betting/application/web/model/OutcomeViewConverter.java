package sports.betting.application.web.model;

import sports.betting.application.service.OutcomeService;
import sports.betting.application.domain.outcome.Outcome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OutcomeViewConverter implements Converter<Outcome, OutcomeModel>{

    @Autowired
    private OutcomeService outcomeService;
    
    @Override
    public OutcomeModel convert(Outcome outcome) {
        OutcomeModel outcomeModel = new OutcomeModel();
        outcomeModel.setId(outcome.getId());
        String outcomeValue = outcome.getValue();
        String outcomeDescription = outcome.getBet().getDescription() + " -- " + outcomeValue.substring(0, 1)+ outcomeValue.toLowerCase().substring(1);
        outcomeModel.setFullDescription(outcomeDescription);
        outcomeModel.setValue(outcomeValue);
        outcomeModel.setOdd(outcome.getCurrentOdd() + "");
        return outcomeModel;
    }
    
}

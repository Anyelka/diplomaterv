package sports.betting.application.web.model.converter;

import sports.betting.application.service.outcome.OutcomeService;
import sports.betting.application.domain.outcome.Outcome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sports.betting.application.web.model.OutcomeView;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OutcomeViewConverter implements Converter<Outcome, OutcomeView>{

    @Autowired
    private OutcomeService outcomeService;
    
    @Override
    public OutcomeView convert(Outcome outcome) {
        OutcomeView outcomeView = new OutcomeView();
        outcomeView.setId(outcome.getId());
        String outcomeValue = outcome.getValue();
        String outcomeDescription = outcome.getBet().getDescription() + " -- " + outcomeValue.substring(0, 1)+ outcomeValue.toLowerCase().substring(1);
        outcomeView.setFullDescription(outcomeDescription);
        outcomeView.setValue(outcomeValue);
        outcomeView.setOdd(outcome.getCurrentOdd() + "");
        return outcomeView;
    }

    public List<OutcomeView> convert(List<Outcome> outcomes) {
        return outcomes.stream().map(this::convert).collect(Collectors.toList());
    }
    
}

package org.sports.betting.application.dal.outcome.dao.converter;

import org.sports.betting.application.dal.bet.dao.converter.BetBackConverter;
import org.sports.betting.application.dal.outcome.entity.OutcomeEntity;
import org.sports.betting.application.dal.outcome.entity.OutcomeOddEntity;
import org.sports.betting.application.dal.outcome.repository.OutcomeOddRepository;
import outcome.Outcome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OutcomeBackConverter {

    @Autowired
    private BetBackConverter betBackConverter;
    
    @Autowired
    private OutcomeOddRepository outcomeOddRepository;

    public OutcomeEntity convert(Outcome outcome) {
        OutcomeEntity outcomeEntity = new OutcomeEntity();
        outcomeEntity.setId(outcome.getId());
        outcomeEntity.setValue(outcome.getValue());
        outcomeEntity.setBet(betBackConverter.convert(outcome.getBet()));
        System.out.println("---------------------------> "+ outcome.getBet().getDescription()+ " "+outcome.getValue() + " OUTCOME'S CURRENT ODD: " + outcome.getCurrentOdd().getValue() + " IS WITH ID: " + outcome.getCurrentOdd().getId());

        OutcomeOddEntity currentOdd = outcomeOddRepository.findById(outcome.getCurrentOdd().getId());
        outcomeEntity.setCurrentOdd(currentOdd);
        return outcomeEntity;
    }

}

package org.sports.betting.application.dal.outcome.dao.converter;

import org.sports.betting.application.dal.outcome.entity.OutcomeEntity;
import org.sports.betting.application.dal.outcome.entity.OutcomeOddEntity;
import org.sports.betting.application.dal.outcome.repository.OutcomeRepository;
import outcome.OutcomeOdd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OutcomeOddBackTransformer {

    @Autowired
    private OutcomeRepository outcomeRepository;

    public OutcomeOddEntity convert(OutcomeOdd outcomeOdd) {
        OutcomeOddEntity outcomeOddEntity = new OutcomeOddEntity();
        outcomeOddEntity.setId(outcomeOdd.getId());
        OutcomeEntity outcome = outcomeRepository.findById(outcomeOdd.getOutcome().getId());
        outcomeOddEntity.setOutcome(outcome);
        outcomeOddEntity.setValue(outcomeOdd.getValue());
        outcomeOddEntity.setValidFrom(outcomeOdd.getValidFrom());
        outcomeOddEntity.setValidTo(outcomeOdd.getValidTo());
        return outcomeOddEntity;
    }

}
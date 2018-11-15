package service;

import java.time.LocalDateTime;
import java.util.List;

import org.sports.betting.application.dal.bet.dao.BetDao;
import org.sports.betting.application.dal.outcome.dao.OutcomeDao;
import org.sports.betting.application.dal.result.dao.ResultDao;
import wager.dao.WagerDao;
import bet.Bet;
import outcome.Outcome;
import result.Result;
import user.User;
import wager.Wager;
import org.springframework.beans.factory.annotation.Autowired;

public class WagerService {

    @Autowired
    private WagerDao wagerDao;

    @Autowired
    private BetDao betDao;

    @Autowired
    private OutcomeDao outcomeDao;

    @Autowired
    private ResultDao resultDao;

    @Autowired
    private PlayerService playerService;

    @Autowired
    private OutcomeService outcomeService;

    public void createWager(User player, String betDesription, String outcomeType, boolean winner, int stake, LocalDateTime timestamp) {
        Bet bet = betDao.getByDescription(betDesription);
        Outcome outcome = outcomeDao.getByBetAndValue(bet, outcomeType);
        Wager wager = new Wager(player, bet, outcome, outcome.getCurrentOdd().getValue(), stake, player.getPlayerData().getCurrency(), LocalDateTime.now(), true, winner);
        wagerDao.save(wager);
    }

    public void createWager(User player, String betDesription, String outcomeType, int stake, LocalDateTime timestamp) {
        Bet bet = betDao.getByDescription(betDesription);
        Outcome outcome = outcomeDao.getByBetAndValue(bet, outcomeType);
        Wager wager = new Wager(player, bet, outcome, outcome.getCurrentOdd().getValue(), stake, player.getPlayerData().getCurrency(), timestamp);
        wagerDao.save(wager);
    }

    public void createWager(String playerUsername, int outcomeId, int stake) {
        User player = playerService.getPlayerByUsername(playerUsername);
        Outcome outcome = outcomeService.getOutcome(outcomeId);
        Bet bet = outcome.getBet();
        Wager wager = new Wager(player, bet, outcome, outcome.getCurrentOdd().getValue(), stake, player.getPlayerData().getCurrency(), LocalDateTime.now());
        playerService.decreaseBalance(stake, player);
        wagerDao.save(wager);
    }

    public boolean isWinner(Wager wager) {
        Result betResult = resultDao.getByBet(wager.getBet());
        Outcome outcome = betResult.getOutcome();
        if (outcome.equals(wager.getOutcome())) {
            return true;
        }
        return false;

    }

    public int getWagersPrize(Wager wager) {
        return (int) ((wager.getStake()) * (wager.getOutcomeOdd()));
    }

    public void evaluateWager(Wager wager) {
        if (isWinner(wager)) {
            double amount = ((double) wager.getStake()) * (wager.getOutcomeOdd());
            playerService.increaseBalance((int) amount, wager.getPlayer());
        }
    }

    public List<Wager> getWagersOfPlayer(User player) {
        return wagerDao.getAllByPlayer(player);
    }

    public List<Wager> getWagersOfPlayer(String playerName) {
        User player = playerService.getPlayerByUsername(playerName);
        return getWagersOfPlayer(player);
    }

    public Wager getWager(int id) {
        return wagerDao.getById(id);
    }

    public List<Wager> findAllWagers() {
        return wagerDao.getAll();
    }

    public void deleteWager(Wager wager) {
        wagerDao.delete(wager);
    }

    public void deleteWager(int id) {
        wagerDao.delete(getWager(id));
    }

    public void updateWagers(Result result) {
        for (Wager wager : findAllWagers()) {
            updateWager(wager, result);
        }
    }

    private void updateWager(Wager wager, Result result) {
        Outcome resultoutcome = result.getOutcome();
        if (resultoutcome.getBet().getId() == wager.getBet().getId()) {
            closeWager(wager);
        }
    }

    public void saveWager(Wager wager) {
        wagerDao.save(wager);
    }

    private void closeWager(Wager wager) {
        wager.setProcessed(true);
        wager.setWinner(isWinner(wager));
        evaluateWager(wager);
        saveWager(wager);
    }

}

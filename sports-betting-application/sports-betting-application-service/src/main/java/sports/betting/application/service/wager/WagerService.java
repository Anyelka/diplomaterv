package sports.betting.application.service.wager;

import java.time.LocalDateTime;
import java.util.Currency;
import java.util.List;

import sports.betting.application.dal.bet.dao.BetDao;
import sports.betting.application.dal.outcome.dao.OutcomeDao;
import sports.betting.application.dal.result.dao.ResultDao;
import sports.betting.application.dal.wager.dao.WagerDao;
import sports.betting.application.domain.bet.Bet;
import sports.betting.application.domain.outcome.Outcome;
import sports.betting.application.domain.result.Result;
import sports.betting.application.domain.user.User;
import sports.betting.application.domain.wager.Wager;
import org.springframework.beans.factory.annotation.Autowired;
import sports.betting.application.service.outcome.OutcomeService;
import sports.betting.application.service.user.player.PlayerService;

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

    @Autowired
    private WagerValidator wagerValidator;

    public CreateWagerResponse attemptWagerCreation(SaveWagerRequest saveWagerRequest) {
        CreateWagerResponse createWagerResponse = wagerValidator.checkCreateWagerRequest(saveWagerRequest);
        if(createWagerResponse.isValid()) {
            createWager(saveWagerRequest.getPlayerUsername(), saveWagerRequest.getOutcomeId(), Integer.parseInt(saveWagerRequest.getStake()));
        }
        return createWagerResponse;
    }

    public void createWager(User player, String betDesription, String outcomeType, int stake, LocalDateTime timestamp) {
        Bet bet = betDao.getByDescription(betDesription).get();
        Outcome outcome = outcomeDao.getByBetAndValue(bet, outcomeType);
        Wager wager = new Wager(player, bet, outcome, outcome.getCurrentOdd(), stake, Currency.getInstance(player.getPlayerData().get().getCurrency()), timestamp);
        wagerDao.save(wager);
    }

    public void createWager(String playerUsername, int outcomeId, int stake) {
        User player = playerService.getPlayerByUsername(playerUsername);
        Outcome outcome = outcomeService.getOutcome(outcomeId);
        Bet bet = outcome.getBet();
        Wager wager = new Wager(player, bet, outcome, outcome.getCurrentOdd(), stake, Currency.getInstance(player.getPlayerData().get().getCurrency()), LocalDateTime.now());
        playerService.decreaseBalance(stake, player);
        wagerDao.save(wager);
    }

    public boolean isWinner(Wager wager) {
        Outcome resultOutcomeOfBet = resultDao.getByBet(wager.getBet()).getOutcome();
        return resultOutcomeOfBet.getValue().equals(wager.getOutcome().getValue());
    }

    public double getWagersPrize(Wager wager) {
        return (double) ((wager.getStake()) * (wager.getOutcomeOdd()));
    }

    public void evaluateWagerPrize(Wager wager) {
        if (isWinner(wager)) {
            playerService.increaseBalance((int) getWagersPrize(wager), wager.getPlayer());
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

    public void deleteWager(int id) {
        final Wager wager = getWager(id);
        wagerDao.delete(wager);
        playerService.increaseBalance(wager.getStake(), wager.getPlayer());
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
            evaluateWagerPrize(wager);
        }
    }

    public void saveWager(Wager wager) {
        wagerDao.save(wager);
    }

    private void closeWager(Wager wager) {
        wager.setProcessed(true);
        wager.setWinner(isWinner(wager));
        saveWager(wager);
    }

}

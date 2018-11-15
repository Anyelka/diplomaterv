//package sba.config.service;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Currency;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.sports.betting.application.domain.BettingDomainDatabase;
//import sports.betting.application.domain.bet.Bet;
//import sports.betting.application.domain.outcome.Outcome;
//import sports.betting.application.domain.outcome.OutcomeOdd;
//import sports.betting.application.domain.sportevent.Result;
//import sports.betting.application.domain.sportevent.SportEvent;
//import user.Player;
//import wager.Wager;
//
//public class WagerServiceTest {
//    private static final String PLAYER_NAME = "Takács Márton";
//    private static final String ACCOUNT_NUMBER = "1234-5678";
//    private static final int PLAYER_BALANCE = 5000;
//    private static final Currency PLAYER_CURRENCY = Currency.getInstance("HUF");
//    private static final LocalDate PLAYER_DOB = LocalDate.parse("1995-02-16");
//
//    private WagerService underTest;
//
//    BettingDomainDatabase bdDatabase;
//    Player wagersPlayer;
//    Bet wagersBet;
//    double odd = 2.0;
//    OutcomeOdd wagersOutcomeOdd;
//    Outcome wagersOutcome;
//    int wagersStake;
//    LocalDateTime wagersTimestamp;
//    Wager wager;
//
//    @Before
//    public void setUp() {
//        underTest = new WagerService();
//
//        bdDatabase = new BettingDomainDatabase();
//        wagersPlayer = new Player(PLAYER_NAME, ACCOUNT_NUMBER, PLAYER_BALANCE, PLAYER_CURRENCY, PLAYER_DOB);
//        wagersBet = new Bet();
//        wagersOutcome = bdDatabase.createOutcome(wagersBet, "HOME");
//        wagersOutcomeOdd = bdDatabase.createOutcomeOdd(wagersOutcome, odd, wagersTimestamp, wagersTimestamp);
//        wagersStake = 1000;
//        wagersTimestamp = LocalDateTime.now();
//        wager = bdDatabase.createWager(wagersPlayer, wagersBet, wagersOutcome, wagersStake, PLAYER_CURRENCY, wagersTimestamp);
//    }
//
//    @Test
//    public void testCreateWager() {
//        // GIVEN
//        // WHEN
//        Wager createdWager = underTest.createWager(wagersPlayer, wagersBet, wagersOutcome, wagersStake);
//        // THEN
//        Assert.assertEquals(wagersPlayer, createdWager.getPlayer());
//        Assert.assertEquals(wagersBet, createdWager.getBet());
//        Assert.assertEquals(wagersOutcome, createdWager.getOutcome());
//        Assert.assertEquals(wagersOutcomeOdd, createdWager.getOutcome().getOdd());
//        Assert.assertEquals(wagersStake, createdWager.getStake());
//        Assert.assertEquals(PLAYER_CURRENCY, createdWager.getCurrency());
//        Assert.assertEquals(wagersPlayer, createdWager.getPlayer());
//    }
//
//    @Test
//    public void testIsWinnerShouldReturnTrueWhenResultContainsTheWagersOutcome() {
//        // GIVEN
//        SportEvent sportEvent = new SportEvent();
//        wagersBet.setEvent(sportEvent);
//        ArrayList<Outcome> outcomes = new ArrayList<Outcome>();
//        outcomes.add(wagersOutcome);
//        Result sports.betting.application.domain.result = new Result(sportEvent, outcomes);
//        sportEvent.setResult(sports.betting.application.domain.result);
//        // WHEN
//        boolean wagersResult = underTest.isWinner(wager);
//        // THEN
//        Assert.assertEquals(true, wagersResult);
//    }
//
//    @Test
//    public void testIsWinnerShouldReturnFalseWhenResultDoesntContainTheWagersOutcome() {
//        // GIVEN
//        SportEvent sportEvent = new SportEvent();
//        wagersBet.setEvent(sportEvent);
//        ArrayList<Outcome> outcomes = new ArrayList<Outcome>();
//        Result sports.betting.application.domain.result = new Result(sportEvent, outcomes);
//        sportEvent.setResult(sports.betting.application.domain.result);
//        // WHEN
//        boolean wagersResult = underTest.isWinner(wager);
//        // THEN
//        Assert.assertEquals(false, wagersResult);
//    }
//    
//    @Test
//    public void getWagersPrize() {
//        //GIVEN
//        
//        //WHEN
//        int wagersPrizeResult = underTest.getWagersPrize(wager);
//        //THEN
//        Assert.assertEquals((int)(wagersStake*odd), wagersPrizeResult);
//    }
//}

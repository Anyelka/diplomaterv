//package sba.config.service;
//
//import java.time.LocalDate;
//import java.util.Currency;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import user.Player;
//
//public class PlayerServiceTest {
//    static final int LOW_BALANCE = 0;
//    static final int HIGH_BALANCE = 1000;
//    static final int BALANCE_INCREASE_AMOUNT = HIGH_BALANCE;
//    static final int BALANCE_DECREASE_AMOUNT = HIGH_BALANCE;
//    static final int INCREASED_BALANCE = HIGH_BALANCE;
//    static final int DECREASED_BALANCE = LOW_BALANCE;
//    static final int INCREASABLE_BALANCE = LOW_BALANCE;
//    static final int DECREASABLE_BALANCE = HIGH_BALANCE;    
//    static final String PLAYER_NAME = "Takács Márton";
//    static final String ACCOUNT_NUMBER = "1234-5678";
//    static final int PLAYER_BALANCE = 5000;
//    static final Currency PLAYER_CURRENCY = Currency.getInstance("HUF");
//    static final LocalDate PLAYER_DOB = LocalDate.parse("1995-02-16");
//
//    PlayerService underTest;
//
//    @Before
//    public void setUp() {
//        underTest = new PlayerService();
//    }
//
//    @Test
//    public void testCreatePlayer() {
//        // GIVEN
//        String[] playerData = { "Takács Márton", "1234-5678", "5000", "HUF", "1995-02-16" };        
//        // WHEN
//        Player createdPlayer = underTest.createPlayer(playerData);
//        // THEN
//        Assert.assertEquals(PLAYER_NAME, createdPlayer.getName());
//        Assert.assertEquals(ACCOUNT_NUMBER, createdPlayer.getAccountNumber());
//        Assert.assertEquals(PLAYER_BALANCE, createdPlayer.getBalance());
//        Assert.assertEquals(PLAYER_CURRENCY, createdPlayer.getCurrency());
//        Assert.assertEquals(PLAYER_DOB, createdPlayer.getDob());
//    }
//
//    @Test
//    public void testIncreaseBalance() {
//        // GIVEN
//        Player player = new Player(PLAYER_NAME, ACCOUNT_NUMBER, INCREASABLE_BALANCE, PLAYER_CURRENCY, PLAYER_DOB);
//        // WHEN
//        underTest.increaseBalance(BALANCE_INCREASE_AMOUNT, player);
//        // THEN
//        Assert.assertEquals(INCREASED_BALANCE, player.getBalance());
//    }
//
//    @Test
//    public void testDecreaseBalance() {
//        // GIVEN
//        Player player = new Player(PLAYER_NAME, ACCOUNT_NUMBER, DECREASABLE_BALANCE, PLAYER_CURRENCY, PLAYER_DOB);
//        // WHEN
//        underTest.decreaseBalance(BALANCE_DECREASE_AMOUNT, player);
//        // THEN
//        Assert.assertEquals(DECREASED_BALANCE, player.getBalance());
//    }
//}

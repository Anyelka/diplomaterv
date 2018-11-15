//package sba.config.service;
//
//import java.time.LocalDate;
//import java.util.Currency;
//
//import org.easymock.EasyMock;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import user.Player;
//
//
//public class TestDataGeneratorTest {
//    TestDataGenerator underTest;
//
//    @Before
//    public void setUp() {
//        underTest = new TestDataGenerator();
//    }
//
//    @Test
//    public void testCreatePlayer() {
//        //GIVEN
//        String playerName = "Takács Márton";
//        String accountNumber = "1234-5678";
//        String playerBalance= "5000";
//        int parsedBalance = Integer.parseInt(playerBalance);
//        String playerCurrency = "HUF";
//        Currency parsedCurrency = Currency.getInstance(playerCurrency);
//        String playerDob = "1995-02-16";
//        LocalDate parsedDob = LocalDate.parse(playerDob);
//        String[] string = { playerName, accountNumber, playerBalance, playerCurrency, playerDob };
//        
//        PlayerService playerService = EasyMock.createMock(PlayerService.class);  
//        EasyMock.expect(playerService.createPlayer(string))
//                .andReturn(new Player(playerName, accountNumber, parsedBalance, parsedCurrency, parsedDob));
//        EasyMock.replay(playerService);
//        //WHEN
//        underTest.setPlayerService(playerService);
//        Player playerResult = underTest.createPlayer();
//        //THEN
//        EasyMock.verify(playerService);
//        Assert.assertEquals(playerName, playerResult.getName());
//        Assert.assertEquals(accountNumber, playerResult.getAccountNumber());
//        Assert.assertEquals(parsedBalance, playerResult.getBalance());
//        Assert.assertEquals(parsedCurrency, playerResult.getCurrency());
//        Assert.assertEquals(parsedDob, playerResult.getDob());
//    }
//    
//}

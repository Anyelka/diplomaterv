//package sba.config.service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.function.DoubleSupplier;
//
//import org.easymock.EasyMock;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.sports.betting.application.domain.BettingDomainDatabase;
//import sports.betting.application.domain.bet.Bet;
//import sports.betting.application.domain.bet.BetType;
//import sports.betting.application.domain.outcome.Outcome;
//import sports.betting.application.domain.sportevent.EventType;
//import sports.betting.application.domain.sportevent.Result;
//import sports.betting.application.domain.sportevent.SportEvent;
//
//public class ResultDataGeneratorTest {
//    ResultDataGenerator underTest;
//    DoubleSupplier numberGenerator;
//    private static Bet bet11;
//    private static Outcome outcome111;
//    private static Outcome outcome112;
//    private static Outcome outcome113;
//    private static Bet bet12;
//    private static Outcome outcome121;
//    private static Outcome outcome122;
//    private static SportEvent event1;
//    private static Bet bet13;
//    private static Outcome outcome131;
//    private static Outcome outcome132;
//    private static SportEvent event2;
//    private static Bet bet21;
//    private static Outcome outcome212;
//    private static Outcome outcome213;
//    private static Bet bet22;
//    private static Outcome outcome221;
//    private static Outcome outcome222;
//    private static Bet bet23;
//    private static Outcome outcome231;
//    private static Outcome outcome232;
//    private static BettingDomainDatabase bdDatabase;
//    
//    @After
//    public void tearDown() {
//        bdDatabase.getEvents().clear();
////        bdDatabase.getBets().clear();
//        bdDatabase.getOutcomes().clear();
//    }
//
//    @Before
//    public void setUp() {
//        bdDatabase = new BettingDomainDatabase();
//        setUpTestDB();        
//        
//        numberGenerator = EasyMock.createMock(DoubleSupplier.class);
//        underTest = new ResultDataGenerator(numberGenerator);
//    }
//
//    public void setUpTestDB() {
////        LocalDateTime from = LocalDateTime.of(2010, 02, 01, 10, 0);
////        LocalDateTime to = LocalDateTime.of(2010, 02, 01, 12, 0);
////        event1 = bdDatabase.createEvent("Chelsea - Fulham", EventType.FOOTBALL, from, to);
////        bet11 = bdDatabase.createBet(event1, "Full Time Result", BetType.FOOTBALL_WINNER);
////        outcome111 = bdDatabase.createOutcome(bet11, "HOME");
////        outcome112 = bdDatabase.createOutcome(bet11, "DRAW");
////        outcome113 = bdDatabase.createOutcome(bet11, "AWAY");
////        bet12 = bdDatabase.createBet(event1, "Corners Over/Under (9.5)", BetType.FOOTBALL_CORNERS);
////        outcome121 = bdDatabase.createOutcome(bet12, "OVER");
////        outcome122 = bdDatabase.createOutcome(bet12, "UNDER");
////        bet13 = bdDatabase.createBet(event1, "Goals Over/Under (2.5)", BetType.FOOTBALL_GOALS);
////        outcome131 = bdDatabase.createOutcome(bet13, "OVER");
////        outcome132 = bdDatabase.createOutcome(bet13, "UNDER");
////
////        event2 = bdDatabase.createEvent("Nadal - Federer", EventType.TENNIS, from, to);
////        bet21 = bdDatabase.createBet(event2, "Full Time Result", BetType.TENNIS_WINNER);
////        bdDatabase.createOutcome(bet21, "HOME");
////        outcome212 = bdDatabase.createOutcome(bet21, "DRAW");
////        outcome213 = bdDatabase.createOutcome(bet21, "AWAY");
////        bet22 = bdDatabase.createBet(event2, "Handicap Result(+2.5)", BetType.TENNIS_HANDICAP);
////        outcome221 = bdDatabase.createOutcome(bet22, "HOME");
////        outcome222 = bdDatabase.createOutcome(bet22, "DRAW");
////        bdDatabase.createOutcome(bet22, "AWAY");
////        
////        bet23 = bdDatabase.createBet(event2, "Number Of Overall Plays(28)", BetType.TENNIS_OVERALLPLAYS);
////        outcome231 = bdDatabase.createOutcome(bet23, "OVER");
////        outcome232 = bdDatabase.createOutcome(bet23, "UNDER");
//    }
//
//    @Test
//    public void testRandomOutcomeShouldReturnFirstOutcomeWhenGeneratedDoubleIsMinimal() {
//        // GIVEN
//        EasyMock.expect(numberGenerator.getAsDouble()).andReturn(0.1);
//        EasyMock.replay(numberGenerator);
//        // WHEN
//        Outcome randomOutcomeResult = underTest.generateRandomOutcome(bet11);
//        // THEN
//        EasyMock.verify(numberGenerator);
//        Assert.assertEquals(outcome111, randomOutcomeResult);
//    }
//
//    @Test
//    public void testRandomOutcomeShouldReturnSecondOutcomeWhenGeneratedDoubleIsAverage() {
//        // GIVEN
//        EasyMock.expect(numberGenerator.getAsDouble()).andReturn(0.5);
//        EasyMock.replay(numberGenerator);
//        // WHEN
//        Outcome randomOutcomeResult = underTest.generateRandomOutcome(bet11);
//        // THEN
//        EasyMock.verify(numberGenerator);
//        Assert.assertEquals(outcome112, randomOutcomeResult);
//    }
//
//    @Test
//    public void testRandomOutcomeShouldReturnThirdOutcomeWhenGeneratedDoubleIsMaximal() {
//        // GIVEN
//        EasyMock.expect(numberGenerator.getAsDouble()).andReturn(0.9);
//        EasyMock.replay(numberGenerator);
//        // WHEN
//        Outcome randomOutcomeResult = underTest.generateRandomOutcome(bet11);
//        // THEN
//        EasyMock.verify(numberGenerator);
//        Assert.assertEquals(outcome113, randomOutcomeResult);
//    }
//
//    @Test
//    public void testRandomOutcomesForAllBetsOfEvent() {
//        // GIVEN
//        EasyMock.expect(numberGenerator.getAsDouble()).andReturn(0.5).andReturn(0.2).andReturn(0.7);
//        EasyMock.replay(numberGenerator);
//        // WHEN
//        List<Outcome> randomOutcomesResult = underTest.generateRandomOutcomesForAllBetsOfEvent(event1);
//        // THEN
//        EasyMock.verify(numberGenerator);
//        Assert.assertEquals(outcome112, randomOutcomesResult.get(0));  
//        Assert.assertEquals(outcome121, randomOutcomesResult.get(1));  
//        Assert.assertEquals(outcome132, randomOutcomesResult.get(2));  
//    }
//
//    @Test
//    public void testRandomResult() {
//        // GIVEN
//        EasyMock.expect(numberGenerator.getAsDouble()).andReturn(0.5).andReturn(0.2).andReturn(0.7);
//        EasyMock.replay(numberGenerator);
//        // WHEN
//        Result resultResult = underTest.generateRandomResultForEvent(event2);
//        // THEN
//        EasyMock.verify(numberGenerator);
//        Assert.assertEquals(outcome212.getValue(), resultResult.getOutcomes().get(0).getValue());
//        Assert.assertEquals(outcome221, resultResult.getOutcomes().get(1));
//        Assert.assertEquals(outcome232, resultResult.getOutcomes().get(2));
//    }
//
//    @Test
//    public void testRandomResults() {
//        // GIVEN
//        EasyMock.expect(numberGenerator.getAsDouble()).andReturn(0.5).andReturn(0.7).andReturn(0.2)
//                                                      .andReturn(0.9).andReturn(0.39).andReturn(0.0);
//        EasyMock.replay(numberGenerator);
//        // WHEN
//        underTest.generateRandomResults();
//        // THEN
//        EasyMock.verify(numberGenerator);
//        System.out.println(bdDatabase.getEvent(1));
//        Assert.assertEquals(outcome112.getValue(), bdDatabase.getEvent(1).getResult().getOutcomes().get(0).getValue());
//        Assert.assertEquals(outcome122.getValue(), bdDatabase.getEvent(1).getResult().getOutcomes().get(1).getValue());
//        Assert.assertEquals(outcome131, bdDatabase.getEvent(1).getResult().getOutcomes().get(2));
//        Assert.assertEquals(outcome213.getValue(), bdDatabase.getEvent(2).getResult().getOutcomes().get(0).getValue());
//        Assert.assertEquals(outcome222.getValue(), bdDatabase.getEvent(2).getResult().getOutcomes().get(1).getValue());
//        Assert.assertEquals(outcome231, bdDatabase.getEvent(2).getResult().getOutcomes().get(2));        
//
//    }
//}

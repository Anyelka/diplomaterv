package service;

import java.time.LocalDateTime;

import bet.Bet;
import bet.BetType;
import outcome.Outcome;
import sportevent.EventType;
import user.User;
import org.springframework.beans.factory.annotation.Autowired;

public class TestDataGenerator {
    static final String USER_ROLE_PLAYER = "ROLE_PLAYER";
    static final String USER_ROLE_ADMIN = "ROLE_ADMIN";
    static final String USER_ROLE_EDITOR = "ROLE_EDITOR";

    private static final String PLAYER_NAME = "Eden Hazard";
    private static final String PLAYER_ACCOUNT_NUMBER = "0001-007A3";
    private static final String PLAYER_BALANCE = "175000";
    private static final String PLAYER_CURRENCY = "GBP";
    private static final String PLAYER_DATE_OF_BIRTH = "1991-01-08";
    private static final String PLAYER_USERNAME = "eden";
    private static final String PLAYER_PASSWORD = "eden";
    private static final String PLAYER_EMAIL = "eden@hazard.com";
    private static final boolean PLAYER_ENABLED = true;
    
    private static final EventType EVENTTYPE_FOOTALL = EventType.FOOTBALL;
    private static final EventType EVENTTYPE_TENNIS = EventType.TENNIS;
    private static final String BETTYPE_FT_RES = "Full Time Result";
    private static final String BETTYPE_GOALS_2_5 = "Goals Over/Under (2.5)";
    private static final String BETTYPE_WINNER = "Winner";
    private static final String OUTCOMETYPE_HOME = "HOME";
    private static final String OUTCOMETYPE_AWAY = "AWAY";
    private static final String OUTCOMETYPE_DRAW = "DRAW";
    private static final String OUTCOMETYPE_OVER = "OVER";
    private static final String OUTCOMETYPE_UNDER = "UNDER";
    private static final String EVE_MU_EVENT = "Everton - Manchester United";
    private static final String EVE_MU_STARTDATE = "2018-01-01 18:30";
    private static final String EVE_MU_ENDDATE = "2018-01-01 20:20";
    private static final String ARS_CHE_EVENT = "Arsenal - Chelsea";
    private static final String ARS_CHE_STARTDATE = "2018-01-03 20:45";
    private static final String ARS_CHE_ENDDATE = "2018-01-03 22:35";
    private static final String SHA_EDM_EVENT = "Shapovalov - Edmund";
    private static final String SHA_EDM_STARTDATE = "2018-01-02 03:30";
    private static final String SHA_EDM_ENDDATE = "2018-01-02 07:20";
    private static final double EVE_MU_FT_RES_HOME_ODD = 5.75;
    private static final double EVE_MU_FT_RES_DRAW_ODD = 3.75;
    private static final double EVE_MU_FT_RES_AWAY_ODD = 1.70;
    private static final double ARS_CHE_FT_RES_HOME_ODD = 2.80;
    private static final double ARS_CHE_FT_RES_DRAW_ODD = 3.50;
    private static final double ARS_CHE_FT_RES_AWAY_ODD = 2.62;
    private static final double ARS_CHE_GOALS_2_5_OVER_ODD = 1.66;
    private static final double ARS_CHE_GOALS_2_5_UNDER_ODD = 2.15;
    private static final double SHA_EDM_WINNER_HOME_ODD = 2.00;
    private static final double SHA_EDM_WINNER_AWAY_ODD = 1.65;
    private static final String ODD_VALID_FROM = "2018-01-01 12:00";
    private static final String ODD_VALID_TO = "2018-01-03 12:00";
    private static final String ODD_VALID_FROM_INFUTURE = "2019-01-01 12:00";
    private static final String ODD_VALID_TO_INFUTURE = "2019-01-03 12:00";

    @Autowired
    private UserService userService;
    
    @Autowired
    private PlayerService playerService;
    
    @Autowired
    private WagerService wagerService;
    
    @Autowired
    private SportEventService sportEventService;
    
    @Autowired
    private BetService betService;
    
    @Autowired
    private OutcomeService outcomeService;

    public void init() {
        createRoles();
        createPlayer();
        createBettingDatabase();
        createTestWagers();
    }
    
    private void createRoles() {
        userService.createUserRole(USER_ROLE_ADMIN);
        userService.createUserRole(USER_ROLE_EDITOR);
        userService.createUserRole(USER_ROLE_PLAYER);
    }

    public User createPlayer() {
        return playerService.createPlayer(new String[] { PLAYER_NAME, PLAYER_ACCOUNT_NUMBER, PLAYER_BALANCE, PLAYER_CURRENCY, PLAYER_DATE_OF_BIRTH },
                new String[] {PLAYER_USERNAME, PLAYER_PASSWORD, PLAYER_EMAIL}, PLAYER_ENABLED);
    }

    public void createTestWagers() {
    	    User player = playerService.getPlayerById(1);
        wagerService.createWager(player, EVE_MU_EVENT + " -- " + BETTYPE_FT_RES, OUTCOMETYPE_HOME, 1000, LocalDateTime.of(1991, 01, 07, 20, 33));
        wagerService.createWager(player, ARS_CHE_EVENT + " -- " + BETTYPE_GOALS_2_5, OUTCOMETYPE_UNDER, 7500, LocalDateTime.of(2005, 11, 11, 11, 1));
        wagerService.createWager(player, SHA_EDM_EVENT + " -- " + BETTYPE_WINNER, OUTCOMETYPE_AWAY, 23109, LocalDateTime.of(2017, 03, 30, 23, 59));
    }
    
    public void createBettingDatabase() {
        sportEventService.createEvent(EVE_MU_EVENT, EVE_MU_STARTDATE, EVE_MU_ENDDATE, EVENTTYPE_FOOTALL);
        betService.createBet(EVE_MU_EVENT, BETTYPE_FT_RES, BetType.FOOTBALL_WINNER);
        Bet bet1 = betService.getByDescription(EVE_MU_EVENT + " -- " + BETTYPE_FT_RES);
        outcomeService.createOutcome(EVE_MU_EVENT + " -- " + BETTYPE_FT_RES, OUTCOMETYPE_HOME);
        Outcome outcome11 = outcomeService.getByBetAndValue(bet1, OUTCOMETYPE_HOME);
        outcomeService.createOutcomeOdd(outcome11, EVE_MU_FT_RES_HOME_ODD, ODD_VALID_FROM_INFUTURE, ODD_VALID_TO_INFUTURE);
        outcomeService.createOutcome(EVE_MU_EVENT + " -- " + BETTYPE_FT_RES, OUTCOMETYPE_DRAW);
        Outcome outcome12 = outcomeService.getByBetAndValue(bet1, OUTCOMETYPE_DRAW);
        outcomeService.createOutcomeOdd(outcome12, EVE_MU_FT_RES_DRAW_ODD, ODD_VALID_FROM_INFUTURE, ODD_VALID_TO_INFUTURE);
        outcomeService.createOutcome(EVE_MU_EVENT + " -- " + BETTYPE_FT_RES, OUTCOMETYPE_AWAY);
        Outcome outcome13 = outcomeService.getByBetAndValue(bet1, OUTCOMETYPE_AWAY);
        outcomeService.createOutcomeOdd(outcome13, EVE_MU_FT_RES_AWAY_ODD, ODD_VALID_FROM_INFUTURE, ODD_VALID_TO_INFUTURE);
        
        sportEventService.createEvent(ARS_CHE_EVENT, ARS_CHE_STARTDATE, ARS_CHE_ENDDATE, EVENTTYPE_FOOTALL);
        betService.createBet(ARS_CHE_EVENT, BETTYPE_FT_RES, BetType.FOOTBALL_WINNER);
        Bet bet2 = betService.getByDescription(ARS_CHE_EVENT + " -- " + BETTYPE_FT_RES);
        outcomeService.createOutcome(ARS_CHE_EVENT + " -- " + BETTYPE_FT_RES, OUTCOMETYPE_HOME);
        Outcome outcome21 = outcomeService.getByBetAndValue(bet2, OUTCOMETYPE_HOME);
        outcomeService.createOutcomeOdd(outcome21, ARS_CHE_FT_RES_HOME_ODD, ODD_VALID_FROM, ODD_VALID_TO);
        outcomeService.createOutcome(ARS_CHE_EVENT + " -- " + BETTYPE_FT_RES, OUTCOMETYPE_DRAW);
        Outcome outcome22 = outcomeService.getByBetAndValue(bet2, OUTCOMETYPE_DRAW);
        outcomeService.createOutcomeOdd(outcome22, ARS_CHE_FT_RES_DRAW_ODD, ODD_VALID_FROM, ODD_VALID_TO);
        outcomeService.createOutcome(ARS_CHE_EVENT + " -- " + BETTYPE_FT_RES, OUTCOMETYPE_AWAY);
        Outcome outcome23 = outcomeService.getByBetAndValue(bet2, OUTCOMETYPE_AWAY);
        outcomeService.createOutcomeOdd(outcome23, ARS_CHE_FT_RES_AWAY_ODD, ODD_VALID_FROM, ODD_VALID_TO);
        
        betService.createBet(ARS_CHE_EVENT, BETTYPE_GOALS_2_5, BetType.FOOTBALL_GOALS);
        Bet bet3 = betService.getByDescription(ARS_CHE_EVENT + " -- " + BETTYPE_GOALS_2_5);
        outcomeService.createOutcome(ARS_CHE_EVENT + " -- " + BETTYPE_GOALS_2_5, OUTCOMETYPE_OVER);
        Outcome outcome31 = outcomeService.getByBetAndValue(bet3, OUTCOMETYPE_OVER);
        outcomeService.createOutcomeOdd(outcome31, ARS_CHE_GOALS_2_5_OVER_ODD, ODD_VALID_FROM, ODD_VALID_TO);
        outcomeService.createOutcome(ARS_CHE_EVENT + " -- " + BETTYPE_GOALS_2_5, OUTCOMETYPE_UNDER);
        Outcome outcome32 = outcomeService.getByBetAndValue(bet3, OUTCOMETYPE_UNDER);
        outcomeService.createOutcomeOdd(outcome32, ARS_CHE_GOALS_2_5_UNDER_ODD, ODD_VALID_FROM, ODD_VALID_TO);
        
        sportEventService.createEvent(SHA_EDM_EVENT, SHA_EDM_STARTDATE, SHA_EDM_ENDDATE, EVENTTYPE_TENNIS);
        betService.createBet(SHA_EDM_EVENT, BETTYPE_WINNER, BetType.TENNIS_WINNER);
        Bet bet4 = betService.getByDescription(SHA_EDM_EVENT + " -- " + BETTYPE_WINNER);
        outcomeService.createOutcome(SHA_EDM_EVENT + " -- " + BETTYPE_WINNER, OUTCOMETYPE_HOME);
        Outcome outcome41 = outcomeService.getByBetAndValue(bet4, OUTCOMETYPE_HOME);
        outcomeService.createOutcomeOdd(outcome41, SHA_EDM_WINNER_HOME_ODD, ODD_VALID_FROM, ODD_VALID_TO);
        outcomeService.createOutcome(SHA_EDM_EVENT + " -- " + BETTYPE_WINNER, OUTCOMETYPE_AWAY);
        Outcome outcome42 = outcomeService.getByBetAndValue(bet4, OUTCOMETYPE_AWAY);
        outcomeService.createOutcomeOdd(outcome42, SHA_EDM_WINNER_AWAY_ODD, ODD_VALID_FROM, ODD_VALID_TO);
    }
}

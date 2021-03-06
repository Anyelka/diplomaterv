package sports.betting.application.config.service;

import java.time.format.DateTimeFormatter;

import sports.betting.application.config.dal.JpaConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import sports.betting.application.service.bet.BetService;
import sports.betting.application.service.event.SportEventService;
import sports.betting.application.service.outcome.OutcomeService;
import sports.betting.application.service.result.ResultService;
import sports.betting.application.service.user.UserService;
import sports.betting.application.service.player.PlayerService;
import sports.betting.application.service.wager.WagerService;

@Configuration
@Import({JpaConfig.class})
public class ServiceConfig {

    @Bean
    public PlayerService playerService() {
        return new PlayerService();
    }

    @Bean
    public UserService UserService() {
        return new UserService();
    }
    
    @Bean
    public WagerService wagerService() {
        return new WagerService();
    }
    
    @Bean
    public OutcomeService outcomeService() {
        return new OutcomeService();
    }
    
    @Bean
    public SportEventService sportEventService() {
        return new SportEventService();
    }
    
    @Bean
    public BetService betService() {
        return new BetService();
    }
    
    @Bean
    public ResultService resultService() {
        return new ResultService();
    }
    
    @Bean
    public DateTimeFormatter formatter() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    }
    
}

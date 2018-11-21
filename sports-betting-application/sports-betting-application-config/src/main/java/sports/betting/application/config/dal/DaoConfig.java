package sports.betting.application.config.dal;

import sports.betting.application.dal.bet.dao.BetDao;
import sports.betting.application.dal.bet.dao.DefaultBetDao;
import sports.betting.application.dal.outcome.dao.DefaultOutcomeDao;
import sports.betting.application.dal.outcome.dao.OutcomeDao;
import sports.betting.application.dal.result.dao.DefaultResultDao;
import sports.betting.application.dal.result.dao.ResultDao;
import sports.betting.application.dal.sportevent.dao.DefaultSportEventDao;
import sports.betting.application.dal.sportevent.dao.SportEventDao;
import sports.betting.application.dal.user.dao.DefaultUserDao;
import sports.betting.application.dal.user.dao.DefaultUserRoleDao;
import sports.betting.application.dal.user.dao.UserDao;
import sports.betting.application.dal.user.dao.UserRoleDao;
import sports.betting.application.dal.wager.dao.DefaultWagerDao;
import sports.betting.application.dal.wager.dao.WagerDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {

    @Bean
    public BetDao betDao() {
        return new DefaultBetDao();
    }

    @Bean
    public OutcomeDao outcomeDao() {
        return new DefaultOutcomeDao();
    }

    @Bean
    public SportEventDao sportEventDao() {
        return new DefaultSportEventDao();
    }

    @Bean
    public WagerDao wagerDao() {
        return new DefaultWagerDao();
    }

    @Bean
    public UserDao userDao() {
        return new DefaultUserDao();
    }
    
    @Bean
    public UserRoleDao userRoleDao() {
        return new DefaultUserRoleDao();
    }
    
    @Bean
    public ResultDao resultDao() {
        return new DefaultResultDao();
    }
}

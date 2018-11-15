package dal;

import org.sports.betting.application.dal.bet.dao.BetDao;
import org.sports.betting.application.dal.bet.dao.DefaultBetDao;
import org.sports.betting.application.dal.outcome.dao.DefaultOutcomeDao;
import org.sports.betting.application.dal.outcome.dao.DefaultOutcomeOddDao;
import org.sports.betting.application.dal.outcome.dao.OutcomeDao;
import org.sports.betting.application.dal.outcome.dao.OutcomeOddDao;
import org.sports.betting.application.dal.result.dao.DefaultResultDao;
import org.sports.betting.application.dal.result.dao.ResultDao;
import org.sports.betting.application.dal.sportevent.dao.DefaultSportEventDao;
import org.sports.betting.application.dal.sportevent.dao.SportEventDao;
import org.sports.betting.application.dal.user.dao.DefaultUserDao;
import org.sports.betting.application.dal.user.dao.DefaultUserRoleDao;
import org.sports.betting.application.dal.user.dao.UserDao;
import org.sports.betting.application.dal.user.dao.UserRoleDao;
import wager.dao.DefaultWagerDao;
import wager.dao.WagerDao;
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
    public OutcomeOddDao outcomeOddDao() {
        return new DefaultOutcomeOddDao();
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

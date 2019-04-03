package sports.betting.application.config.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import sports.betting.application.config.dal.JpaConfig;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@ComponentScan("sports.betting.application")
@Import({ JpaConfig.class })
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String USERS_QUERY = "SELECT username, password, enabled FROM user WHERE username=?";
    private static final String ROLES_QUERY = "SELECT u.username, r.role FROM user u inner join user_role ur on(u.user_id=ur.user_id) "
            + "inner join role r on(ur.role_id=r.role_id) WHERE u.username=?";

    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(USERS_QUERY).authoritiesByUsernameQuery(ROLES_QUERY);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/auth/**")
                .access("isAuthenticated()")
                .anyRequest()
                .permitAll()
                .antMatchers("/player/**").hasAuthority("ROLE_PLAYER")
                .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                .and()
                .formLogin()
                .loginPage("/index.html")
                .loginProcessingUrl("/login")
                .failureUrl("/index.html")
                .successHandler(successHandler())
                .usernameParameter("username")
                .passwordParameter("password")

                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/index")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")

                .and()
                .exceptionHandling()
                .accessDeniedPage("/403")

                .and()
                .csrf().disable();
    }

    private AuthenticationSuccessHandler successHandler() {
        return new CustomAuthenticationSuccessHandler();
    }
}

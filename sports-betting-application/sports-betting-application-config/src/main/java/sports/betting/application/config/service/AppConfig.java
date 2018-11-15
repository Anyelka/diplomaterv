package sports.betting.application.config.service;

import java.util.function.DoubleSupplier;

import sports.betting.application.config.dal.JpaConfig;
import sports.betting.application.config.resources.MessageSourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import sports.betting.application.service.ResultDataGenerator;
import sports.betting.application.service.TestDataGenerator;

@Configuration
@Import({ServiceConfig.class, MessageSourceConfig.class, JpaConfig.class})
@PropertySource(value = { "classpath:config.properties" }, encoding = "UTF-8")
//@EnableAspectJAutoProxy
@ComponentScan("sports.betting.application")
public class AppConfig {

    private DoubleSupplier doubleSupplier = () -> {
        return Math.random();
    };

    @Bean(initMethod="init")
    public TestDataGenerator testDataGenerator() {
        return new TestDataGenerator();
    }

    @Bean
    public ResultDataGenerator resultDataGenerator() {
        return new ResultDataGenerator(doubleSupplier);
    }
    
}

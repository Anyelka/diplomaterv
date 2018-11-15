package service;

import java.util.function.DoubleSupplier;

import service.ResultDataGenerator;
import service.TestDataGenerator;
import dal.JpaConfig;
import resources.MessageSourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import({ServiceConfig.class, MessageSourceConfig.class, JpaConfig.class})
@PropertySource(value = { "classpath:config.properties" }, encoding = "UTF-8")
//@EnableAspectJAutoProxy
@ComponentScan("org.sports.betting.application")
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

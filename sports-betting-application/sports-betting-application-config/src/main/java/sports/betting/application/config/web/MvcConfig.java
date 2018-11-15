package sports.betting.application.config.web;

import sports.betting.application.config.service.AppConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("org.sports.betting.application")
@Import({SecurityConfig.class, AppConfig.class})
public class MvcConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver() {
       InternalResourceViewResolver bean = new InternalResourceViewResolver();
  
       bean.setPrefix("/WEB-INF/view/");
       bean.setSuffix(".jsp");
  
       return bean;
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/assets/**")
          .addResourceLocations("/WEB-INF/assets/"); 
    }
    
}

package co.edu.unbosque.LaForestaTrading.configuration;

import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThymeleafConfig {

    @Bean
    public SpringSecurityDialect springSecurityDialect() {
        return new SpringSecurityDialect();
    }
}

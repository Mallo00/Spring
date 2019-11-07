package it.nextre.academy.nxtlearn.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class appConfig {
    @Bean
    public Logger getLogger(){
        return LoggerFactory.getLogger(this.getClass());
    }
}//end class

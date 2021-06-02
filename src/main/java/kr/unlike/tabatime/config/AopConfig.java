package kr.unlike.tabatime.config;
import kr.unlike.tabatime.aop.LoggerAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AopConfig {

    @Bean
    public LoggerAspect loggerAspect() {
        return new LoggerAspect();
    }
}


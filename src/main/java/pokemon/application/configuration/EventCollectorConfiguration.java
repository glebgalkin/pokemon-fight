package pokemon.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pokemon.application.util.EventCollector;

@Configuration
public class EventCollectorConfiguration {

    @Bean
    public EventCollector eventCollector(){
        return new EventCollector();
    }
}

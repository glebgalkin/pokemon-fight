package pokemon.application.configuration;

import org.springframework.context.annotation.Bean;
import pokemon.application.util.EventCollector;

public class EventCollectorConfiguration {

    @Bean
    public EventCollector eventCollector(){
        return new EventCollector();
    }
}

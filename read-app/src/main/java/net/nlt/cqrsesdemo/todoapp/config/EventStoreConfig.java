package net.nlt.cqrsesdemo.todoapp.config;

import com.github.msemys.esjc.EventStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.github.msemys.esjc.EventStoreBuilder.newBuilder;

@Configuration
public class EventStoreConfig {

    @Value("${eventstore.hostname}")
    private String hostname;

    @Value("${eventstore.port}")
    private int port;

    @Value("${eventstore.username}")
    private String username;

    @Value("${eventstore.password}")
    private String password;

    @Bean
    public EventStore eventStore() {
        return newBuilder()
                .singleNodeAddress(hostname, port)
                .userCredentials(username, password)
                .build();
    }
}

package net.nlt.cqrsesdemo.todoapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({SwaggerConfig.class, EventStoreConfig.class})
public class CoreConfig {
}

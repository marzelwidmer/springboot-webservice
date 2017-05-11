package ch.keepcalm.web.infrastructure.bootstrap;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
/**
 * Created by marcelwidmer on 26.09.16.
 */
@Configuration
@Profile(value = {"local"})
@ConditionalOnClass(name = {"de.flapdoodle.embed.mongo.MongosStarter"})
public class DevConfiguration {

    @Bean
    public DatabaseBootstrap databaseBootstrap(){
        return new DatabaseBootstrap();
    }
}

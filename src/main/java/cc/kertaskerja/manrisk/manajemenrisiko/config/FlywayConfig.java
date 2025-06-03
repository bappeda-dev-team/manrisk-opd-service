package cc.kertaskerja.manrisk.manajemenrisiko.config;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class FlywayConfig {

    @Bean
    @Profile("dev")
    public FlywayMigrationStrategy cleanMigrateStrategy() {
        return flyway -> {
            // In development, you can clean and migrate
            // flyway.clean();
            flyway.migrate();
        };
    }

    @Bean
    @Profile({"staging", "production"})
    public FlywayMigrationStrategy migrateStrategy() {
        return Flyway::migrate;
    }
}
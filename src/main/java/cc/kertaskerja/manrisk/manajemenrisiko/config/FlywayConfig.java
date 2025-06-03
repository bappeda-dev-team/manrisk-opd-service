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
            // Uncomment the next line if you want to clean database on startup
            // flyway.clean();
            
            // Repair if needed (useful in development)
            flyway.repair();
            flyway.migrate();
        };
    }

    @Bean
    @Profile({"staging", "production"})
    public FlywayMigrationStrategy migrateStrategy() {
        return flyway -> {
            // In production, only migrate (never clean)
            flyway.migrate();
        };
    }
    
    @Bean
    @Profile("docker")
    public FlywayMigrationStrategy dockerMigrateStrategy() {
        return flyway -> {
            // For Docker environments
            flyway.repair();
            flyway.migrate();
        };
    }
}
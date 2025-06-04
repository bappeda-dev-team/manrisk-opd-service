package cc.kertaskerja.manrisk.manajemenrisiko.config;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for metrics collection using Micrometer.
 * This enables the @Timed annotation for method-level metrics.
 */
@Configuration
public class MetricsConfig {

    /**
     * Creates a TimedAspect bean that enables the @Timed annotation.
     * This allows us to measure the execution time of methods.
     *
     * @param registry the meter registry
     * @return a new TimedAspect
     */
    @Bean
    public TimedAspect timedAspect(MeterRegistry registry) {
        return new TimedAspect(registry);
    }
}
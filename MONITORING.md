# Monitoring Setup with Prometheus and Grafana

This document describes how to use the monitoring setup for the Manajemen Risiko application.

## Overview

The monitoring setup consists of:

1. **Spring Boot Actuator**: Exposes metrics endpoints in the application
2. **Prometheus**: Collects metrics from the application
3. **Grafana**: Visualizes the metrics collected by Prometheus

## Accessing the Monitoring Tools

After starting the application with Docker Compose, you can access the monitoring tools at:

- **Prometheus**: http://localhost:9090
- **Grafana**: http://localhost:3000 (login with admin/admin)
- **Spring Boot Actuator**: http://localhost:8080/actuator

## Available Dashboards

Two dashboards are automatically provisioned in Grafana:

1. **Spring Boot Metrics**: General metrics about the application, including:
   - HTTP Request Duration
   - HTTP Request Count
   - JVM Memory Usage
   - System CPU Usage

2. **Custom Metrics Dashboard**: Metrics for specific endpoints that have been annotated with `@Timed`, including:
   - Skala Dampak API Response Times
   - Skala Dampak API Request Count

## Adding Custom Metrics

### Using @Timed Annotation

You can add timing metrics to any method by adding the `@Timed` annotation:

```java
import io.micrometer.core.annotation.Timed;

@GetMapping("/example")
@Timed(value = "example.method", description = "Time taken to execute example method")
public ResponseEntity<String> exampleMethod() {
    // Method implementation
    return ResponseEntity.ok("Example");
}
```

### Using MeterRegistry Directly

For more complex metrics, you can inject the `MeterRegistry` and use it directly:

```java
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Counter;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {
    private final Counter exampleCounter;
    
    public ExampleService(MeterRegistry registry) {
        this.exampleCounter = registry.counter("example.counter", "type", "example");
    }
    
    public void doSomething() {
        // Increment the counter
        exampleCounter.increment();
        
        // Method implementation
    }
}
```

## Customizing Prometheus Configuration

The Prometheus configuration is stored in `prometheus.yml`. You can modify this file to change the scrape interval or add additional targets.

## Customizing Grafana Dashboards

You can create additional dashboards in Grafana by:

1. Logging into Grafana
2. Creating a new dashboard
3. Exporting the dashboard as JSON
4. Saving the JSON file in `grafana/provisioning/dashboards/`

## Troubleshooting

If metrics are not showing up in Grafana:

1. Check that the application is running and exposing metrics at `/actuator/prometheus`
2. Check that Prometheus is scraping the metrics (http://localhost:9090/targets)
3. Check that Grafana is connected to Prometheus (Admin > Data Sources)
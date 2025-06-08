package cc.kertaskerja.manrisk.manajemenrisiko;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableJpaAuditing
public class ManajemenrisikoApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ManajemenrisikoApplication.class);

		app.addInitializers(applicationContext -> {
			ConfigurableEnvironment environment = applicationContext.getEnvironment();

			try {
				Dotenv dotenv = Dotenv.configure()
						.directory("./")
						.ignoreIfMissing()
						.load();

				// Convert dotenv entries to a Map
				Map<String, Object> envMap = new HashMap<>();
				dotenv.entries().forEach(entry -> {
					envMap.put(entry.getKey(), entry.getValue());
					System.out.println("Loaded: " + entry.getKey() + "=" + entry.getValue());
				});

				// Add the properties as a property source with high precedence
				environment.getPropertySources().addFirst(
						new MapPropertySource("dotenv", envMap)
				);
			} catch (Exception e) {
				System.err.println("Error loading .env file: " + e.getMessage());
				// Continue without .env file - rely on system environment variables
			}
		});

		app.run(args);
	}

}
package cc.kertaskerja.manrisk.manajemenrisiko;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ManajemenrisikoApplication {

	public static void main(String[] args) {
		try {
			Dotenv dotenv = Dotenv.configure()
					.directory("./")
					.ignoreIfMissing()
					.load();

			// Set system properties for Spring Boot
			dotenv.entries().forEach(entry -> {
				System.setProperty(entry.getKey(), entry.getValue());
				System.out.println("Loaded: " + entry.getKey() + "=" + entry.getValue());
			});
		} catch (Exception e) {
			System.err.println("Error loading .env file: " + e.getMessage());
			// Continue without .env file - rely on system environment variables
		}

		SpringApplication.run(ManajemenrisikoApplication.class, args);
	}
}
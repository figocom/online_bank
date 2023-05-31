package figo.devops.bogate;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@OpenAPIDefinition
public class BoGateApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoGateApplication.class, args);
	}

}

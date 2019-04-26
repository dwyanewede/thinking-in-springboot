package think.in.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "think.in.spring.boot.config")
public class ThinkSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThinkSpringBootApplication.class, args);
	}

}

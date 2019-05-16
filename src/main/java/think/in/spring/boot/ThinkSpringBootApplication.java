package think.in.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(scanBasePackages = "think.in.spring.boot.config")
@SpringBootApplication
public class ThinkSpringBootApplication {

	public static void main(String[] args) {
		System.setProperty("spring-think-spring-boot-author-name","shangxiansheng");
		SpringApplication.run(ThinkSpringBootApplication.class, args);
	}

}

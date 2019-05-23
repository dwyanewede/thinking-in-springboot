package think.in.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@SpringBootApplication(scanBasePackages = "think.in.spring.boot.config")
@SpringBootApplication
// 扫描项目下面的 @WebFilter 和 @WebServlet
@ServletComponentScan
public class ThinkSpringBootApplication {

	public static void main(String[] args) {
		System.setProperty("spring-think-spring-boot-author-name","shangxiansheng");
		SpringApplication.run(ThinkSpringBootApplication.class, args);
	}

}

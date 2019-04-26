package think.in.spring.boot.autoconfiguration;

import org.springframework.context.annotation.Bean;

/**
 * HelloWorld 配置
 *
 * @author sxs
 * @since 2018/5/14
 */
public class HelloWorldConfiguration {

    @Bean
    public String helloWorld() { // 方法名即 Bean 名称
        return "Hello,World sxs";
    }

}

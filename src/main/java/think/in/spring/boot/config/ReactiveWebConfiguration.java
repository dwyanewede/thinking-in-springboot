package think.in.spring.boot.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @ClassName: ReactiveWebController
 * @Description: SpringBootApplication聚合注解
 * @Author: 尚先生
 * @CreateDate: 2019/4/23 10:16
 * @Version: 1.0
 */
//@EnableAutoConfiguration
@Configuration
public class ReactiveWebConfiguration {

    // 1.下面的写法
    // 2.直接写在启动类中
    // 3.采用EnableAutoConfiguration标注该类，
    // 在启动类中将ReactiveWebConfiguration.class作为启动加载配置类实现
    @Bean
    public RouterFunction<ServerResponse> helloWorld(){
        return route(GET("/hello-world"),
                request -> ok().body(Mono.just("Hello, World"),String.class)
                );
    }

    @EventListener(WebServerInitializedEvent.class)
    public void onWebServerReady(WebServerInitializedEvent event){
        System.out.println("当前webServer实现类： " + event.getWebServer().getClass().getName());
        System.out.println("服务启动端口： " + event.getWebServer().getPort());
    }
}

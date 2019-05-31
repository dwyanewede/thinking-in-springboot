package think.in.spring.boot.spi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Spring Boot 通过 BeanFactory 实现日志分级拦截
 * 由于项目有一些数据源等的 maven 依赖，故此在测试时需要屏蔽对应的依赖，防止自动装配报错
 */
@SpringBootApplication
public class Application {

    public Application(IPrint printProxy) {

        printProxy.execute(10, " log print ");
        printProxy.execute(0, " console print ");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // 容器启动代理方式获得 beanName 信息 实现代理功能
//    public static void main(String[] args) throws Exception {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.scan("think.in.spring.boot.spi");
//        context.refresh();
////        IPrint proxyInstance = (IPrint) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IPrint.class}, new ProxInvocationHandler(context));
////        proxyInstance.execute(10, " log print ");
////        proxyInstance.execute(0, " console print ");
//
//    }
}
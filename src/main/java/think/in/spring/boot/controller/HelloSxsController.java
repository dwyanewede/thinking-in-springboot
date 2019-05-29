package think.in.spring.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: HelloSxsController
 * @Description: web servlet实现
 * @Author: 尚先生
 * @CreateDate: 2019/4/25 19:23
 * @Version: 1.0
 */
@RestController
public class HelloSxsController {

    @Value("${my.girl}")
    private String myGirl;

    @GetMapping("/hello-sxs")
    public Callable<String> hello() throws InterruptedException {

        System.out.println("接收请求，开始处理...  " + Thread.currentThread().getName());

        Callable<String> result = (()->{
            TimeUnit.SECONDS.sleep(5);
            System.out.println("do you like " + myGirl + " ： " + Thread.currentThread().getName());
            return "do you like " + myGirl;
        });
        // TODO 知识点
        // 不能在异步代码块中使用 wait()
        // 会导致 java.lang.IllegalMonitorStateException
        // wait();
        System.out.println("接收任务线程完成并退出...  " + Thread.currentThread().getName());

        return result;
    }
}

package think.in.spring.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: HelloSxsController
 * @Description: web servlet实现
 * @Author: 尚先生
 * @CreateDate: 2019/4/25 19:23
 * @Version: 1.0
 */
@RestController
public class HelloSxsController {

    @GetMapping("/hello-sxs")
    public String hello(){
        return "hello sxs !";
    }
}

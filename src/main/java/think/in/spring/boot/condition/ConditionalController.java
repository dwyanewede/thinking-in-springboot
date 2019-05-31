package think.in.spring.boot.condition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.StandardServletEnvironment;

@RestController
@RequestMapping(path = "/conditional")
public class ConditionalController {

    @Autowired
    private RandDataComponent randDataComponent;

    @Autowired
    private StandardServletEnvironment environment;

    @GetMapping(path = "/show")
    public String show() {
        String type = environment.getProperty("conditional.rand.type");
        return randDataComponent.rand() + " 数据类型  " + type;
    }
}
package think.in.spring.boot.spi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ProxInvocationHandler
 * @Description: java类作用描述
 * @Author: 尚先生
 * @CreateDate: 2019/5/30 17:36
 * @Version: 1.0
 */
public class ProxInvocationHandler implements InvocationHandler {

    private Class<? extends ISpi> spiClz;

    private List<ISpi> list;

    public ProxInvocationHandler(AnnotationConfigApplicationContext context) {
        Map<String, ISpi> map = context.getBeansOfType(ISpi.class);
        list = new ArrayList<>(map.values());
        list.sort(Comparator.comparingInt(ISpi::order));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        for (ISpi spi : list) {
//            if (spi.verify(args[0])) {
                // 第一个参数作为条件选择
                return method.invoke(spi, args);
//            }
        }

        throw new Exception("no spi server can execute! spiList: " + list);
    }
}

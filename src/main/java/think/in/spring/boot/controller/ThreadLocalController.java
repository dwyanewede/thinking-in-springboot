package think.in.spring.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: ThreadLocalController
 * @Description: ThreadLocal 测试类
 * @Author: 尚先生
 * @CreateDate: 2019/5/18 16:31
 * @Version: 1.0
 */

@RestController
public class ThreadLocalController {

    public ThreadLocal<Map<String,Object>> attAtcMap = new ThreadLocal<Map<String,Object>>(){
        protected Map<String,String> initValue(){
            return new HashMap<>();
        }
    };

    public AtomicInteger atomicInteger = new AtomicInteger(1);

    @GetMapping("/hello-threadLocal")
    public String testThreadLocal(int num) throws InterruptedException {

        // 手动开启线程池
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        exec(executorService,num);

        // 模拟执行同步操作，实际生产上由于线程切换，不会导致所有的请求到达后进行获取
        // 此处先存后取，但是还是出现线程切换后，存取信息不一致的问题，更能说明，线程池模式下 ThreadLocal 不可取
        TimeUnit.SECONDS.sleep(5);

        print(executorService,num);

        executorService.shutdown();

        return "success...";
    }


    // http://localhost:8080/hello-threadLocal/?num=20000
    // 测试大对象造成的内存溢出
    /*private void exec(ExecutorService executorService,int num) {
        for (int i = 0; i < num; i++){
            executorService.submit(() -> {
                LinkedBlockingQueue<Object> objects = new LinkedBlockingQueue<>(2048);
                Map<String, Object> objectHashMap = new HashMap<>();
                objectHashMap.put(Thread.currentThread().getName(), objects);
                System.out.println("开始向 ThreadLocal 中设置对象 " + " 设置次数： " + atomicInteger.getAndIncrement());
                attAtcMap.set(objectHashMap);
            });
        }
    }*/



    // http://localhost:8080/hello-threadLocal/?num=10
    // 线程池的方式存入请求信息
    private void exec(ExecutorService executorService,int num) {

        for (int i = 0; i < num; i++){
            executorService.submit(() -> {
                int andIncrement = atomicInteger.getAndIncrement();
                String currentMsg = "设置对象信息: " + andIncrement;
                Map<String, Object> objectHashMap = new HashMap<>();
                String name = Thread.currentThread().getName();
                objectHashMap.put(name, currentMsg);
                System.out.println("当前线程： " + name + "开始向 ThreadLocal 中设置对象 " + "currentMsg " + currentMsg + " 设置次数： " + andIncrement);
                attAtcMap.set(objectHashMap);
            });
        }
    }

    // 线程池的方式取出请求信息
    private void print(ExecutorService executorService, int num) {
        for (int i = 0; i < num; i++){
            executorService.submit(() -> {
                String name = Thread.currentThread().getName();
                Map<String, Object> objectMap = attAtcMap.get();
                System.out.println("当前线程： " + name + "获得的对象值 " + objectMap.get(name));
            });
        }
    }
}

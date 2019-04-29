package think.in.spring.boot.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: RunTimeExeceptionHandler
 * @Description: 异常处理类拦截器
 * @Author: 尚先生
 * @CreateDate: 2019/4/29 11:47
 * @Version: 1.0
 */
@RestControllerAdvice
public class RunTimeExeceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String,Object>> handlerOfRunTimeException(Exception e){
        HashMap<String, Object> hashMap = new HashMap<>();
        if (e instanceof RuntimeException){
            hashMap.put("code","0002");
            hashMap.put("message","cann`t find user message");
        }else {
            hashMap.put("code","0001");
            hashMap.put("message","undifined exeception");
        }
        return new ResponseEntity<Map<String,Object>>(hashMap, HttpStatus.OK);
    }
}

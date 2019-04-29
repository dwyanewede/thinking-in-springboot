package think.in.spring.boot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


/**
 * @ClassName: HashMapController
 * @Description: HashMap相关数据返回处理
 * @Author: 尚先生
 * @CreateDate: 2019/4/29 11:01
 * @Version: 1.0
 */
@RestController
public class HashMapController {

    // url: http://localhost:8080/exeception/mapping?userId=1
    @RequestMapping("/exeception/mapping")
    public ResponseEntity<Map<String,Object>> queryPersonByIdOfExeception(@RequestParam("userId") final Integer userId){
        // 设置判断条件
        // 失败后异常抛出
        Optional.ofNullable(userId).filter(agrs -> agrs /2 == 0).orElseThrow(() -> new RuntimeException("cann`t find user message of userId: "+ userId));
        // 正常返回数据
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("id",userId);
        hashMap.put("name","sxs");
        return new ResponseEntity<Map<String,Object>>(hashMap, HttpStatus.OK);
    }

    // url: http://localhost:8080/empty/mapping?userId=1
    @RequestMapping("/empty/mapping")
    public ResponseEntity<Map<String,Object>> queryPersonByIdOfEmpty(@RequestParam("userId") final Integer userId){
        // 设置判断条件
        // 失败后异常抛出
        Optional.ofNullable(userId).filter(agrs -> agrs /2 == 0).orElseThrow(() -> new RuntimeException("cann`t find user message of userId: "+ userId));
        // 正常返回数据
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("id",userId);
        hashMap.put("name","sxs");
        Map<String, Object> resMap = new HashMap<>();
        callEmptyMap(hashMap, resMap);
        return new ResponseEntity<Map<String,Object>>(resMap, HttpStatus.OK);
    }

    private Map<String,Object> callEmptyMap(Map<String, Object> hashMap,Map<String, Object> resMap) {

        // 虽然同样是返回的数据类型为 Map 但是实际的返回地址不是 resMap 对应的数据地址
        // Map<String, Object> paraMap = new HashMap<>();
        // paraMap.putAll(hashMap);
        // return paraMap;

        // ps:在项目中实际遇到的坑货会这样做：
        // 在此处可能出现问题的概率不大，但是如果框架自身会对 reqMap 和 resMap 进行封装
        // 有可能会出现返回地址有误，导致上游响应数据为空的情况

        // 如果需要调整，采用以下方式即可，主要是返回数据为 resMap 对应的地址
        resMap.putAll(hashMap);
        return resMap;
    }


}

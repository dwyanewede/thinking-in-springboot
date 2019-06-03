package think.in.spring.boot.thinkspringboot;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: ClassT
 * @Description: 泛型约束测试
 * @Author: 尚先生
 * @CreateDate: 2019/6/3 15:22
 * @Version: 1.0
 */
public class ClassT<T>{

    public ConcurrentHashMap hashMap;

    public ConcurrentHashMap getHashMap() {
        return hashMap;
    }

    public void setHashMap(ConcurrentHashMap hashMap) {
        this.hashMap = hashMap;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        // 组装请求数据
        ClassT classT = installRequestMsg();
        // Class<T>
        classT.method1(classT.getClass());
        pringMsg(classT.getHashMap(), "-------------method1最终结果-------------");
        // Class<?>
        Class method2 = classT.method2(classT.getClass());
        // 打印数据信息
//        Integer instance = (Integer) method2.newInstance();
        pringMsg(method2.getName(), "-------------method2最终结果-------------");
    }

    private static void pringMsg(Object hashMap, String s) {
        System.out.println(hashMap + s);
    }

    private Class<?> method2(Class<?> aClass) {
        try {
            Field field = aClass.getField("hashMap");
            field.setAccessible(true);
            // 设置当前对象为目标 Object
            Object value = field.get(this);
            pringMsg(value, "--------------method2反射获取结果--------------");
            ConcurrentHashMap<String, Object> resMap = new ConcurrentHashMap<>();
            resMap.put("sxs", "good");
            field.set(this, resMap);
            pringMsg(this.hashMap, "--------------method2修改后的结果--------------");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Class<?> integerClass = new Integer(1).getClass();

        return integerClass;
    }


    private static ClassT installRequestMsg() {
        ClassT classT = new ClassT();
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        map.put("sxs","beautiful");
        classT.setHashMap(map);
        return classT;
    }


    private Class<T> method1(Class<T> classT) {
        try {
            Field field = classT.getField("hashMap");
            field.setAccessible(true);
            // 设置当前对象为目标 Object
            Object value = field.get(this);
            pringMsg(value, "--------------method1反射获取结果--------------");
            ConcurrentHashMap<String, Object> resMap = new ConcurrentHashMap<>();
            resMap.put("sxs", "male");
            field.set(this, resMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 当返回值类型不同的时候 编译时报错
//        Integer integer = new Integer(1);
//        Class<? extends Integer> aClass = integer.getClass();
        return classT;
    }
}

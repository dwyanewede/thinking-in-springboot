package think.in.spring.boot.servlet;


import com.alibaba.druid.support.http.StatViewServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * @ClassName: DruidStatViewServlet
 * @Description: StatViewServlet servlet拦截器
 * @Author: 尚先生
 * @CreateDate: 2019/5/22 17:58
 * @Version: 1.0
 */
// druid web 管控台
// http://127.0.0.1:8080/monitor/druid/sql.html
@WebServlet(urlPatterns = "/monitor/druid/*", asyncSupported = true,
        initParams = {
                @WebInitParam(name = "allow", value = "127.0.0.1"),
                @WebInitParam(name = "deny", value = "192.168.0.176"),
                @WebInitParam(name = "loginUsername", value = "admin"),
                @WebInitParam(name = "loginPassword", value = "123456"),
                @WebInitParam(name = "resetEnable", value = "false")
        })
public class DruidStatViewServlet extends StatViewServlet {


}
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
@WebServlet(urlPatterns = "/monitor/druid/*", asyncSupported = true,
        initParams = {
                @WebInitParam(name = "allow", value = ""),
                @WebInitParam(name = "deny", value = ""),
                @WebInitParam(name = "loginUsername", value = "admin"),
                @WebInitParam(name = "loginPassword", value = "123456")
        })
public class DruidStatViewServlet extends StatViewServlet {
}
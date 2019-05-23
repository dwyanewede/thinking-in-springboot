package think.in.spring.boot.filter;


import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @ClassName: DruidStatFilter
 * @Description: DruidStatFilter 过滤器
 * @Author: 尚先生
 * @CreateDate: 2019/5/22 16:44
 * @Version: 1.0
 */
@WebFilter(filterName = "druidStatFilter", urlPatterns = "/*", asyncSupported = true,
        initParams = {
                @WebInitParam(name = "exclusions", value = "/static/*,*.js,*.gif,*.jpg,*.png,*.css,*.ico,/monitor/druid/*")//忽略资源
        }
)
public class DruidStatFilter extends WebStatFilter {

//        @Override
//        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
//                ServletException {
//                //创建过滤器
//                FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
//                //设置过滤器过滤路径
//                filterRegistrationBean.addUrlPatterns("/*");
//                //忽略过滤的形式
//                filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        }

}
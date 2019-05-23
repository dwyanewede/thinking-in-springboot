package think.in.spring.boot.filter;


import com.alibaba.druid.support.http.WebStatFilter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

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

}
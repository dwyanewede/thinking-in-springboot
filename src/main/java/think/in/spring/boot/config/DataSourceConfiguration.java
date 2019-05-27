package think.in.spring.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @ClassName: DataSource
 * @Description: DataSource 数据源配置类，可选择 DruidDataSource、UnpooledDataSource、PooledDataSource
 * @Author: 尚先生
 * @CreateDate: 2019/5/22 12:44
 * @Version: 1.0
 */
@Configuration
public class DataSourceConfiguration {

    @Value("${spring.druid.filters}")
    private String filters;


    // 采用 Druid 实现线程池
    @Bean
    @ConfigurationProperties(prefix = "spring.druid")
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setFilters(filters);
        return druidDataSource;
    }


    // 不使用线程池实现
//    @Bean
//    public DataSource dataSource() throws SQLException {
//        UnpooledDataSource dataSource = new UnpooledDataSource("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/testdb", "root", "123456");
//        return dataSource;
//    }


//    // 采用 MyBatis 默认支持的线程池
//    @Bean
//    public DataSource dataSource() throws SQLException {
//        PooledDataSource dataSource = new PooledDataSource("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/testdb", "root", "123456");
//        return dataSource;
//    }

//    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }





    // druid 相关 filter 和 servlet 配置
//    @Bean
//    public ServletRegistrationBean statViewServlet(){
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
//        servletRegistrationBean.addInitParameter("allow","127.0.0.1");  //设置ip白名单
//        servletRegistrationBean.addInitParameter("deny","192.168.0.19");//设置ip黑名单，优先级高于白名单
//        //设置控制台管理用户
//        servletRegistrationBean.addInitParameter("loginUsername","root");
//        servletRegistrationBean.addInitParameter("loginPassword","root");
//        //是否可以重置数据
//        servletRegistrationBean.addInitParameter("resetEnable","false");
//        return servletRegistrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean statFilter(){
//        //创建过滤器
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
//        //设置过滤器过滤路径
//        filterRegistrationBean.addUrlPatterns("/*");
//        //忽略过滤的形式
//        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        return filterRegistrationBean;
//    }
}
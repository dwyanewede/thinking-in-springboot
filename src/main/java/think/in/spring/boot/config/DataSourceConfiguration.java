package think.in.spring.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
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

}
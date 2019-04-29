package think.in.spring.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName: PropertySourceConfiguration
 * @Description: PropertySource
 * @Author: 尚先生
 * @CreateDate: 2019/4/26 12:44
 * @Version: 1.0
 */
@Configuration
@PropertySource(name = "my.girl",value = "classpath:/angle.properties")
public class PropertySourceConfiguration {




}

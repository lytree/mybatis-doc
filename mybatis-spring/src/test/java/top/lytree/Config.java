package top.lytree;

import com.mysql.cj.jdbc.Driver;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
public class Config {
  @Bean
  public SqlSessionFactory sqlSessionFactory() throws Exception {
    SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
    // 设置数据源
    factoryBean.setDataSource(dataSource());
    // mapper.xml 文件路径
    Resource[] resources = new PathMatchingResourcePatternResolver()
      .getResources("classpath*:/top/lytree/**/*.xml");
    factoryBean.setMapperLocations(resources);
    return factoryBean.getObject();
  }

  @Bean
  public DataSource dataSource() throws Exception {
    Driver driver = new com.mysql.cj.jdbc.Driver();
    String url = "jdbc:mysql://localhost:3306/test";
    String username = "root";
    String password = "test";
    return new SimpleDriverDataSource(driver, url, username, password);
  }
}

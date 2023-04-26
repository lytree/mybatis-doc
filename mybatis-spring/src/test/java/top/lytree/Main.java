package top.lytree;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
@ComponentScan
@MapperScan("top.lytree")
public class Main {
  public static void main(String[] args) {
    ApplicationContext application
      = new AnnotationConfigApplicationContext(Main.class);
    RoleMapper bean = application.getBean(RoleMapper.class);
    Role beanRole = bean.getRole(1L);
    System.out.println(beanRole);
  }

}


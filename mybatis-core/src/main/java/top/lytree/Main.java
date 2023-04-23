package top.lytree;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSessionManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class Main {
  public static void main(String[] args) {
    String resource="mybatis-config.xml";
    InputStream inputStream=null;
    try {
      inputStream = Files.newInputStream(new File("F:\\github\\mybatis\\mybatis-core\\src\\main\\java\\top\\lytree\\mybatis-config.xml").toPath());
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    SqlSessionFactory sqlSessionFactory=null;
    sqlSessionFactory=SqlSessionManager.newInstance(inputStream);
    SqlSession sqlSession=null;
    try {
      sqlSession=sqlSessionFactory.openSession();
      RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
      Role role=roleMapper.getRole(1L);
      System.out.println(role.getId()+":"+role.getRoleName()+":"+role.getNote());
      sqlSession.commit();

    } catch (Exception e) {
      // TODO Auto-generated catch block
      sqlSession.rollback();
      e.printStackTrace();
    }finally {
      sqlSession.close();
    }
  }
}


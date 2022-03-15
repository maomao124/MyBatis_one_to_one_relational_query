package mapper;

import data.Class;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：MyBatis一对一关联查询
 * Package(包名): mapper
 * Class(测试类名): ClassMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/3/15
 * Time(创建时间)： 22:19
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class ClassMapperTest
{

    @Test
    void testGetClass() throws IOException
    {
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ClassMapper classMapper = sqlSession.getMapper(ClassMapper.class);
        Class aClass = classMapper.getClass(1001L);
        System.out.println(aClass);
        sqlSession.close();
    }
}
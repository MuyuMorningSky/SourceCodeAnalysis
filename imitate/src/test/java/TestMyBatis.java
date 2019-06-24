import com.mayikt.entity.UserEntity;
import com.mayikt.mappers.UserMapper;
import com.mayikt.session.SqlSession;
import com.mayikt.session.SqlSessionFactory;
import com.mayikt.session.SqlSessionFactoryBuilder;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: TestMyBatis
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/6/1821:17
 */
public class TestMyBatis {
    public static void main(String[] args) throws Exception {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        // 1.装配文件，
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build("my_config.properies");
        // 2.开启会话，设置默认执行器
        SqlSession sqlSession = sqlSessionFactory.openSqlSession();
        // 2.生成代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 3.执行MapperProxy invoke
        UserEntity userEntity = userMapper.getUser(1);
        System.out.println(userEntity.toString());

    }
}

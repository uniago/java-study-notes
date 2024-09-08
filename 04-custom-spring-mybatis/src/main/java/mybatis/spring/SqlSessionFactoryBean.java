package mybatis.spring;

import com.uniago.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class SqlSessionFactoryBean implements FactoryBean {

   private final SqlSession sqlSession;

   // 构造注入
   public SqlSessionFactoryBean(SqlSessionFactory sqlSessionFactory) {
       // 从factory中获取sqlSession
       this.sqlSession = sqlSessionFactory.openSession();
       // 已在xml中配置
       // sqlSessionFactory.getConfiguration().addMapper(UserMapper.class);
       // sqlSessionFactory.getConfiguration().addMappers("com.uniago.mapper");
   }

    /**
     * mybatis 生成的代理对象
     * @return bean
     * @throws Exception 错误
     */
    @Override
    public Object getObject() throws Exception {
        // 从这里返回出去mapper代理对象
        return sqlSession.getMapper(UserMapper.class);
    }

    /**
     * bean类型
     * @return bean类型
     */
    @Override
    public Class<?> getObjectType() {
        return UserMapper.class;
    }
}

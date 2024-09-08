package mybatis.spring;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

public class SqlSessionFactoryBean implements FactoryBean {

    private SqlSession sqlSession;

    private Class<?> mapperClass;

    // 构造注入 可通过BeanDefinition设置构造 注册bean
    public SqlSessionFactoryBean(Class<?> mapperClass) {
        this.mapperClass = mapperClass;
    }

    // 属性注入
    @Autowired
    public void setSqlSession(SqlSessionFactory sqlSessionFactory) {
        // 从factory中获取sqlSession
        this.sqlSession = sqlSessionFactory.openSession();
    }

    /**
     * mybatis 生成的代理对象
     *
     * @return bean
     * @throws Exception 错误
     */
    @Override
    public Object getObject() throws Exception {
        // 从这里返回出去mapper代理对象
        return sqlSession.getMapper(mapperClass);
    }

    /**
     * bean类型
     *
     * @return bean类型
     */
    @Override
    public Class<?> getObjectType() {
        return mapperClass;
    }
}

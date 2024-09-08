package com.uniago;

import mybatis.spring.MapperScan;
import mybatis.spring.MybatisImportBeanDefinitionRegistrar;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.io.IOException;
import java.io.InputStream;

@ComponentScan("com.uniago")
@MapperScan("com.uniago.mapper")
public class AppConfig {

    /**
     * 通过配置文件生成sqlSessionFactory Bean
     * @return sqlSessionFactory Bean
     * @throws IOException 异常
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }
}

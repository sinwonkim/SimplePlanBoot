package com.simpleplan.boot;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@SpringBootApplication
@Configuration //이 자바 클래스가 설정관련 파일이라고 설정하는 어노테이션 입니다.
public class SpringBoot1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot1Application.class, args);
	}
	
	 /*
     * SqlSessionFactory 설정 
     */
    @Bean // 스프링에 필요한 객체를 생성
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean(); // sqlSessionFactory(): Mybatis의 SqlSessionFactory를 반환해준다. 스프링부트가 실행할때 DataSource객체를 
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/*Mapper.xml")); // Mapper위치지정
        return sessionFactory.getObject();
    }

}

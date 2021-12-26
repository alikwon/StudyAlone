package app.messages;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

/*
	- @Configuration : AppConfig.java 파일이 빈을 정의하기 위한 것임을 스프링에게 알려줌
	- @ComponentScan : 어노테이션이 달린 컴포넌트를 스캔할 기본 패키지를 스프링에 알려줌
	- @Bean : Bean을 생성하는 역할. 메소드의 이름이 빈의 이름이 됨. 
 */
@Configuration
@ComponentScan("app.messages")
public class AppConfig {
    
	
/* 
 	- 각 클래스에 @Component 를 선언했으므로 더는 필요가 없음
 	- 남겨두게 되면 @Bean 어노테이션에 의해 재정의됨.
	@Bean
	public MessageRepository messageRepository() {
		return new MessageRepository();
	}
	
	@Bean
	MessageService messageService() {
		// messageRepository 인스턴스를 messageService 생성자에 전달.
		return new MessageService(messageRepository());
	}
*/
	
	/*
		- web.xml은 웹 애플리케이션의 서버에 배포되는 .war 파일처럼 웹 애플리케이션을 위한 것이다.
		- web.xml 파일이 없으므로 FilterRegistrationBean을 사용함
	 */
	@Bean
	public FilterRegistrationBean<AuditingFilter> auditingFilterRegistrationBean(){
		FilterRegistrationBean<AuditingFilter> registration = new FilterRegistrationBean<>();
		AuditingFilter filter = new AuditingFilter();
		registration.setFilter(filter);
		
		// 순서가 작은 것이 앞으로...
		registration.setOrder(Integer.MAX_VALUE); 
		
		// /messages 로 시작하는 요청만 처리
		registration.setUrlPatterns(Arrays.asList("/messages/*"));
		return registration;
	}
	
	/* 
		- org.hibernate.Session은 엔티티를 저장하고 불러오기 위한 주요 인터페이스
		- 하이버네이트 SessionFactory 인스턴스에서 세션을 생성할 수 있다.
		- 스프링 ORM 으로 SessionFactory의 인스턴스를 생성하려면 스프링의 "LocalSessionFactoryBean"을 사용.
		- LocalSessionFactoryBean을 생성하려면 javax.sql.Datasource인스턴스가 필요함
		*/
	private DataSource dataSource;
	
	public AppConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		//setPackagesToScan() : 하이버네이트가 인티티 클래스를 찾기위해 검색할 패키지 지정
		sessionFactoryBean.setPackagesToScan("app.messages");
		return sessionFactoryBean;
	}
}

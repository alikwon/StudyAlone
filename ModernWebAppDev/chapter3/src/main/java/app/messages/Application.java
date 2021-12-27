package app.messages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
	Spring boot 의존성 추가 후
	@SpringBootApplication 추가
	
	- @SpringBootApplication : 스프링부트 공식 스타터의 자동설정 구현체 (spring-boot-autoconfigure) 의 트리거
		= 
		@SpringBootConfiguration : 스프링 부트 애플리케이션의 설정클래스 
		+ @EnableAutoConfiguration : 자동설정을 활성화
		+ @ComponentScan : 컴포넌트 스캔기능 활성화
 */
@SpringBootApplication
public class Application {
	public static void main(String[] args) {

/*
		 Spring boot 의존성 추가 후 자동설정이 수행되므로 필요없어짐 ApplicationContext context = new
		 AnnotationConfigApplicationContext(AppConfig.class); MessageService
		 messageService = context.getBean(MessageService.class);
		 messageService.save("Hello, Spring!");
*/		
		SpringApplication.run(Application.class, args);
	}
}

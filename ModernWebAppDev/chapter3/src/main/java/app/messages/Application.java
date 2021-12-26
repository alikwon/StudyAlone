package app.messages;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
	Spring boot 의존성 추가 후
	@SpringBootApplication 추가
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

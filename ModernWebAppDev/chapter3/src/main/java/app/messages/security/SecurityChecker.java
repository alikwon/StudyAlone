package app.messages.security;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityChecker {

	private static final Logger logger = LoggerFactory.getLogger(SecurityChecker.class);
/*
 	- 포인트컷 : AOP에서 포인트컷은 일치하는 여러 조인 포인트를 결합한 것
 	
	//포인트컷 시그니처
	@Pointcut("execution(* app.messages..*.*(..))")
	public void checkMessageMethod() {}

	@Around("checkMessageMethod()")
	public Object checkSecurity (ProceedingJoinPoint joinPoint) {
		//...
	}
*/
	
/*
	- 스프링 시큐리티는 
	  요청레벨의 접근 제어는 filter객체를,
	  메소드 레벨의 접근제어는 @Secure 어노테이션을 활용한 AOP를 사용한다
*/
	@Pointcut("@annotation(SecurityCheck)")
	public void checkMethodSecurity() {}
	
	@Around("checkMethodSecurity()")
	public Object checkSecurity (ProceedingJoinPoint joinPoint) throws Throwable {
		logger.debug("Checking method security...");
		// TODO 여기에 보안검사 로직 구현하기
		Object result = joinPoint.proceed();
		return result;
	}
}

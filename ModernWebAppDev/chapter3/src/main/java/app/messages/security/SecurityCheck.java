package app.messages.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
	어노테이션 생성
	
	- @Target : 사용자가 만든 어노테이션이 부착될 수 있는 타입.  @Target({ElementType.xxx, ElementType.xxxx, ...})
		- ElementType.METHOD : 메서드 선언
	- @Retention: annotation 이 실제로 적용되고 유지되는 범위
		- RetentionPolicy.RUNTIME : 컴파일 이후에도 JVM에 의해서 계속 참조가 가능.
*/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SecurityCheck {

}

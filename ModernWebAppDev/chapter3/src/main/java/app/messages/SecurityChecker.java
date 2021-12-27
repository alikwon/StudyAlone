package app.messages;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
	어노테이션 생성
	
	- @Target : 사용자가 만든 어노테이션이 부착될 수 있는 타입.  @Target({ElementType.xxx, ElementType.xxxx, ...})
	- 
*/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SecurityChecker {

}

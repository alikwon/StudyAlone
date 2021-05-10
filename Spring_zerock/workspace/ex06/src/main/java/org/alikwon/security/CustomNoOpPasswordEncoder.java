package org.alikwon.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomNoOpPasswordEncoder implements PasswordEncoder{@Override
	
	public String encode(CharSequence rawPassword) {
		log.warn("인코딩 전 : "+rawPassword);
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		log.warn("매치 : "+rawPassword+":" + encodedPassword);
		return rawPassword.toString().equals(encodedPassword);
	}
	
}

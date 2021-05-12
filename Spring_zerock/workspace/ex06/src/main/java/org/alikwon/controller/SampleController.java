package org.alikwon.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/sample/*")
@Controller
public class SampleController {

	@GetMapping("/all")
	public void doAll() {
		log.info("엑세스 모두");
	}

	@GetMapping("/member")
	public void doMember() {
		log.info("엑세스 맴버");
	}

	@GetMapping("/admin")
	public void doAdmin() {
		log.info("엑세스 관리자");
	}

	// 어노테이션을 이용한 방식은 서블릿 컨텍스트에서 관련설정이 추가되어야한다
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_MEMBER')")
	@GetMapping("/annoMember")
	public void doMember2() {
		log.info("어노테이션 맴버로 로그인");
	}

	@Secured({ "ROLE_ADMIN" })
	@GetMapping("/annoAdmin")
	public void doAdmin2() {
		log.info("관리자 어노테이션 로그인");
	}
}

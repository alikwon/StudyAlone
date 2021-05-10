package org.alikwon.controller;

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
}

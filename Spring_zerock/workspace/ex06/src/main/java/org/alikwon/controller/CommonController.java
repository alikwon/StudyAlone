package org.alikwon.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CommonController {

	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("access Denied : " + auth);
		model.addAttribute("msg", "access Denied!!");
	}

	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		log.info("error: " + error);
		log.info("logout: " + logout);

		if (error != null) {
			model.addAttribute("error", "로그인 에러, 계정확인하세요");
		}
		if (logout != null) {
			model.addAttribute("logout","로그아웃!!");
		}
	}
	
	@GetMapping("/customLogout")
	public void logoutGET() {
		log.info("커스텀 로그아웃");
	}
}

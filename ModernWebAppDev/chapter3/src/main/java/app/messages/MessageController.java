package app.messages;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/messages")
public class MessageController {

//	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
//	대신 @GetMapping 사용
//	@GetMapping("/welcome")
//	@ResponseBody
//	public String welcome(Model model) {
////		return "Hello, Welcome to Spring Boot!";
//		// html 코드를 return하는것은 실용적이지 않음
////		return "<strong>Hello, Welcome to Spring Boot!</strong>";
//		model.addAttribute("message","Hello, Welcome to Spring Boot!");
//		return "welcome";
//	}
	private MessageService messageService;

	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}

	@GetMapping("/welcome")
	@ResponseBody
	public ModelAndView welcome() {
		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject("message", "Hello, Welcome to Spring Boot!");
		return mv;
	}

	@PostMapping("")
	@ResponseBody
	public ResponseEntity<Message> saveMessage(@RequestBody MessageData data){
		// ResponseEntity 는 응답상태, 본문과 헤더를 설정할 수 있게 허용한다
		// @RequestBody : HTTP 요청 본문에 전달된 JSON 형식의 string을 MessageData 인스턴스로 변환
		
		Message saved = messageService.save(data.getText());
		if(saved == null) {
			return ResponseEntity.status(500).build();
		}
		return ResponseEntity.ok(saved);
	}
}

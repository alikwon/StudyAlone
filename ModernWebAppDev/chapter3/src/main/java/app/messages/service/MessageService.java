package app.messages.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import app.messages.model.Message;
import app.messages.repository.MessageRepository;
import app.messages.security.SecurityCheck;

@Component
public class MessageService {
	
	private static final Logger log = LoggerFactory.getLogger(MessageService.class);

	// MessageRepository 를 의존성으로 정의
	private MessageRepository repository;

	public MessageService(MessageRepository repository) {
		this.repository = repository;
	}

/*
	@SecurityCheck 어노테이션을 save()에 적용하지 않으면 보안검사 예제에서 코드실행흐름이
	MessageController.saveMessage() 메소드에서 MessageService.save() 메소드로 직접흐른다.
	하지만 
	@SecurityCheck 어노테이션을 적용하면 런타임중에 코드 실행 흐름이
	MessageController.saveMessage() 에서 스프링 AOP가 생성한 AOP프록시 객체로 흘러간다.
	
		호출자															대상메소드
	MessageController.   ----->   AOP   ----->    어드바이저    ----->  MessageService.
	  saveMessage()				 프록시		   checkSecurity()				save()
	  	  ↑						  │	↑				  │	↑					│
	  	  └───────────────────────┘ └─────────────────┘ └───────────────────┘
*/
	@SecurityCheck
//	@Transactional(rollbackFor = {UnsupportedOperationException.class})
	@Transactional(noRollbackForClassName = {"UnsupportedOperationException"})
	public Message save(String text) {
		Message message = repository.saveMessage(new Message(text));
		log.debug("New message[id={}] saved", message.getId());
		// @Transactional 적용후 예외를 던지는 메소드를 호출하도록 함.
		// 예외발생하면서 트랜젝션 롤백이 발생함.
//		updateStatistics();
		return message;
	}

//	private void updateStatistics() {
//		throw new UnsupportedOperationException("This method is not implemented yet");
//	}

	@Transactional(readOnly = true)
	public List<Message> getMessages() {
		return repository.getMessages();
	}
}

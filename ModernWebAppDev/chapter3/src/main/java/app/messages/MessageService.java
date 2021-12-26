package app.messages;

import org.springframework.stereotype.Component;

@Component
public class MessageService {
	// MessageRepository 를 의존성으로 정의
	private MessageRepository repository;

	public MessageService(MessageRepository repository) {
		this.repository = repository;
	}

	public Message save(String text) {
		return repository.saveMessage(new Message(text));
	}
}

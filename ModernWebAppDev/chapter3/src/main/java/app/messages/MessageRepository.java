package app.messages;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;


@Component
public class MessageRepository {
	private final static Log logger = LogFactory.getLog(MessageRepository.class);
	
	private SessionFactory sessionFactory;
	public MessageRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Message saveMessage(Message message) {
		//openSession() 을 이용해 session 인스턴스를 획득
		Session session = sessionFactory.openSession();
		
		//객체에서 생성된 id를 얻는 것은 하이버네이트가 관리함. 
		// 따라서 단순히 message객체를 저장후 반환만 하면됨
		session.save(message);
		return message;
	}
}

package app.messages.repository;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import app.messages.model.Message;

@Component
public class MessageRepository {
	private final static Log logger = LogFactory.getLog(MessageRepository.class);

	private SessionFactory sessionFactory;

	public MessageRepository(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Message saveMessage(Message message) {
		// openSession() 을 이용해 session 인스턴스를 획득
//		Session session = sessionFactory.openSession();

		// chapter3. 트랜젝션 어드바이저와 공유하는 현재의 하이버네이트 컨텍스트에 있는 세션획득
		Session session = sessionFactory.getCurrentSession();

		// 객체에서 생성된 id를 얻는 것은 하이버네이트가 관리함.
		// 따라서 단순히 message객체를 저장후 반환만 하면됨
		session.save(message);
		return message;
	}

	public List<Message> getMessages() {
		// 하이버네이트 세션 get
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Message";
		Query<Message> query = session.createQuery(hql, Message.class);
		return query.list();
	}

	public void deleteMessage(Message message) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(message);
	}
}

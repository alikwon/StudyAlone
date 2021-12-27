package app.messages.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Component;

import app.messages.model.Message;


@Component
public class MessageRepository_BeforeHibernate {
	private final static Log logger = LogFactory.getLog(MessageRepository_BeforeHibernate.class);
//	public void saveMessage(Message message) {
//		// DB에 메세지를 저장한다
//		log.info("Save message: " + message.getText());
//	}

	/* ===============NamedParameterJdbcTemplate 전===============
	private DataSource dataSource;
	

	public MessageRepository(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Message saveMessage(Message message) {
		Connection c = DataSourceUtils.getConnection(dataSource);
		try {
			String sql = "INSERT INTO MESSAGES (`ID`,`TEXT`,`CREATED_DATE`) VALUE (NULL, ?, ?)";

			// id 값 반환을 위해 Statement.RETURN_GENERATED_KEYS 설정
			PreparedStatement ps = c.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			// SQL 에 필요한 매개변수를 준비한다
			ps.setString(1, message.getText());
			ps.setTimestamp(2, new Timestamp(message.getCreatedDate().getTime()));

			// 실행에 영향을 받은 row의 수 : rowsAffected
			int rowsAffected = ps.executeUpdate();

			if (rowsAffected > 0) {
				// 새로 저장된 메세지 id 가져오기
				ResultSet result = ps.getGeneratedKeys();
				if (result.next()) {
					int id = result.getInt(1);
					return new Message(id, message.getText(), message.getCreatedDate());
				}else {
					logger.error("Failed to retrieve id. No row in result set");
					return null;
				}
			}else {
				//Insert 실패
				return null;
			}
		} catch (SQLException e) {
			logger.error("Failed to save message",e);
			try {
				c.close();
			} catch (SQLException e2) {
				logger.error("Failed to close connection",e);
			}
		} finally {
			DataSourceUtils.releaseConnection(c, dataSource);
		}
		return null;
	}
	 ===============NamedParameterJdbcTemplate 전===============*/
	
	
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	// NamedParameterJdbcTemplate 인스턴스를 인스턴스화 할 수 있도록 스프링에 요청하는 세터메소드
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public Message saveMessage(Message message) {
		GeneratedKeyHolder holder = new GeneratedKeyHolder();
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("text", message.getText());
		params.addValue("createdDate", message.getCreatedDate());
		
		String sql = "INSERT INTO MESSAGES (`ID`,`TEXT`,`CREATED_DATE`) VALUE (NULL, :text, :createdDate)";
		try {
			this.jdbcTemplate.update(sql, params, holder);
		} catch (DataAccessException e) {
			logger.error("Failed to save message", e);
			return null;
		}
		return new Message(holder.getKey().intValue(), message.getText(), message.getCreatedDate());
	}
}

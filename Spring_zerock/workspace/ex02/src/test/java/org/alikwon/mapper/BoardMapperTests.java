package org.alikwon.mapper;

import org.alikwon.domain.BoardVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper mapper;
	
//	@Test
//	public void testGetList() {
//		mapper.getList().forEach(board -> log.info(board));
//	}
//	
//	@Test
//	public void testInsert() {
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성하는글");
//		board.setContent("새로 작성하는 내용");
//		board.setWriter("newbie");z
//		
//		mapper.insert(board);
//		log.info(board);
//	}
//	@Test
//	public void testInsertSelectKey() {
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성하는글 select Key");
//		board.setContent("새로 작성하는 내용 select Key");
//		board.setWriter("newbie");
//		
//		mapper.insertSelectKey(board);
//		log.info(board);
//	}
//	
//	@Test
//	public void testRead() {
//		//존재하는 게시물 번호로 테스트
//		BoardVO board = mapper.read(12L);
//		
//		log.info(board);
//	}
//	@Test
//	public void testDelete() {
//		log.info("DELETE COUNT: " + mapper.delete(13L));
//	}
	@Test
	public void testUpdate() {
		BoardVO board = new BoardVO();
		board.setBno(7L);
		board.setTitle("수정된 제목");
		board.setContent("수정된 내용");
		board.setWriter("user00");
		
		int cnt = mapper.update(board);
		log.info("UPDATE COUNT: " + cnt);
	}
	
}

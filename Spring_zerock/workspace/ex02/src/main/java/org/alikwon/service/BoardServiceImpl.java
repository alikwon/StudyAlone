package org.alikwon.service;

import java.util.List;

import org.alikwon.domain.BoardVO;
import org.alikwon.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{

	//Spring 4.3이상에서 자동처리
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		log.info("register..........."+board);
		mapper.insertSelectKey(board);
	}

	@Override
	public List<BoardVO> getList(){
		log.info("getList..............");
		return mapper.getList();
	}
	
	@Override
	public BoardVO get(Long bno) {
		
		log.info("get............."+bno);
		
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		
		log.info("modify.............."+board);
		
		return mapper.update(board)==1;
	}

	@Override
	public boolean remove(Long bno) {
		
		log.info("remove.............."+bno);
		
		return mapper.delete(bno)==1;
	}

}

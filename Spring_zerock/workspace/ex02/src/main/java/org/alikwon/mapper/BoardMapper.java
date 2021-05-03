package org.alikwon.mapper;

import java.util.List;

import org.alikwon.domain.BoardVO;

public interface BoardMapper {
//	@Select("select * from tbl_board where bno>0")
	public List<BoardVO> getList();
	
	public void insert(BoardVO board);
	
	//시퀀스 받아오는 insert
	public void insertSelectKey(BoardVO board);
	
	//insert 된 데이터 조회
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
}

package spring.mvc.board.service;

import java.util.List;

import spring.mvc.board.dto.BoardDto;
import spring.mvc.board.dto.SelectBoardDto;
import spring.mvc.test.Pagination;

public interface BoardService {

	void create(BoardDto dto);

	BoardDto read(int bid);

	void update(BoardDto dto);

	void delete(int bid);
	
	List<BoardDto> getBoardList(SelectBoardDto selectBoardDto);
	
	public int getBoardListCnt(SelectBoardDto selectBoardDto);
}

package spring.mvc.board.dao;

import java.util.List;

import spring.mvc.board.dto.BoardDto;
import spring.mvc.board.dto.SelectBoardDto;
import spring.mvc.test.Pagination;

public interface BoardDao {

	void create(BoardDto dto);

	BoardDto read(int bid);

	void update(BoardDto dto);

	void delete(int bid);
	
	public int getBoardListCnt(SelectBoardDto selectBoardDto);

	List<BoardDto> getBoardList(SelectBoardDto selectBoardDto);

}

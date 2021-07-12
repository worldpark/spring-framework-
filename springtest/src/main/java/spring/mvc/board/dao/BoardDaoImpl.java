package spring.mvc.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import spring.mvc.board.dto.BoardDto;
import spring.mvc.board.dto.SelectBoardDto;
import spring.mvc.test.Pagination;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Inject
	SqlSession sqlsession;

	//게시물 생성
	@Override
	public void create(BoardDto dto) {
		sqlsession.insert("board.insert", dto);
	}

	//게시물 내용
	@Override
	public BoardDto read(int bid) {
		return sqlsession.selectOne("board.view", bid);
	}

	//게시물 수정처리
	@Override
	public void update(BoardDto dto) {
		sqlsession.update("board.update", dto);
	}

	//게시물 삭제
	@Override
	public void delete(int bid) {
		sqlsession.delete("board.delete", bid);
	}

	//게시판 게시물 수
	@Override
	public int getBoardListCnt(SelectBoardDto selectBoardDto) {
		return sqlsession.selectOne("board.getBoardListCnt", selectBoardDto);
	}

	//게시판 게시물 목록
	@Override
	public List<BoardDto> getBoardList(SelectBoardDto selectBoardDto) {
		return sqlsession.selectList("board.paging", selectBoardDto);
	}

}

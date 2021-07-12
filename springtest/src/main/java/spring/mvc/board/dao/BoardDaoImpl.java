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

	//�Խù� ����
	@Override
	public void create(BoardDto dto) {
		sqlsession.insert("board.insert", dto);
	}

	//�Խù� ����
	@Override
	public BoardDto read(int bid) {
		return sqlsession.selectOne("board.view", bid);
	}

	//�Խù� ����ó��
	@Override
	public void update(BoardDto dto) {
		sqlsession.update("board.update", dto);
	}

	//�Խù� ����
	@Override
	public void delete(int bid) {
		sqlsession.delete("board.delete", bid);
	}

	//�Խ��� �Խù� ��
	@Override
	public int getBoardListCnt(SelectBoardDto selectBoardDto) {
		return sqlsession.selectOne("board.getBoardListCnt", selectBoardDto);
	}

	//�Խ��� �Խù� ���
	@Override
	public List<BoardDto> getBoardList(SelectBoardDto selectBoardDto) {
		return sqlsession.selectList("board.paging", selectBoardDto);
	}

}

package spring.mvc.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import spring.mvc.board.dao.BoardDao;
import spring.mvc.board.dto.BoardDto;
import spring.mvc.board.dto.SelectBoardDto;
import spring.mvc.test.Pagination;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	BoardDao boardDao;

	//게시물생성
	@Override
	public void create(BoardDto dto) {
		String subject = dto.getSubject();
		String content = dto.getContent();
		String tradegoods = dto.getTradegoods();
		
		//태그문자, 공백 처리 '< => &lt', '> => &gt', '공백 => &nbsp'
		subject = subject.replace("<", "&lt;");
		subject = subject.replace(">", "&gt;");
		subject = subject.replace(" ", "&nbsp;&nbsp;");

		content = content.replace("<", "&lt;");
		content = content.replace(">", "&gt;");
		content = content.replace(" ", "&nbsp;&nbsp;");

		tradegoods = tradegoods.replace("<", "&lt;");
		tradegoods = tradegoods.replace(">", "&gt;");
		tradegoods = tradegoods.replace(" ", "&nbsp;&nbsp;");
		
		dto.setSubject(subject);
		dto.setContent(content);
		dto.setTradegoods(tradegoods);
		
		boardDao.create(dto);
	}

	//게시물 내용
	@Override
	public BoardDto read(int bid) {
		return boardDao.read(bid);
	}

	//게시물 수정처리
	@Override
	public void update(BoardDto dto) {
		boardDao.update(dto);
	}

	//게시물삭제
	@Override
	public void delete(int bid) {
		boardDao.delete(bid);
	}

	//게시판 페이징 목록 수
	@Override
	public int getBoardListCnt(SelectBoardDto selectBoardDto) {
		return boardDao.getBoardListCnt(selectBoardDto);
	}

	//게시판 페이징 목록
	@Override
	public List<BoardDto> getBoardList(SelectBoardDto selectBoardDto) {
		return boardDao.getBoardList(selectBoardDto);
	}

}

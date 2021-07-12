package spring.mvc.trade.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import spring.mvc.test.Pagination;
import spring.mvc.trade.dto.SelectTradeDto;
import spring.mvc.trade.dto.TradeDto;

@Repository
public class TradeDaoImpl implements TradeDao {

	@Inject
	SqlSession sqlsession;

	//�ŷ���ûó��
	@Override
	public void rqtrade(TradeDto dto) {
		sqlsession.insert("trade.rqtrade", dto);
		sqlsession.update("trade.payment", dto);
	}

	//�����ڰ� �� �Խù����� �ŷ���û�ϰų� �ŷ������� �ľ�
	@Override
	public int rqcount(TradeDto tradeDto) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("trade.rqcount", tradeDto);
	}

	//�ŷ����ó��(�ŷ���û, �ŷ��� �϶�)
	@Override
	public void cancletrade(TradeDto trade) {
		// TODO Auto-generated method stub
		sqlsession.delete("trade.cancletrade", trade);
		sqlsession.update("trade.refund", trade);
	}

	//�ŷ���û����
	@Override
	public void approve(int tid) {
		// TODO Auto-generated method stub
		sqlsession.update("trade.approve", tid);
	}

	//�ŷ��� ui���� ������
	@Override
	public TradeDto read(int tid) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("trade.read", tid);
	}

	//�ŷ��Ϸ�ó��
	@Override
	public void fintrade(TradeDto dto) {
		// TODO Auto-generated method stub
		sqlsession.update("trade.fintrade", dto);
		sqlsession.update("trade.finproc1", dto);
		sqlsession.update("trade.finproc2", dto);
	}

	// ����¡����Ʈ�Խù� ��(�ŷ��Ϸ�)
	@Override
	public int getTradeListCntaft(String id) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("trade.getBoardListCntaft", id);
	}

	// ����¡����Ʈ(�ŷ��Ϸ�)
	@Override
	public List<TradeDto> getTradeListaft(Pagination pagination, String id) {
		// TODO Auto-generated method stub
		
		SelectTradeDto dto = new SelectTradeDto();
		
		System.out.println("Dao id : " + id);
		
		dto.setPagination(pagination);
		dto.setSelectstring(id);
		
		return sqlsession.selectList("trade.pagingaft", dto);
	}

	//����¡����Ʈ�Խù� ��(�ŷ���)
	@Override
	public int getTradeListCnting(String id) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("trade.getBoardListCnting", id);
	}

	//����¡����Ʈ(�ŷ���)
	@Override
	public List<TradeDto> getTradeListing(Pagination pagination, String id) {
		
		SelectTradeDto dto = new SelectTradeDto();
		
		System.out.println("Dao id : " + id);
		
		dto.setPagination(pagination);
		dto.setSelectstring(id);
		
		return sqlsession.selectList("trade.paginging", dto);
	}

	// ����¡����Ʈ�Խù� ��(�ŷ���û)
	@Override
	public int getTradeListCntbefore(String id) {
		// TODO Auto-generated method stub
		return sqlsession.selectOne("trade.getBoardListCntbefore", id);
	}

	// ����¡����Ʈ(�ŷ���û)
	@Override
	public List<TradeDto> getTradeListbefore(Pagination pagination, String id) {
		
		SelectTradeDto dto = new SelectTradeDto();
		
		System.out.println("Dao id : " + id);
		
		dto.setPagination(pagination);
		dto.setSelectstring(id);
		
		return sqlsession.selectList("trade.pagingbefore", dto);
	}

}

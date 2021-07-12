package spring.mvc.trade.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import spring.mvc.test.Pagination;
import spring.mvc.trade.dao.TradeDao;
import spring.mvc.trade.dto.TradeDto;

@Service
public class TradeServiceImpl implements TradeService {

	@Inject
	TradeDao tradedao;

	//�ŷ���ûó��
	@Override
	public void rqtrade(TradeDto dto) {
		tradedao.rqtrade(dto);
	}

	//�����ڰ� �� �Խù����� �ŷ���û�ϰų� �ŷ������� �ľ�
	@Override
	public int rqcount(int bid, String buyerid, TradeDto TradeDto) {
		
		TradeDto.setBid(bid);
		TradeDto.setBuyerid(buyerid);
		
		return tradedao.rqcount(TradeDto);
	}

	//�ŷ����ó��(�ŷ���û, �ŷ��� �϶�)
	@Override
	public void cancletrade(TradeDto trade) {
		// TODO Auto-generated method stub
		tradedao.cancletrade(trade);
	}

	//�ŷ���û����
	@Override
	public void approve(int tid) {
		tradedao.approve(tid);
	}

	//�ŷ��� ui���� ������
	@Override
	public TradeDto read(int tid) {
		// TODO Auto-generated method stub
		return tradedao.read(tid);
	}

	//�ŷ��Ϸ�ó��
	@Override
	public void fintrade(TradeDto dto) {
		// TODO Auto-generated method stub
		tradedao.fintrade(dto);
	}

	
	// ����¡����Ʈ(�ŷ��Ϸ�)
	@Override
	public List<TradeDto> getTradeListaft(Pagination pagination, String id) {
		// TODO Auto-generated method stub
		return tradedao.getTradeListaft(pagination, id);
	}

	// ����¡����Ʈ�Խù� ��(�ŷ��Ϸ�)
	@Override
	public int getTradeListCntaft(String id) {
		// TODO Auto-generated method stub
		return tradedao.getTradeListCntaft(id);
	}

	//����¡����Ʈ(�ŷ���)
	@Override
	public List<TradeDto> getTradeListing(Pagination pagination, String id) {
		// TODO Auto-generated method stub
		return tradedao.getTradeListing(pagination, id);
	}

	//����¡����Ʈ�Խù� ��(�ŷ���)
	@Override
	public int getTradeListCnting(String id) {
		// TODO Auto-generated method stub
		return tradedao.getTradeListCnting(id);
	}

	// ����¡����Ʈ(�ŷ���û)
	@Override
	public List<TradeDto> getTradeListbefore(Pagination pagination, String id) {
		// TODO Auto-generated method stub
		return tradedao.getTradeListbefore(pagination, id);
	}

	// ����¡����Ʈ�Խù� ��(�ŷ���û)
	@Override
	public int getTradeListCntbefore(String id) {
		// TODO Auto-generated method stub
		return tradedao.getTradeListCntbefore(id);
	}

}

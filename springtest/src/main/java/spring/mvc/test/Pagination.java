package spring.mvc.test;

public class Pagination {

	
	private int page;				//���� ������ ��ȣ
	
	private int listCnt;			//�� �Խù� ��
	private int range;				//�� �������� ������ �Խù� ����
	private int startList;			//�� ȭ�鿡 ǥ�õǴ� �Խù� ����
	private int listSize = 5;		//�� ȭ�鿡 ǥ�õǴ� ������Ʈ�� ������
	

	private int pageCnt;			//��ü������ ��
	private int rangeSize = 10;		//�� ȭ�鿡 ����� ������ ��ȣ ��
	private int endPage;			//�� ȭ�鿡 ��µǴ� ������ ��ȣ�� ������
	private int startPage;			//�� ȭ�鿡 ��µǴ� ������ ��ȣ�� ����
	
	private boolean prev;			//���� ������ ǥ�ÿ���
	private boolean next;			//���� ������ ǥ�ÿ���

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public int getRangeSize() {
		return rangeSize;
	}

	public void setRangeSize(int rangeSize) {
		this.rangeSize = rangeSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public int getListCnt() {
		return listCnt;
	}

	public void setListCnt(int listCnt) {
		this.listCnt = listCnt;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getStartList() {
		return startList;
	}

	public void setStartList(int startList) {
		this.startList = startList;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public void pageInfo(int page, int range, int listCnt) {
		this.page = page;
		this.range = range;
		this.listCnt = listCnt;

		System.out.println("listCnt : " + listCnt);
		System.out.println("listSize : " + listSize);
		// ��ü ��������
		this.pageCnt = (int)(Math.ceil((double)listCnt / listSize));

		// ���� ������
		this.startPage = (range - 1) * rangeSize + 1;

		// �� ������
		this.endPage = range * rangeSize;

		// �Խ��� ���۹�ȣ
		this.startList = (page - 1) * listSize;

		// ���� ��ư ����
		this.prev = range == 1 ? false : true;

		// ���� ��ư ����
		this.next = endPage > pageCnt ? false : true;
		
		System.out.println("pageCnt : " + this.pageCnt);
		if (this.endPage >= this.pageCnt) {
			this.endPage = this.pageCnt;
			this.next = false;
		}
	}

}

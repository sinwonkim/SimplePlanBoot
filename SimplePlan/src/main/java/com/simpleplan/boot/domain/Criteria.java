package com.simpleplan.boot.domain;

public class Criteria { // 검색 기준
	
	private int page; // 페이지 번호 
	private int perPageNum; // 페이지당 보여줄 개수
	
	public Criteria( ) {
		this.page = 1; // 페이지 번호 1로 지정
		this.perPageNum = 10; // 리스트당 데이터수 10
	}

	public void setPage(int page) { // set 메소드 사용해서 사용자 고의로 잘못 입력할 수 있는 값에 대한 데이터를 조정용도
		if(page <= 0 ) {
			this.page = 1;
			return;
		}
		
		this.page = page;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 || perPageNum > 100 ) {
			this.perPageNum = 10;
			return;
		}
		
		this.perPageNum = perPageNum;
		
	}
	
	public int getPage() {
		return page;
	}

	//MyBatis의 SQL Mapper에는 공통적인 규칙이 하나 존재하는데 그것은 #{page}와 같은 파라미터를 사용할 때 
	// 내부적으로 page 속성의 getter에 해당하는 getPage()메소드를 호출한다는 점 
	// method for MyBatis SQL Mapper //XML 매퍼에서 사용하는 getter를 제공
	
	public int getPageStart() { // getPageStart()는 limit 구문에서 시작 위치를 지정할 떄 사용할 것 
		
		return (this.page - 1) * perPageNum;
	}
	
	// method for MyBatis SQL Mapper
	public int getPerPageNum() { // getPerPageNum()은  limit 뒤의 숫자를 의미해서 한 페이지당 보여지는 개수를 의미
		
		return this.perPageNum;
	}

	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	
	
}

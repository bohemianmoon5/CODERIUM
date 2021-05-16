package com.db;

public class Datainfo {
	// 공통컬럼 id
	private String id; //id primary key!
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	// 회원관리 변수
	private int Pw; //비밀번호
	private String name; //이름
	private String gender; //성별
	private String birth; //생일
	private String mobile; // 핸드폰번호
	private String dream; //꿈

	// 회원관리 getter setter
	public int getPw() {
		return Pw;
	}
	public void setPw(int pw) {
		Pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDream() {
		return dream;
	}
	public void setDream(String dream) {
		this.dream = dream;
	}
	
// 예약관리 db
	private String r_start; // 시작시간
	private String r_use; // 사용시간
	private String r_end; // 종료시간
	private String seat; // 좌석표

	// 예약관리 getter setter
	public String getR_start() {
		return r_start;
	}
	public void setR_start(String r_start) {
		this.r_start = r_start;
	}
	public String getR_use() {
		return r_use;
	}
	public void setR_use(String r_use) {
		this.r_use = r_use;
	}
	public String getR_end() {
		return r_end;
	}
	public void setR_end(String r_end) {
		this.r_end = r_end;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	

// 결제 db 좌석표만 예약db랑 변수만 공유
	private String start; // 시작시간
	private String use; // 사용시간
	private String end; // 종료시간
	private String pi; // 상품정보
	private String pm; // 결제방법
	private int ap; // 결제금액

	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	public String getPi() {
		return pi;
	}
	public void setPi(String pi) {
		this.pi = pi;
	}
	public String getPm() {
		return pm;
	}
	public void setPm(String pm) {
		this.pm = pm;
	}
	public int getAp() {
		return ap;
	}
	public void setAp(int ap) {
		this.ap = ap;
	}


	
}

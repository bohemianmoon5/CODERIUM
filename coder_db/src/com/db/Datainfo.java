package com.db;

public class Datainfo {
	// �����÷� id
	private String id; //id primary key!
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	// ȸ������ ����
	private int Pw; //��й�ȣ
	private String name; //�̸�
	private String gender; //����
	private String birth; //����
	private String mobile; // �ڵ�����ȣ
	private String dream; //��

	// ȸ������ getter setter
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
	
// ������� db
	private String r_start; // ���۽ð�
	private String r_use; // ���ð�
	private String r_end; // ����ð�
	private String seat; // �¼�ǥ

	// ������� getter setter
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
	

// ���� db �¼�ǥ�� ����db�� ������ ����
	private String start; // ���۽ð�
	private String use; // ���ð�
	private String end; // ����ð�
	private String pi; // ��ǰ����
	private String pm; // �������
	private int ap; // �����ݾ�

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

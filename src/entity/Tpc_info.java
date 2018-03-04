package entity;

public class Tpc_info {
	private String specialtyNo;
	private int grade;
	private String cno;
	private String cname;
	private double ccredit;
	private int score;
	private String sno;
	
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getSpecialtyNo() {
		return specialtyNo;
	}
	public void setSpecialtyNo(String specialtyNo) {
		this.specialtyNo = specialtyNo;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public double getCcredit() {
		return ccredit;
	}
	public void setCcredit(double ccredit) {
		this.ccredit = ccredit;
	}
	
}

package entity;

public class Sc_Course {
	private String sno;
	private String cno;
	private int grade;
	private String cname;
	private double ccredit;				
	public String print() {
		return " "+cno+" "+String.valueOf(grade)+" "+cname;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getCno() {
		return cno;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
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

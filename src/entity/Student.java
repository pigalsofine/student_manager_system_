package entity;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Student {
	private String sno;
	private String sname;
	private String ssex;
	private String clsNO;
	private int enterYear;
	private int register;
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public String getClsNO() {
		return clsNO;
	}
	public void setClsNO(String clsNO) {
		this.clsNO = clsNO;
	}
	public int getEnterYear() {
		return enterYear;
	}
	public void setEnterYear(int enterYear) {
		this.enterYear = enterYear;
	}
	public int getRegister() {
		return register;
	}
	public void setRegister(int register) {
		this.register = register;
	}
	
}

package entity;

import javax.enterprise.inject.New;

public class Student_basic_info {
	private String sno;
	private String sname;
	private String ssex;
	private String clsNO;
	private int enterYear;
	private int register;
	private String clsno;
	private String clsname;
	private String specialtyNo;
	private int grade;
	private String director;
	private String specialtyName;
	private String faculty;
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
	public String getClsno() {
		return clsno;
	}
	public void setClsno(String clsno) {
		this.clsno = clsno;
	}
	public String getClsname() {
		return clsname;
	}
	public void setClsname(String clsname) {
		this.clsname = clsname;
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
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getSpecialtyName() {
		return specialtyName;
	}
	public void setSpecialtyName(String specialtyName) {
		this.specialtyName = specialtyName;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String print(){
		return sno+" "+sname+" "+ssex+" "+clsNO+" "+String.valueOf(enterYear)
				+" "+String.valueOf(register);
	}
}

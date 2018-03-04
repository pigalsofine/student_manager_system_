package entity;

public class Awarding {
	private String sno;
	private String prize;
	private String adate;
	
	public String print() {
		return sno+" "+prize+" "+adate;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getPrize() {
		return prize;
	}
	public void setPrize(String prize) {
		this.prize = prize;
	}
	public String getAdate() {
		return adate;
	}
	public void setAdate(String adate) {
		this.adate = adate;
	}
	
}

package entity;

public class Punishment {
	private String sno;
	private String punish;
	private String pdate;
	public String print() {
		return sno+" "+punish+" "+pdate;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getPunish() {
		return punish;
	}
	public void setPunish(String punish) {
		this.punish = punish;
	}
	public String getPdate() {
		return pdate;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	
}

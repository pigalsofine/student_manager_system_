package entity;

public class Check_up {
	private String Sno;
	private double height;
	private double weight;
	private int tvc;
	
	public String print(){
		return Sno+" "+String.valueOf(height)+" "+String.valueOf(weight)
		+" "+String.valueOf(tvc);
	}
	
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getTvc() {
		return tvc;
	}
	public void setTvc(int tvc) {
		this.tvc = tvc;
	}
	
}

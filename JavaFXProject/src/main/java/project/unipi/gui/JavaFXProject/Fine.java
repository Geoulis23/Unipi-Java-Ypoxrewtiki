package project.unipi.gui.JavaFXProject;

public class Fine {
	//Fields
	private int fineID;
	private int loanID;
	private int fineAmount;
	private boolean paid;
	
	//Constructor
	Fine(int fineID, int loanID, int fineAmount, boolean paid){
		this.setfineID(fineID);
		this.setloanID(loanID);
		this.setfineAmount(fineAmount);
		this.setpaid(paid);
	}
	
	//Setters&Getters
	public void setfineID(int fineID) {
		this.fineID = fineID;
	}
	public int getfineID() {
		return this.fineID;
	}
	public void setloanID(int loanID) {
		this.loanID = loanID;
	}
	public int getloanID() {
		return this.loanID;
	}
	public void setfineAmount(int fineAmount) {
		this.fineAmount = fineAmount;
	}
	public int getfineAmount() {
		return this.fineAmount;
	}
	public void setpaid(boolean paid) {
		this.paid = paid;
	}
	public boolean getpaid() {
		return this.paid;
	}
	
}

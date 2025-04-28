package project.unipi.gui.JavaFXProject;
import java.time.LocalDate;

public class Loan {
	private int loanID;
	private String loaningStud;
	private String loaningBook;
	private LocalDate loanDate; //SOS NA DW AN MPORW NA TO KANW PERIPOU OPWS TH C!!!!!!!!
	private int returnDeadline;
	private LocalDate returnDate;
	private boolean delay;
	private String status;
	
	//Constructor
	Loan(int loanID, String loaningStud, String LoaningBook, LocalDate loanDate, int returnDeadline, LocalDate returnDate, boolean delay, String status){
		this.setLoanID(loanID);
		this.setLoaningStud(loaningStud);
		this.setLoaningBook(LoaningBook);
		this.setLoanDate(loanDate);
		this.setReturnDeadline(returnDeadline);
		this.setReturnDate(returnDate);
		this.setDelay(delay);
		this.setStatus(status);
	}
	
	//Setters & Getters
	public void setLoanID(int loanID) {
		this.loanID = loanID;
	}
	public int getLoanID() {
		return this.loanID;
	}
	public void setLoaningStud(String loaningStud) {
		this.loaningStud = loaningStud;
	}
	public String getLoaningStud() {
		return this.loaningStud;
	}
	public void setLoaningBook(String loaningBook) {
		this.loaningBook = loaningBook;
	}
	public String getLoaningBook() {
		return this.loaningBook;
	}
	public void setLoanDate(LocalDate loanDate) {
		this.loanDate = loanDate;
	}
	public LocalDate getLoanDate() {
		return this.loanDate;
	}
	public void setReturnDeadline(int returnDeadline) {
		this.returnDeadline = returnDeadline;
	}
	public int getReturnDeadline() {
		return this.returnDeadline;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	public LocalDate getReturnDate() {
		return this.returnDate;
	}
	public void setDelay(boolean delay) {
		this.delay = delay;
	}
	public boolean getDelay() {
		return this.delay;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus() {
		return this.status;
	}
}

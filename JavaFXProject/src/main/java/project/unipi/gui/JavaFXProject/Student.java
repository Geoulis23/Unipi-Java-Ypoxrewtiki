package project.unipi.gui.JavaFXProject;

public class Student extends User {
	//Additional Fields
	private String AM;
	private String studyDep;
	private int maxLoan;
	
	//Constructor
	Student(int id, String name, String surname, int yob, String tel, String email, String AM, String studyDep) {
		super(id, name, surname, yob, tel, email);
		this.setAM(AM);
		this.setStudyDep(studyDep);
		this.setMaxLoan(5);
	}
	
	//Setters & Getters
	public void setAM(String AM) {
		this.AM = AM;
	}
	public String getAM() {
		return this.AM;
	}
	public void setStudyDep(String studyDep) {
		this.studyDep = studyDep;
	}
	public String getStudyDep() {
		return this.studyDep;
	}
	public void setMaxLoan(int maxLoan) {
		this.maxLoan = maxLoan;
	}
	public int getMaxLoan() {
		return this.maxLoan;
	}
}

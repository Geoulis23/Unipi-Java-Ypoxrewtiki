package project.unipi.gui.JavaFXProject;

public class Librarian extends User {
	//Additional Fields
	private String laborDep;
	private String eduLevel;

	//Constructor
	public Librarian(int id, String name, String surname, int yob, String tel, String email, String laborDep, String eduLevel) {
		super(id, name, surname, yob, tel, email);
		this.setLaborDep(laborDep);
		this.setEduLevel(eduLevel);
	}
	
	//Setters & Getters
	public void setLaborDep(String laborDep) {
		this.laborDep = laborDep;
	}
	public String getLaborDep() {
		return this.laborDep;
	}
	public void setEduLevel(String eduLevel) {
		this.eduLevel = eduLevel;
	}
	public String getEduLevel() {
		return this.eduLevel;
	}

}

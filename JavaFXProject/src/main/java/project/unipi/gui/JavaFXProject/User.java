package project.unipi.gui.JavaFXProject;

public class User {
	//Fields
	private int id;
	private String name;
	private String surname;
	private int yob;
	private String tel;
	private String email;
	
	//User Constructor
	User(int id, String name, String surname, int yob, String tel, String email){
		this.setID(id);
		this.setName(name);
		this.setSurname(surname);
		this.setYOB(yob);
		this.setTEL(tel);
		this.setEmail(email);
	}
	
	//Setters & Getters
	public void setID(int id) {
		this.id = id;
	}
	public int getID() {
		return this.id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getSurname() {
		return this.surname;
	}
	public void setYOB(int yob) {
		this.yob = yob;
	}
	public int getYOB() {
		return this.yob;
	}
	public void setTEL(String tel) {
		this.tel = tel;
	}
	public String getTEL() {
		return this.tel;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail() {
		return this.email;
	}
}

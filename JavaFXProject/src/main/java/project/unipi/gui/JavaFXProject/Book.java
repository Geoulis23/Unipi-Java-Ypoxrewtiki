package project.unipi.gui.JavaFXProject;

public class Book {
	//Fields
	private String ISBN;
	private String title;
	private String author;
	private String publisher;
	private int yop;
	private String cat;
	private boolean avail;
	
	//Constructor
	Book(String ISBN, String title, String author, String publisher, int yop, String cat, boolean avail){
		this.setISBN(ISBN);
		this.setTitle(title);
		this.setAuthor(author);
		this.setPublisher(publisher);
		this.setYOP(yop);
		this.setCAT(cat);
		this.setAvail(avail);
	}
	
	//Setters & Getters
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public String getISBN() {
		return this.ISBN;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return this.title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAuthor() {
		return this.author;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublisher() {
		return this.publisher;
	}
	public void setYOP(int yop) {
		this.yop = yop;
	}
	public int getYOP() {
		return this.yop;
	}
	public void setCAT(String cat) {
		this.cat = cat;
	}
	public String getCAT() {
		return this.cat;
	}
	public void setAvail(boolean avail) {
		this.avail = avail;
	}
	public boolean getAvail() {
		return this.avail;
	}
}

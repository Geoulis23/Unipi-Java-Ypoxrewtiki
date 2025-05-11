package project.unipi.gui.JavaFXProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class BookManagementSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
	//Flow Pane
	FlowPane btnFlowPane;
	//Grid Pane
	GridPane rootGridPane, inputGridPane;
	//Buttons
	Button newBtn, updateBtn, delBtn, backBtn, clearBtn;
	//Labels
	Label ISBNLbl, titleLbl, authorLbl, publisherLbl, yopLbl, catLbl, availLbl;
	//Text Fields
	TextField ISBNField, titleField, authorField, publisherField, yopField, catField;
	//Check Box
	CheckBox availCheckBox;
	//Table View
	TableView<Book> bookTableView;
	//Book list
	ArrayList<Book> books;
	//Alert
	Alert errorAlert = new Alert(AlertType.ERROR);
	Alert confAlert = new Alert(AlertType.CONFIRMATION);
	//ButtonTypes
	ButtonType buttonYes, buttonNo;
	
	public BookManagementSceneCreator(double width, double height) {
		super(width, height);
		//Pane setups
		rootGridPane = new GridPane();
		inputGridPane = new GridPane();
		btnFlowPane = new FlowPane();
		//Button initialization
		newBtn = new Button("Add New Book");
		updateBtn = new Button("Edit Book Fields");
		delBtn = new Button("Delete Book");
		backBtn = new Button("Back");
		clearBtn = new Button("Clear");
		//Connect Buttons with handler
		newBtn.setOnMouseClicked(this);
		updateBtn.setOnMouseClicked(this);
		delBtn.setOnMouseClicked(this);
		backBtn.setOnMouseClicked(this);
		clearBtn.setOnMouseClicked(this);
		//ButtonType initialization
		buttonYes = new ButtonType("Yes");
		buttonNo = new ButtonType("No");
		//Connect ButtonTypes with alert
		confAlert.getButtonTypes().setAll(buttonYes, buttonNo);
		//Label Initialization
		ISBNLbl = new Label("ISBN: ");
		titleLbl = new Label("Title: ");
		authorLbl = new Label("Author: ");
		publisherLbl = new Label("Publisher: ");
		yopLbl = new Label("Year of Publish: ");
		catLbl = new Label("Category: ");
		availLbl = new Label("Available: ");
		//Textfield setup
		ISBNField = new TextField();
		titleField = new TextField();
		authorField = new TextField();
		publisherField = new TextField();
		yopField = new TextField();
		catField = new TextField();
		//availField = new TextField();
		//CheckBox setup
		availCheckBox = new CheckBox();
		//TableView setup
		bookTableView = new TableView<>();
		//Alert Customization
		errorAlert.setTitle("Error Occurred");
		errorAlert.setHeaderText(null);
		confAlert.setTitle("Confirmation Alert");
//		confAlert.setHeaderText("The input you gave contains numbers");
		confAlert.setContentText("You sure you want to continue?");
		//Customize Flowpane
		btnFlowPane.setHgap(15);
		btnFlowPane.getChildren().add(newBtn);
		btnFlowPane.getChildren().add(updateBtn);
		btnFlowPane.getChildren().add(delBtn);
		btnFlowPane.setAlignment(Pos.BOTTOM_CENTER);
		//Customize Input Gridpane
		inputGridPane.setAlignment(Pos.TOP_RIGHT);
		inputGridPane.setHgap(10);
		inputGridPane.setVgap(10);
		inputGridPane.add(ISBNLbl, 0, 0);
		inputGridPane.add(ISBNField, 1, 0);
		inputGridPane.add(titleLbl, 0, 1);
		inputGridPane.add(titleField, 1, 1);
		inputGridPane.add(authorLbl, 0, 2);
		inputGridPane.add(authorField, 1, 2);
		inputGridPane.add(publisherLbl, 0, 3);
		inputGridPane.add(publisherField, 1, 3);
		inputGridPane.add(yopLbl, 0, 4);
		inputGridPane.add(yopField, 1, 4);
		inputGridPane.add(catLbl, 0, 5);
		inputGridPane.add(catField, 1, 5);
		inputGridPane.add(availLbl, 0, 6);
		inputGridPane.add(availCheckBox, 1, 6);
		inputGridPane.add(clearBtn, 1, 8);
		//Customize Root GridPane
		rootGridPane.setVgap(10);
		rootGridPane.setHgap(10);
		rootGridPane.add(inputGridPane, 1, 0);
		rootGridPane.add(bookTableView, 0, 0);
		rootGridPane.add(btnFlowPane, 0, 2);
		rootGridPane.add(backBtn, 1, 2);
		//Customize Tableview 
		TableColumn<Book, String> ISBNColumn = new TableColumn<>("ISBN");
		ISBNColumn.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
		bookTableView.getColumns().add(ISBNColumn);
		
		TableColumn<Book, String> titleColumn = new TableColumn<>("Title");
		titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
		bookTableView.getColumns().add(titleColumn);
		
		TableColumn<Book, String> authorColumn = new TableColumn<>("Author");
		authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
		bookTableView.getColumns().add(authorColumn);
		
		TableColumn<Book, String> publisherColumn = new TableColumn<>("Publisher");
		publisherColumn.setCellValueFactory(new PropertyValueFactory<>("publisher"));
		bookTableView.getColumns().add(publisherColumn);
		
		TableColumn<Book, String> yopColumn = new TableColumn<>("Year of Publish");
		yopColumn.setCellValueFactory(new PropertyValueFactory<>("yop"));
		bookTableView.getColumns().add(yopColumn);
		
		TableColumn<Book, String> catColumn = new TableColumn<>("Category");
		catColumn.setCellValueFactory(new PropertyValueFactory<>("cat"));
		bookTableView.getColumns().add(catColumn);
		
		TableColumn<Book, String> availColumn = new TableColumn<>("Available");
		availColumn.setCellValueFactory(new PropertyValueFactory<>("avail"));
		bookTableView.getColumns().add(availColumn);
		
		bookTableView.setOnMouseClicked(this); //Attach handler
		
		//Initialize the ArrayList for books
		books = new ArrayList<>();
		books.add(new Book("978-960-453-709-4", "Harry Potter and the Chamber of Secrets", "J.K Rowling", "Scholastic Inc", 1999, "Fantasy", true));
        books.add(new Book("233-890-213-234-8", "The Hunger Games", "Suzanne Collins", "Scholastic Inc", 2008, "Action/Drama", false));
        books.add(new Book("358-666-437-895-3", "The Little Prince", "Antoine de Saint-Exupéry", "Reynal & Hitchcock", 1943, "Fantasy", true));
        books.add(new Book("577-230-433-125-4", "The Lord of the rings", "J.R.R. Tolkien", "Houghton Mifflin Harcourt", 2001, "Fantasy", true));
        books.add(new Book("344-450-853-009-1", "Don Quixote", "Miguel de Cervantes", "Francisco de Robles", 1605, "Tragedy", false));
        books.add(new Book("245-326-783-769-6", "Pride and Prejudice", "Jane Austen", "T. Egerton, Whitehall", 1813, "Romantic", true));
        books.add(new Book("921-320-124-421-8", "War And Peace", "Leo Tolstoy", "Oxford University Press", 1867, "Historical", true));
        books.add(new Book("654-230-218-746-0", "Great Expectations", "Charles Dickens", "Simon & Schuster", 1861, "Mystery", false));
        books.add(new Book("912-135-473-127-8", "To Kill A Mockingbird", "Harper Lee", "HarperCollins", 1960, "Gothic", true));
        books.add(new Book("125-789-233-726-2", "Moby-Dick", "Herman Melville", "Richard Bentley (United Kingdom) Harper & Brothers (U.S.)", 1851, "Adventure", true));
        tableSync();
	}

	@Override
	public void handle(MouseEvent event) {
		if(event.getSource() == backBtn) {
			App.stage.setTitle("UniPi Library");
			App.stage.setScene(App.mainScene);
		}
		if(event.getSource() == clearBtn) {
			clearTextFields();
		}
		if(event.getSource() == newBtn) { // to isbn na einai mono ari8moi, author k publisher mono grammata, otan den exoun input ta pedia na mhn ftiaxnei biblio
			if(ISBNField.getText().equals("") || titleField.getText().equals("") || authorField.getText().equals("") || publisherField.getText().equals("") || yopField.getText().equals("") || catField.getText().equals("")) {
				errorAlert.setContentText("Field(s) blank. Make sure you've filled out everything");
				errorAlert.show();
			}
			else {
				int yop = 0;
				String ISBN = "", title = "", author = "" , publisher = "", cat = "";
				
				//GET THE INPUT FROM TEXTFIELDS
				//ISBN Check
				if(check(ISBNField.getText()) == true) {
					ISBN = ISBNField.getText();
				}
				else {
					errorAlert.setContentText("Invalid ISBN format.");
					errorAlert.show();
					ISBNField.setText("");
				}
				
				title = titleField.getText();
				
				//Author Check
				if(check(authorField.getText()) == true) {
					confAlert.setHeaderText("The author input you gave contains numbers");
					Optional<ButtonType> result = confAlert.showAndWait();
					
					if (result.isPresent() && result.get() == buttonYes) {
				        System.out.println("Yes");
				        author = authorField.getText();
				    } 
					else {
				        System.out.println("No");
				        authorField.setText("");
				    }
				}
				else {
					author = authorField.getText();
				}
				
				//Publisher Check
				if(check(publisherField.getText()) == true) {
					confAlert.setHeaderText("The publisher input you gave contains numbers");
					Optional<ButtonType> result = confAlert.showAndWait();
					
					if (result.isPresent() && result.get() == buttonYes) {
				        System.out.println("Yes");
				        publisher = publisherField.getText();
				    } 
					else {
				        System.out.println("No");
				        publisherField.setText("");
				    }
				}
				else {
					publisher = publisherField.getText();
				}
				
				//CAT Check
				if(check(catField.getText()) == true) {
					confAlert.setHeaderText("The category input you gave contains numbers");
					Optional<ButtonType> result = confAlert.showAndWait();
					
					if (result.isPresent() && result.get() == buttonYes) {
				        System.out.println("Yes");
				        cat = catField.getText();
				    } 
					else {
				        System.out.println("No");
				        catField.setText("");
				    }
				}
				else {
					cat = catField.getText();
				}
				
				boolean avail = availCheckBox.isSelected();
				
				//Year Of Publish check
				try {
					yop = Integer.parseInt(yopField.getText());
				}catch(NumberFormatException e){
					errorAlert.setContentText("Invalid year format. Making it 0 by default you can edit and change it.");
					errorAlert.show();
					yopField.setText("");
				}
				
				if(!(ISBNField.getText().equals("") || titleField.getText().equals("") || authorField.getText().equals("") || publisherField.getText().equals("") || yopField.getText().equals("") || catField.getText().equals(""))) {
					//Create the new book
					createBook(ISBN, title, author, publisher, yop, cat, avail);
					
					//synchronize the list
					tableSync();
					clearTextFields();
				}
			}
		}
		if(event.getSource() == updateBtn) {
			//Check if there is a blank field
//			if(ISBNField.getText().equals("") || titleField.getText().equals("") || authorField.getText().equals("") || publisherField.getText().equals("") || yopField.getText().equals("") || catField.getText().equals("")) {
//				errorAlert.setContentText("Field(s) blank. Make sure you've slected a book and made the changes you want.");
//				errorAlert.show();
//			}
			if(ISBNField.getText().equals("")) {
				errorAlert.setContentText("ISBN is mandatory in order to edit a book!");
				errorAlert.show();
			}
			else {
				int yop = 0;
				String ISBN = "", title = "", author = "" , publisher = "", cat = "";
				
				//GET THE INPUT FROM TEXTFIELDS
				//ISBN Check
				if(check(ISBNField.getText()) == true) {
					ISBN = ISBNField.getText();
				}
				else {
					errorAlert.setContentText("Invalid ISBN format.");
					errorAlert.show();
					ISBNField.setText("");
					//ISBNField.setText("");
				}
				
				title = titleField.getText();
				
				//Author Check
				if(check(authorField.getText()) == true) {
					confAlert.setHeaderText("The author input you gave contains numbers");
					Optional<ButtonType> result = confAlert.showAndWait();
					
					if (result.isPresent() && result.get() == buttonYes) {
				        System.out.println("Yes");
				        author = authorField.getText();
				    } 
					else {
				        System.out.println("No");
				        authorField.setText("");
				    }
				}
				else {
					author = authorField.getText();
				}
				
				//Publisher Check
				if(check(publisherField.getText()) == true) {
					confAlert.setHeaderText("The publisher input you gave contains numbers");
					Optional<ButtonType> result = confAlert.showAndWait();
					
					if (result.isPresent() && result.get() == buttonYes) {
				        System.out.println("Yes");
				        publisher = publisherField.getText();
				    } 
					else {
				        System.out.println("No");
				        publisherField.setText("");
				    }
				}
				else {
					publisher = publisherField.getText();
				}
				
				//CAT Check
				if(check(catField.getText()) == true) {
					confAlert.setHeaderText("The category input you gave contains numbers");
					Optional<ButtonType> result = confAlert.showAndWait();
					
					if (result.isPresent() && result.get() == buttonYes) {
				        System.out.println("Yes");
				        cat = catField.getText();
				    } 
					else {
				        System.out.println("No");
				        catField.setText("");
				    }
				}
				else {
					cat = catField.getText();
				}
				
				boolean avail = availCheckBox.isSelected();
				
				try {
					yop = Integer.parseInt(yopField.getText());
				}catch(NumberFormatException e){
					errorAlert.setContentText("Invalid year format. Making it 0 by default you can edit and change it.");
					errorAlert.show();
					yopField.setText("");
				}
				
//				if(!(ISBNField.getText().equals("") || titleField.getText().equals("") || authorField.getText().equals("") || publisherField.getText().equals("") || yopField.getText().equals("") || catField.getText().equals(""))) {
//					//Update the selected book
//					updateBook(ISBN, title, author, publisher, yop, cat, avail);
//					
//					//synchronize the list
//					tableSync();
//					clearTextFields();
//				}
				//Update the selected book
				updateBook(ISBN, title, author, publisher, yop, cat, avail);
				
				//synchronize the list
				tableSync();
				clearTextFields();
			}
			
		}
		if (event.getSource() == delBtn) {
			deleteBook(ISBNField.getText());
			
			tableSync();
			clearTextFields();
		}
		if (event.getSource() == bookTableView) {
			Book selectedBook = bookTableView.getSelectionModel().getSelectedItem();
			if(selectedBook != null) {
				ISBNField.setText(selectedBook.getISBN());
				titleField.setText(selectedBook.getTitle());
				authorField.setText(selectedBook.getAuthor());
				publisherField.setText(selectedBook.getPublisher());
				yopField.setText(Integer.toString(selectedBook.getYop()));
				catField.setText(selectedBook.getCat());
				availCheckBox.setSelected(selectedBook.getAvail());
			}
		}
	}
	
	@Override
	Scene createScene() { return new Scene(rootGridPane, width, height);}
	
	public void createBook(String _ISBN, String _title, String _author, String _publisher, int _yop, String _cat, boolean _avail) {
		Book b = new Book(_ISBN, _title, _author, _publisher, _yop, _cat, _avail);
		books.add(b);
	}

	public void updateBook(String _ISBN, String _title, String _author, String _publisher, int _yop, String _cat, boolean _avail) {
		for(Book b: books) {
			if(b.getISBN().equals(_ISBN)) {
				b.setTitle(_title);
				b.setAuthor(_author);
				b.setPublisher(_publisher);
				b.setYop(_yop);
				b.setCat(_cat);
				b.setAvail(_avail);
			
			}
		}
		
	}
	
	public void deleteBook(String _ISBN) {
		for (int i = 0; i < books.size(); i++) {
			if(books.get(i).getISBN().equals(_ISBN)) {
				books.remove(i);
				break;
			}
		}
	}
	
	public void tableSync() {
		List<Book> items = bookTableView.getItems();
		items.clear();
		for(Book b : books) {
			items.add(b);
		}
	}
	
	public void clearTextFields() {
		ISBNField.setText("");
		titleField.setText("");
		authorField.setText("");
		publisherField.setText("");
		yopField.setText("");
		catField.setText("");
		availCheckBox.setSelected(false);
	}
	
	boolean check(String input) {
		//int plN = 0, plD = 0, plC = 0;
		
		for (char c : input.toCharArray()) {
		      if (!Character.isDigit(c)) {
		    	  if(c == '-') {
		    		 continue;
		    	  }
		    	  else {
		    		  return false;
		    	  }
		      } 
		}
		return true;
	}
	
	
}

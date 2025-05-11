package project.unipi.gui.JavaFXProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.Scene;

public class StudentManagementSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
		FlowPane btnFlowPane;
		//Grid Pane
		GridPane rootGridPane, inputGridPane;
		//Buttons
		Button newStudBtn, updateStudBtn, backBtn, clearBtn;
		//Labels
		Label idLbl, idNumLbl, nameLbl, surnameLbl, yobLbl, telLbl, emailLbl, AMLbl, studyDepLbl;
		//Text Fields
		TextField nameField, surnameField, yobField, telField, emailField, AMField, studyDepField;
		//Table View
		TableView<Student> studentTableView;
		//Students List
		ArrayList<Student> students;
		//Alert
		Alert errorAlert = new Alert(AlertType.ERROR);
		Alert confAlert = new Alert(AlertType.CONFIRMATION);
		//ButtonTypes
		ButtonType buttonYes, buttonNo;
		
		//Keep track of the ID
		static int idNum = 4;
		
		public StudentManagementSceneCreator(double width, double height) {
			super (width,height);
			//Pane setups
			rootGridPane = new GridPane();
			inputGridPane = new GridPane();
			btnFlowPane = new FlowPane();
			//Button initialization
			newStudBtn = new Button("Add New Student");
			updateStudBtn = new Button("Update Student's Data");
			backBtn = new Button("Back");
			clearBtn = new Button("Clear");
			//Connect Buttons with handler
			newStudBtn.setOnMouseClicked(this);
			updateStudBtn.setOnMouseClicked(this);
			backBtn.setOnMouseClicked(this);
			clearBtn.setOnMouseClicked(this);
			//ButtonType initialization
			buttonYes = new ButtonType("Yes");
			buttonNo = new ButtonType("No");
			//Connect ButtonTypes with alert
			confAlert.getButtonTypes().setAll(buttonYes, buttonNo);
			//Label Initialization
			idLbl = new Label("ID: ");
			idNumLbl = new Label("-");
			nameLbl = new Label("Name: ");
			surnameLbl = new Label("Surname: ");
			yobLbl = new Label("Year of Birth: ");
			telLbl = new Label("Telephone: ");
			emailLbl = new Label("E-mail: ");
			AMLbl = new Label("AM: ");
			studyDepLbl = new Label("Study Department:");
			//TextField setup
			nameField = new TextField();
			surnameField = new TextField();
			yobField = new TextField();
			telField = new TextField();
			emailField = new TextField();
			AMField = new TextField();
			studyDepField = new TextField();
			//TableView setup
			studentTableView = new TableView<>();
			//Customize Flowpane
			btnFlowPane.setHgap(15);
			btnFlowPane.getChildren().add(newStudBtn);
			btnFlowPane.getChildren().add(updateStudBtn);
			btnFlowPane.setAlignment(Pos.BOTTOM_CENTER);
			//Customize Input Gridpane
			inputGridPane.setAlignment(Pos.TOP_RIGHT);
			inputGridPane.setHgap(10);
			inputGridPane.setVgap(10);
			inputGridPane.add(idLbl, 0, 0);
			inputGridPane.add(idNumLbl, 1, 0);
			inputGridPane.add(nameLbl, 0, 1);
			inputGridPane.add(nameField, 1, 1);
			inputGridPane.add(surnameLbl, 0, 2);
			inputGridPane.add(surnameField, 1, 2);
			inputGridPane.add(yobLbl, 0, 3);
			inputGridPane.add(yobField, 1, 3);
			inputGridPane.add(telLbl, 0, 4);
			inputGridPane.add(telField, 1, 4);
			inputGridPane.add(emailLbl, 0, 5);
			inputGridPane.add(emailField, 1, 5);
			inputGridPane.add(AMLbl, 0, 6);
			inputGridPane.add(AMField, 1, 6);
			inputGridPane.add(studyDepLbl, 0, 7);
			inputGridPane.add(studyDepField, 1, 7);
			inputGridPane.add(clearBtn, 1, 9);
			//Customize Root GridPane
			rootGridPane.setVgap(10);
			rootGridPane.setHgap(10);
			rootGridPane.add(inputGridPane, 1, 0);
			rootGridPane.add(studentTableView, 0, 0);
			rootGridPane.add(btnFlowPane, 0, 2);
			rootGridPane.add(backBtn, 1, 2);
			//Customize Tableview 
			TableColumn<Student, String> idColumn = new TableColumn<>("ID");
			idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
			studentTableView.getColumns().add(idColumn);
			
			TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
			nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
			studentTableView.getColumns().add(nameColumn);
			
			TableColumn<Student, String> surnameColumn = new TableColumn<>("Surname");
			surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
			studentTableView.getColumns().add(surnameColumn);
			
			TableColumn<Student, String> yobColumn = new TableColumn<>("Year of Birth");
			yobColumn.setCellValueFactory(new PropertyValueFactory<>("yob"));
			studentTableView.getColumns().add(yobColumn);
			
			TableColumn<Student, String> telColumn = new TableColumn<>("Telephone");
			telColumn.setCellValueFactory(new PropertyValueFactory<>("tel"));
			studentTableView.getColumns().add(telColumn);
			
			TableColumn<Student, String> emailColumn = new TableColumn<>("Email");
			emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
			studentTableView.getColumns().add(emailColumn);
			
			TableColumn<Student, String> AMColumn = new TableColumn<>("AM");
			AMColumn.setCellValueFactory(new PropertyValueFactory<>("AM"));
			studentTableView.getColumns().add(AMColumn);
			
			TableColumn<Student, String> studyDepColumn = new TableColumn<>("Study Department");
			studyDepColumn.setCellValueFactory(new PropertyValueFactory<>("studyDep"));
			studentTableView.getColumns().add(studyDepColumn);
			
			studentTableView.setOnMouseClicked(this); //Attach handler
			
			//Initialize the ArrayList for students
			students = new ArrayList<>();
			students.add(new Student(0, "Gewrgia", "Mitsh", 2006, "6982967300" , "gewrgiamits@unipi.com", "e24179", "Digital Systems"));
	        students.add(new Student(1, "Spyros", "Koutroumanos", 2005, "6903469057", "spyroskoutro@unipi.com", "e23890", "Business Administration"));
	        students.add(new Student(2, "Elena", "Farmakh", 2005, "6908350896", "elenafar@unipi.com", "e23456", "Economics"));
	        students.add(new Student(3, "Thanasis", "Aggelakis", 2003, "6943848906", "thanosagg@unipi.com", "e21397", "Accounting and Finance"));
	        students.add(new Student(4, "Dimitris", "Kounas", 2004, "6974589062", "jimkounas@unipi.com", "e22780", "Shipping Management"));
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
			if(event.getSource() == newStudBtn) { // to isbn na einai mono ari8moi, author k publisher mono grammata, otan den exoun input ta pedia na mhn ftiaxnei biblio
				if(nameField.getText().equals("") || surnameField.getText().equals("") || telField.getText().equals("") || emailField.getText().equals("") || AMField.getText().equals("") || studyDepField.getText().equals("")) {
					errorAlert.setContentText("Field(s) blank. Make sure you've filled out everything");
					errorAlert.show();
				}
				else {
					int yob = 0;
					String name = "", surname = "", tel = "", email = "", AM = "", studyDep = "";
					
					idNum++;
					
					//GET THE INPUT FROM TEXTFIELDS
					//Name Check
					if(check(nameField.getText()) == true) {
						errorAlert.setContentText("Name & Surname fields should not contain numbers");
						errorAlert.show();
						nameField.setText("");
					}
					else {
						name = nameField.getText();
					}
					
					if(check(surnameField.getText()) == true) {
						errorAlert.setContentText("Name & Surname fields should not contain numbers");
						errorAlert.show();
						surnameField.setText("");
					}
					else {
						surname = surnameField.getText();
					}
					
					if(check(telField.getText()) == true) {
						tel = telField.getText();
					}
					else {
						errorAlert.setContentText("Invalid ISBN format.");
						errorAlert.show();
						telField.setText("");
					}
					
					email = emailField.getText();
					AM = AMField.getText();
					
					if(check(studyDepField.getText()) == true) {
						confAlert.setHeaderText("The author input you gave contains numbers");
						Optional<ButtonType> result = confAlert.showAndWait();
						
						if (result.isPresent() && result.get() == buttonYes) {
					        System.out.println("Yes");
					        studyDep = studyDepField.getText();
					    } 
						else {
					        System.out.println("No");
					        studyDepField.setText("");
					    }
					}
					else {
						studyDep = studyDepField.getText();
					}
					try {
						yob = Integer.parseInt(yobField.getText());
					}catch(NumberFormatException e){
						errorAlert.setContentText("Invalid year format. Making it 0 by default you can edit and change it.");
						errorAlert.show();
					}
					
					if(!(nameField.getText().equals("") || surnameField.getText().equals("") || telField.getText().equals("") || emailField.getText().equals("") || AMField.getText().equals("") || studyDepField.getText().equals(""))) {
						//Create the new book
						createStudent(idNum, name, surname, yob, tel, email, AM, studyDep);
						
						//synchronize the list
						tableSync();
						clearTextFields();
					}
				}
			}
			if(event.getSource() == updateStudBtn) {
				//Check if there is a blank field
				if(/*idField.getText().equals("") || */nameField.getText().equals("") || surnameField.getText().equals("") || yobField.getText().equals("") || telField.getText().equals("") || emailField.getText().equals("") || AMField.getText().equals("") || studyDepField.getText().equals("")) {
					errorAlert.setContentText("Field(s) blank. Make sure you've slected a student and made the changes you want.");
					errorAlert.show();
				}
				else {
					
					int yob = 0;
					String name = "", surname = "", tel = "", email = "", AM = "", studyDep = "";
					//Get the input from the textfields
					
					if(check(nameField.getText()) == true) {
						errorAlert.setContentText("Name & Surname fields should not contain numbers");
						errorAlert.show();
						nameField.setText("");
					}
					else {
						name = nameField.getText();
					}
					
					if(check(surnameField.getText()) == true) {
						errorAlert.setContentText("Name & Surname fields should not contain numbers");
						errorAlert.show();
						surnameField.setText("");
					}
					else {
						surname = surnameField.getText();
					}
					
					if(check(telField.getText()) == true) {
						tel = telField.getText();
					}
					else {
						errorAlert.setContentText("Invalid ISBN format.");
						errorAlert.show();
						telField.setText("");
					}
					
					email = emailField.getText();
					AM = AMField.getText();

					if(check(studyDepField.getText()) == true) {
						confAlert.setHeaderText("The author input you gave contains numbers");
						Optional<ButtonType> result = confAlert.showAndWait();
						
						if (result.isPresent() && result.get() == buttonYes) {
					        System.out.println("Yes");
					        studyDep = studyDepField.getText();
					    } 
						else {
					        System.out.println("No");
					        studyDepField.setText("");
					    }
					}
					else {
						studyDep = studyDepField.getText();
					}
					
					try {
						yob = Integer.parseInt(yobField.getText());
					}catch(NumberFormatException e){
						errorAlert.setContentText("Invalid year format. Making it 0 by default you can edit and change it.");
						errorAlert.show();
					}
					
					//Update the selected book
					updateStudent(/*id, */name, surname, yob, tel, email, AM, studyDep);
					
					//synchronize the list
					tableSync();
					clearTextFields();
				}
				
			}
			if (event.getSource() == studentTableView) {
				Student selectedStudent = studentTableView.getSelectionModel().getSelectedItem();
				if(selectedStudent != null) {
					idNumLbl.setText(Integer.toString(selectedStudent.getId()));
					nameField.setText(selectedStudent.getName());
					surnameField.setText(selectedStudent.getSurname());
					yobField.setText(Integer.toString(selectedStudent.getYob()));
					telField.setText(selectedStudent.getTel());
					emailField.setText(selectedStudent.getEmail());
					AMField.setText(selectedStudent.getAM());
					studyDepField.setText(selectedStudent.getStudyDep());
				}
			}
		}

		@Override
		Scene createScene() { return new Scene(rootGridPane, width, height);}
		
		public void createStudent(int _id, String _name, String _surname, int _yob, String _tel, String _email, String _AM, String _studyDep) {
			Student s = new Student(_id, _name, _surname, _yob, _tel, _email, _AM, _studyDep);
			students.add(s);
		}
		
		public void updateStudent(/*int _id, */String _name, String _surname, int _yob, String _tel, String _email, String _AM, String _studyDep) {
			for(Student s: students) {
				if(s.getAM().equals(_AM) ) {
					//s.setId(_id);
					s.setName(_name);
					s.setSurname(_surname);
					s.setYob(_yob);
					s.setTel(_tel);
					s.setEmail(_email);
					s.setAM(_AM);
					s.setStudyDep(_studyDep);
				}
			}
			
		}
		
		public void tableSync() {
			List<Student> items = studentTableView.getItems();
			items.clear();
			for(User s : students) {
				if(s instanceof Student) {
					items.add((Student) s);
				}
			}
		}
		
		public void clearTextFields() {
			idNumLbl.setText("-");;
			nameField.setText("");
			surnameField.setText("");
			yobField.setText("");
			telField.setText("");
			emailField.setText("");
			AMField.setText("");
			studyDepField.setText("");
		}
		
		boolean check(String input) {
			//int plN = 0, plD = 0, plC = 0;
			
			for (char c : input.toCharArray()) {
				System.out.println(c);
				if (!Character.isDigit(c)) {
					return false;
				} 
			}
			return true;
		}
}
	

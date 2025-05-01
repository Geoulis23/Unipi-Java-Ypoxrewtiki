package project.unipi.gui.JavaFXProject;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
		Button newstudentBtn, updateStudentBtn, backBtn;
		//Labels
		Label idLbl, nameLbl, surnameLbl, yobLbl, telLbl, emailLbl, AMLbl, studyDepLbl;
		//Text Fields
		TextField idField, nameField, surnameField, yobField, telField, emailField, AMField, studyDepField;
		//Table View
		TableView<Student> studentTableView;
		
		public StudentManagementSceneCreator(double width, double height) {
			super (width,height);
			//Pane setups
			rootGridPane = new GridPane();
			inputGridPane = new GridPane();
			btnFlowPane = new FlowPane();
			//Button initialization
			newstudentBtn = new Button("Add New Student");
			updateStudentBtn = new Button("Update Student's Data");
			backBtn = new Button("Back");
			//Connect Buttons with handler
			newstudentBtn.setOnMouseClicked(this);
			updateStudentBtn.setOnMouseClicked(this);
			backBtn.setOnMouseClicked(this);
			//Label Initialization
			idLbl = new Label("ID: ");
			nameLbl = new Label("Name: ");
			surnameLbl = new Label("Surname: ");
			yobLbl = new Label("Year of Birth: ");
			telLbl = new Label("Telephone: ");
			emailLbl = new Label("E-mail: ");
			AMLbl = new Label("AM: ");
			studyDepLbl = new Label("StudyDep:");
			//TextField setup
			idField = new TextField();
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
			btnFlowPane.getChildren().add(newstudentBtn);
			btnFlowPane.getChildren().add(updateStudentBtn);
			btnFlowPane.setAlignment(Pos.BOTTOM_CENTER);
			//Customize Input Gridpane
			inputGridPane.setAlignment(Pos.TOP_RIGHT);
			inputGridPane.setHgap(10);
			inputGridPane.setVgap(10);
			inputGridPane.add(idLbl, 0, 0);
			inputGridPane.add(idField, 1, 0);
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
			
			TableColumn<Student, String> studyDepColumn = new TableColumn<>("StudyDep");
			studyDepColumn.setCellValueFactory(new PropertyValueFactory<>("studyDep"));
			studentTableView.getColumns().add(studyDepColumn);
		}
		

		@Override
		public void handle(MouseEvent event) {
			if(event.getSource() == backBtn) {
				App.stage.setTitle("UniPi Library");
				App.stage.setScene(App.mainScene);
			}
		}

		@Override
		Scene createScene() { return new Scene(rootGridPane, width, height);}
}
	

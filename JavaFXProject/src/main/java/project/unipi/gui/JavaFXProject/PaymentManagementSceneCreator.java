package project.unipi.gui.JavaFXProject;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class PaymentManagementSceneCreator extends SceneCreator implements EventHandler<MouseEvent>{
	//FlowPane
	FlowPane finePaymentFlowPane, fineRegistrationFlowPane;
	//GridPane
	GridPane finePaymentGridPane, fineRegistrationGridPane;
	//Table View
	TableView<Student> runningFinesTableView;
	TableView<Fine>paymentHistoryTableView;
	//Buttons
	Button finePaymentBackBtn, fineRegistrationBtn, fineRegistrationBackBtn, payFineBtn;
	//Scene
	Scene fineRegistrationScene;
	
	public PaymentManagementSceneCreator(double width, double height) {
		super(width,height);
		//FlowPane Setup
		finePaymentFlowPane = new FlowPane();
		//GridPane Setup
		finePaymentGridPane = new GridPane();
		//TableView Setup
		runningFinesTableView = new TableView<>();
		paymentHistoryTableView = new TableView<>();
		//Button Initialization 
		finePaymentBackBtn = new Button("Back");
		fineRegistrationBtn = new Button("Register Fine");
		//Connect Buttons with handler
		finePaymentBackBtn.setOnMouseClicked(this);
		fineRegistrationBtn.setOnMouseClicked(this);
		//Customize FlowPane
		finePaymentFlowPane.setHgap(15);
		finePaymentFlowPane.getChildren().add(finePaymentBackBtn);
		finePaymentFlowPane.getChildren().add(fineRegistrationBtn);
		finePaymentFlowPane.setAlignment(Pos.BOTTOM_LEFT);
		//Customize GridPane
		finePaymentGridPane.setAlignment(Pos.CENTER);
		finePaymentGridPane.setHgap(10);
		finePaymentGridPane.setVgap(10);
		finePaymentGridPane.add(paymentHistoryTableView, 0, 1);
		finePaymentGridPane.add(runningFinesTableView, 1, 1);
		finePaymentGridPane.add(finePaymentFlowPane, 1, 2);
		//Customize Table View 
		TableColumn<Student, String> idColumn = new TableColumn<>("ID");
		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		runningFinesTableView.getColumns().add(idColumn);
		TableColumn<Fine, String> fineIDColumn = new TableColumn<>("Fine ID");
		fineIDColumn.setCellValueFactory(new PropertyValueFactory<>("fineID"));
		paymentHistoryTableView.getColumns().add(fineIDColumn);
		
		TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		runningFinesTableView.getColumns().add(nameColumn);
		TableColumn<Fine, String> loanIDColumn = new TableColumn<>("Loan ID");
		loanIDColumn.setCellValueFactory(new PropertyValueFactory<>("loanID"));
		paymentHistoryTableView.getColumns().add(loanIDColumn);
		
		TableColumn<Student, String> fineAmountColumn = new TableColumn<>("Fine Amount");
		fineAmountColumn.setCellValueFactory(new PropertyValueFactory<>("fineAmount"));
		runningFinesTableView.getColumns().add(fineAmountColumn);
		TableColumn<Fine, String> loaningBookColumn = new TableColumn<>("Loaning Book");
		loaningBookColumn.setCellValueFactory(new PropertyValueFactory<>("loaningBook"));
		paymentHistoryTableView.getColumns().add(loaningBookColumn);
		
		TableColumn<Student, String> yobColumn = new TableColumn<>("Year of Birth");
		yobColumn.setCellValueFactory(new PropertyValueFactory<>("yob"));
		runningFinesTableView.getColumns().add(yobColumn);
		TableColumn<Fine, String> paidColumn = new TableColumn<>("Paid");
		paidColumn.setCellValueFactory(new PropertyValueFactory<>("paid"));
		paymentHistoryTableView.getColumns().add(paidColumn);
		
		TableColumn<Student, String> telColumn = new TableColumn<>("Telephone");
		telColumn.setCellValueFactory(new PropertyValueFactory<>("tel"));
		runningFinesTableView.getColumns().add(telColumn);
		
		TableColumn<Student, String> emailColumn = new TableColumn<>("Email");
		emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
		runningFinesTableView.getColumns().add(emailColumn);
		
		TableColumn<Student, String> AMColumn = new TableColumn<>("AM");
		AMColumn.setCellValueFactory(new PropertyValueFactory<>("AM"));
		runningFinesTableView.getColumns().add(AMColumn);
		
		TableColumn<Student, String> studyDepColumn = new TableColumn<>("Study Department");
		studyDepColumn.setCellValueFactory(new PropertyValueFactory<>("studyDep"));
		runningFinesTableView.getColumns().add(studyDepColumn);
		
	}
	@Override
	Scene createScene() { return new Scene(finePaymentGridPane, width, height);}
	
	@Override
	public void handle(MouseEvent event) {
		
		if(event.getSource() == finePaymentBackBtn) {
			App.stage.setTitle("UniPi Library");
			App.stage.setScene(App.mainScene);
		}
		if(event.getSource() == fineRegistrationBtn) {
			//FlowPane Setup
			fineRegistrationFlowPane = new FlowPane();
			//GridPane Setup
			fineRegistrationGridPane = new GridPane();
			//Scene Setup
			fineRegistrationScene = new Scene(fineRegistrationGridPane, 950, 400);
			//Button Initialization 
			payFineBtn = new Button("Pay Fine");
			fineRegistrationBackBtn = new Button("Back");
			//Connect handler with button
	    	payFineBtn.setOnMouseClicked(this);
	    	fineRegistrationBackBtn.setOnMouseClicked(this);
	    	//FlowPane Customization
	    	fineRegistrationFlowPane.setHgap(15);
	    	fineRegistrationFlowPane.setAlignment(Pos.BOTTOM_CENTER);
	    	fineRegistrationFlowPane.getChildren().add(fineRegistrationBackBtn);
	    	fineRegistrationBackBtn.setAlignment(Pos.BOTTOM_CENTER);
	    	fineRegistrationFlowPane.getChildren().add(payFineBtn);
	    	payFineBtn.setAlignment(Pos.BOTTOM_CENTER);
	    	//Customize GridPane
	    	fineRegistrationGridPane.setAlignment(Pos.CENTER);
	    	fineRegistrationGridPane.setHgap(10);
	    	fineRegistrationGridPane.setVgap(10);
	    	fineRegistrationGridPane.add(runningFinesTableView, 0, 1);
	    	fineRegistrationGridPane.add(fineRegistrationFlowPane, 0, 2);
	    	
			//TableView Customization
	    	TableColumn<Student, String> idColumn = new TableColumn<>("ID");
			idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
			runningFinesTableView.getColumns().add(idColumn);
			
			TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
			nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
			runningFinesTableView.getColumns().add(nameColumn);
	    	
			TableColumn<Student, String> fineAmountColumn = new TableColumn<>("Fine Amount");
			fineAmountColumn.setCellValueFactory(new PropertyValueFactory<>("fineAmount"));
			runningFinesTableView.getColumns().add(fineAmountColumn);
			
			TableColumn<Student, String> yobColumn = new TableColumn<>("Year of Birth");
			yobColumn.setCellValueFactory(new PropertyValueFactory<>("yob"));
			runningFinesTableView.getColumns().add(yobColumn);
			
			TableColumn<Student, String> telColumn = new TableColumn<>("Telephone");
			telColumn.setCellValueFactory(new PropertyValueFactory<>("tel"));
			runningFinesTableView.getColumns().add(telColumn);
			
			TableColumn<Student, String> emailColumn = new TableColumn<>("Email");
			emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
			runningFinesTableView.getColumns().add(emailColumn);
			
			TableColumn<Student, String> AMColumn = new TableColumn<>("AM");
			AMColumn.setCellValueFactory(new PropertyValueFactory<>("AM"));
			runningFinesTableView.getColumns().add(AMColumn);
			
			TableColumn<Student, String> studyDepColumn = new TableColumn<>("Study Department");
			studyDepColumn.setCellValueFactory(new PropertyValueFactory<>("studyDep"));
			runningFinesTableView.getColumns().add(studyDepColumn);
			
			App.stage.setTitle("Register Fine");
	    	App.stage.setScene(this.fineRegistrationScene);
		}
		if(event.getSource() == payFineBtn) {
			
			
			
		}
		if(event.getSource() == fineRegistrationBackBtn) {
			App.stage.setTitle("Payment Management");
			App.stage.setScene(App.paymentManagementScene);
		}
	}
	
		
}

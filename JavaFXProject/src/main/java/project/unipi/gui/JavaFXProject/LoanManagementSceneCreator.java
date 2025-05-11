package project.unipi.gui.JavaFXProject;

import java.util.List;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

public class LoanManagementSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
	//FlowPane (root)
	FlowPane rootFlowPane, loanFlowPane, viewLoanBtnFlowPane, returnBookBtnFlowPane;
	//Main scene buttons
	Button newLoanBtn, returnBookBtn, viewLoanBtn, bookSearchBtn, studentSearchBtn, newLoanBackBtn, backBtn, viewLoanBackBtn, returnBookBackBtn, returnBtn; 
	//Labels
	Label activelbl, latelbl, finishedlbl;
	//Scene Setup
	Scene newLoanScene, viewLoanScene, returnBookScene;
	//GridPane
	GridPane viewLoanGridPane, returnBookGridPane;
	//Table View
	TableView<Loan> activeLoanTableView, lateLoanTableView, finishedLoanTableView, returnBookTableView;
	
	//Alert
	Alert errorAlert = new Alert(AlertType.ERROR);
	
		
	public LoanManagementSceneCreator(double width, double height) {
		super(width, height);
	   	//Button initialization
	    newLoanBtn = new Button("New Loan");
	    returnBookBtn = new Button("Return Book");
	    viewLoanBtn = new Button("View Loan");
	    backBtn = new Button("Back");
	    //Connect handler with buttons
	    newLoanBtn.setOnMouseClicked(this);
	    returnBookBtn.setOnMouseClicked(this);
	    viewLoanBtn.setOnMouseClicked(this);
	    backBtn.setOnMouseClicked(this);
	    //FlowPane setup
	    rootFlowPane = new FlowPane();
	    	
	    rootFlowPane.setHgap(15);
	    rootFlowPane.setAlignment(Pos.CENTER);

	    rootFlowPane.getChildren().add(newLoanBtn);
	   	rootFlowPane.getChildren().add(returnBookBtn);
	    rootFlowPane.getChildren().add(viewLoanBtn);
	    rootFlowPane.getChildren().add(backBtn);
	}
		
	@Override
	Scene createScene() { return new Scene(rootFlowPane, width, height);}

	@Override
	public void handle(MouseEvent event) {
		//Back Button
		if(event.getSource() == backBtn) {
			App.stage.setTitle("UniPi Library");
			App.stage.setScene(App.mainScene);
		}
		//New Loan Button
		if (event.getSource() == newLoanBtn) {
			//FlowPane setup
			loanFlowPane = new FlowPane();
			//Scene Setup
			newLoanScene = new Scene(loanFlowPane, 950, 400);
			//Button initialization
			bookSearchBtn = new Button("Search Book");
			studentSearchBtn = new Button("Search Student");
			newLoanBackBtn = new Button("Back");
			//Connect handler with buttons
			bookSearchBtn.setOnMouseClicked(this);
			studentSearchBtn.setOnMouseClicked(this);
			newLoanBackBtn.setOnMouseClicked(this);
			
			loanFlowPane.setHgap(15);
		    loanFlowPane.setAlignment(Pos.CENTER);

		    loanFlowPane.getChildren().add(bookSearchBtn);
		   	loanFlowPane.getChildren().add(studentSearchBtn);
		    loanFlowPane.getChildren().add(newLoanBackBtn);
		    
		    App.stage.setTitle("New Loan");
	    	App.stage.setScene(this.newLoanScene);
		    }
		//New Loan BackButton
		if (event.getSource() == newLoanBackBtn) {
			App.stage.setTitle("Loan Management");
			App.stage.setScene(App.loanManagementScene);
		}    
	    if (event.getSource() == returnBookBtn) {
	    	//FlowPane Setup
	    	returnBookBtnFlowPane = new FlowPane();
	    	//GridPane Setup
	    	returnBookGridPane = new GridPane();
	    	//Scene Setup
	    	returnBookScene = new Scene(returnBookGridPane, 950, 400);
	    	//TableView Setup
	    	returnBookTableView = new TableView<>();
	    	//Button Initialization
	    	returnBtn = new Button("Return");
	    	returnBookBackBtn = new Button("Back");
	    	//Connect handler with button
	    	returnBookBackBtn.setOnMouseClicked(this);
	    	returnBtn.setOnMouseClicked(this);
	    	//FlowPane Customization
	    	returnBookBtnFlowPane.setHgap(35);
	    	returnBookBtnFlowPane.setVgap(15);
	    	returnBookBtnFlowPane.setAlignment(Pos.CENTER);
	    	returnBookBtnFlowPane.getChildren().add(returnBookBackBtn);
	    	returnBookBtnFlowPane.getChildren().add(returnBtn);
	    	//GridPane Customization
	    	returnBookGridPane.setAlignment(Pos.CENTER);
	    	returnBookGridPane.add(returnBookTableView, 1, 0);
	    	returnBookGridPane.add(returnBookBtnFlowPane, 1, 1);
	    	//TableView Customization
	    	TableColumn<Loan, String> loanIDColumn = new TableColumn<>("ID");
			loanIDColumn.setCellValueFactory(new PropertyValueFactory<>("loanID"));
			returnBookTableView.getColumns().add(loanIDColumn);
			
			
			TableColumn<Loan, String> loaningStudColumn = new TableColumn<>("Loaning Student");
			loaningStudColumn.setCellValueFactory(new PropertyValueFactory<>("loaningStud"));
			returnBookTableView.getColumns().add(loaningStudColumn);
			
			
			TableColumn<Loan, String> loaningBookColumn = new TableColumn<>("Loaning Book");
			loaningBookColumn.setCellValueFactory(new PropertyValueFactory<>("loaningBook"));
			returnBookTableView.getColumns().add(loaningBookColumn);
			
			
			TableColumn<Loan, String> loanDateColumn = new TableColumn<>("Loan Date");
			loanDateColumn.setCellValueFactory(new PropertyValueFactory<>("loanDate"));
			returnBookTableView.getColumns().add(loanDateColumn);
			
			
			TableColumn<Loan, String> returnDeadlineColumn = new TableColumn<>("Return Deadline");
			returnDeadlineColumn.setCellValueFactory(new PropertyValueFactory<>("returnDeadline"));
			returnBookTableView.getColumns().add(returnDeadlineColumn);
			
			
			TableColumn<Loan, String> returnDateColumn = new TableColumn<>("Return Date");
			returnDateColumn.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
			returnBookTableView.getColumns().add(returnDateColumn);
			
			
			TableColumn<Loan, String> delayColumn = new TableColumn<>("Delay");
			delayColumn.setCellValueFactory(new PropertyValueFactory<>("delay"));
			returnBookTableView.getColumns().add(delayColumn);
			
			
			TableColumn<Loan, String> statusColumn = new TableColumn<>("Status");
			statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
			returnBookTableView.getColumns().add(statusColumn);
			
	    	
	    	App.stage.setTitle("Return Book");
	    	App.stage.setScene(this.returnBookScene);
	    }
	    if (event.getSource() == returnBookBackBtn) {
	    	App.stage.setTitle("Loan Management");
			App.stage.setScene(App.loanManagementScene);
	    }
	    if (event.getSource() == viewLoanBtn) {
	    	//FlowPane setup
	    	viewLoanBtnFlowPane = new FlowPane();
	    	//GridPane Setup
	    	viewLoanGridPane = new GridPane();
	    	//TableView setup
			activeLoanTableView = new TableView<>();
			lateLoanTableView = new TableView<>();
			finishedLoanTableView = new TableView<>();
	    	//Scene Setup
	    	viewLoanScene = new Scene(viewLoanGridPane, 1300, 500);
	    	//Button initialization
	    	viewLoanBackBtn = new Button("Back");
	    	//Connect handler with button
	    	viewLoanBackBtn.setOnMouseClicked(this);
	    	
	    	//Label Initialization
			activelbl = new Label("ACTIVE");
			latelbl = new Label("LATE");
			finishedlbl = new Label("FINISHED");

	    	viewLoanBtnFlowPane.setAlignment(Pos.BOTTOM_CENTER);
	    	viewLoanBtnFlowPane.getChildren().add(viewLoanBackBtn);
	    	viewLoanBackBtn.setAlignment(Pos.BOTTOM_CENTER);
	    	
	    	activelbl.setAlignment(Pos.CENTER);
	    	latelbl.setAlignment(Pos.CENTER);
	    	finishedlbl.setAlignment(Pos.CENTER);
			
	    	//GridPane Customization
	    	viewLoanGridPane.setHgap(10);
	    	viewLoanGridPane.setVgap(10);
	    	viewLoanGridPane.add(activeLoanTableView, 0, 1);
	    	viewLoanGridPane.add(lateLoanTableView, 1, 1);
	    	viewLoanGridPane.add(finishedLoanTableView, 2, 1);
	    	viewLoanGridPane.add(viewLoanBtnFlowPane, 1, 2);
	    	viewLoanGridPane.add(activelbl, 0, 0);
	    	viewLoanGridPane.add(latelbl, 1, 0);
	    	viewLoanGridPane.add(finishedlbl, 2, 0);
	    	
	    	
			//Customize Active,Late,Finished Tableview 
			TableColumn<Loan, String> loanIDColumn = new TableColumn<>("ID");
			loanIDColumn.setCellValueFactory(new PropertyValueFactory<>("loanID"));
			activeLoanTableView.getColumns().add(loanIDColumn);
			lateLoanTableView.getColumns().add(loanIDColumn);
			finishedLoanTableView.getColumns().add(loanIDColumn);
			
			TableColumn<Loan, String> loaningStudColumn = new TableColumn<>("Loaning Student");
			loaningStudColumn.setCellValueFactory(new PropertyValueFactory<>("loaningStud"));
			activeLoanTableView.getColumns().add(loaningStudColumn);
			lateLoanTableView.getColumns().add(loaningStudColumn);
			finishedLoanTableView.getColumns().add(loaningStudColumn);
			
			TableColumn<Loan, String> loaningBookColumn = new TableColumn<>("Loaning Book");
			loaningBookColumn.setCellValueFactory(new PropertyValueFactory<>("loaningBook"));
			activeLoanTableView.getColumns().add(loaningBookColumn);
			lateLoanTableView.getColumns().add(loaningBookColumn);
			finishedLoanTableView.getColumns().add(loaningBookColumn);
			
			TableColumn<Loan, String> loanDateColumn = new TableColumn<>("Loan Date");
			loanDateColumn.setCellValueFactory(new PropertyValueFactory<>("loanDate"));
			activeLoanTableView.getColumns().add(loanDateColumn);
			lateLoanTableView.getColumns().add(loanDateColumn);
			finishedLoanTableView.getColumns().add(loanDateColumn);
			
			TableColumn<Loan, String> returnDeadlineColumn = new TableColumn<>("Return Deadline");
			returnDeadlineColumn.setCellValueFactory(new PropertyValueFactory<>("returnDeadline"));
			activeLoanTableView.getColumns().add(returnDeadlineColumn);
			lateLoanTableView.getColumns().add(returnDeadlineColumn);
			finishedLoanTableView.getColumns().add(returnDeadlineColumn);
			
			TableColumn<Loan, String> returnDateColumn = new TableColumn<>("Return Date");
			returnDateColumn.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
			activeLoanTableView.getColumns().add(returnDateColumn);
			lateLoanTableView.getColumns().add(returnDateColumn);
			finishedLoanTableView.getColumns().add(returnDateColumn);
			
			TableColumn<Loan, String> delayColumn = new TableColumn<>("Delay");
			delayColumn.setCellValueFactory(new PropertyValueFactory<>("delay"));
			activeLoanTableView.getColumns().add(delayColumn);
			lateLoanTableView.getColumns().add(delayColumn);
			finishedLoanTableView.getColumns().add(delayColumn);
			
			TableColumn<Loan, String> statusColumn = new TableColumn<>("Status");
			statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
			activeLoanTableView.getColumns().add(statusColumn);
			lateLoanTableView.getColumns().add(statusColumn);
			finishedLoanTableView.getColumns().add(statusColumn);
			
	    	App.stage.setTitle("View Loan");
	    	App.stage.setScene(this.viewLoanScene);
	    }
	    if (event.getSource() == viewLoanBackBtn) {
	    	App.stage.setTitle("Loan Management");
			App.stage.setScene(App.loanManagementScene);
	    }
}

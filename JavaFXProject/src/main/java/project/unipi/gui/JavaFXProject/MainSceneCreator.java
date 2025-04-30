package project.unipi.gui.JavaFXProject;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

public class MainSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
	//FlowPane (root)
	FlowPane rootFlowPane;
	//Main scene buttons
	Button bookManagementBtn, studentManagementBtn, loanManagementBtn, paymentManagementBtn/*, backBtn -test-*/;
	
	public MainSceneCreator(double width, double height) {
		super(width, height);
    	//Button initialization
    	bookManagementBtn = new Button("Book Management");
    	studentManagementBtn = new Button("Student Management");
    	loanManagementBtn = new Button("Loan Management");
    	paymentManagementBtn = new Button("Payment Management");
    	//Connect handler with buttons
    	bookManagementBtn.setOnMouseClicked(this);
    	studentManagementBtn.setOnMouseClicked(this);
    	loanManagementBtn.setOnMouseClicked(this);
    	paymentManagementBtn.setOnMouseClicked(this);
    	//Flowpane setup
    	rootFlowPane = new FlowPane();
    	
    	rootFlowPane.setHgap(15);
    	rootFlowPane.setAlignment(Pos.CENTER);

    	rootFlowPane.getChildren().add(bookManagementBtn);
    	rootFlowPane.getChildren().add(studentManagementBtn);
    	rootFlowPane.getChildren().add(loanManagementBtn);
    	rootFlowPane.getChildren().add(paymentManagementBtn);
	}
	
	@Override
	Scene createScene() { return new Scene(rootFlowPane, width, height);}

	@Override
	public void handle(MouseEvent event) {
		if (event.getSource() == bookManagementBtn) {
    		App.stage.setTitle("Book Management");
    		App.stage.setScene(App.bookManagementScene);
    	}
    	if (event.getSource() == studentManagementBtn) {
    		App.stage.setTitle("Student Management");
    		App.stage.setScene(App.studentManagementScene);
    	}
    	if (event.getSource() == loanManagementBtn) {
    		App.stage.setTitle("Loan Management");
    		App.stage.setScene(App.loanManagementScene);
    	}
    	if (event.getSource() == paymentManagementBtn) {
    		App.stage.setTitle("Payment Management");
    		App.stage.setScene(App.paymentManagementScene);
    	}
		
	}
}

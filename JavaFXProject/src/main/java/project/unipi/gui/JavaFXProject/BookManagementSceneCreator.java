package project.unipi.gui.JavaFXProject;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	Button newBtn, updateBtn, delBtn, backBtn;
	//Labels
	Label ISBNLbl, titleLbl, authorLbl, publisherLbl, yopLbl, catLbl, availLbl;
	//Text Fields
	TextField ISBNField, titleField, authorField, publisherField, yopField, catField, availField;
	//Table View
	TableView<Book> bookTableView;
	
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
		//Connect Buttons with handler
		newBtn.setOnMouseClicked(this);
		updateBtn.setOnMouseClicked(this);
		delBtn.setOnMouseClicked(this);
		backBtn.setOnMouseClicked(this);
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
		availField = new TextField();
		//TableView setup
		bookTableView = new TableView<>();
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
		inputGridPane.add(availField, 1, 6);
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

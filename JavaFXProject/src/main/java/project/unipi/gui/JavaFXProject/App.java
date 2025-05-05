package project.unipi.gui.JavaFXProject;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
	//Stage
	static Stage stage;
	//Scenes
	static Scene mainScene, bookManagementScene, studentManagementScene, loanManagementScene, paymentManagementScene;

    @Override
    public void start(Stage stage) {
    	this.stage = stage;
    	
    	//Set scenes
    	SceneCreator mainSceneCreator = new MainSceneCreator(650, 300);
    	mainScene = mainSceneCreator.createScene();
    	
    	SceneCreator bookManagementSceneCreator = new BookManagementSceneCreator(850, 350);
    	bookManagementScene = bookManagementSceneCreator.createScene();
    	
    	SceneCreator studentManagementSceneCreator = new StudentManagementSceneCreator(900, 350);
    	studentManagementScene = studentManagementSceneCreator.createScene();
//    	loanManagementScene = new Scene(new GridPane(), 650, 300);
//    	paymentManagementScene = new Scene(new GridPane(), 650, 300);
    	
        stage.setTitle("UniPi Library Project");
        stage.setScene(mainScene);
        stage.show();
    }

    public static void main(String[] args) {
        //Starting Students List
        List<Student> students = new ArrayList<>();    
        //STUDENTS 
        students.add(new Student( 0, "Gewrgia", "Mitsh", 2006, "698296730" , "gewrgiamits@unipi.com", "24179", "Digital Systems"));
        students.add(new Student( 1, "Spyros", "Koutroumanos", 2005, "6903469057", "spyroskoutro@unipi.com", "23890", "Business Administration"));
        students.add(new Student( 2, "Elena", "Farmakh", 2005, "6908350896", "elenafar@unipi.com", "23456", "Economics"));
        students.add(new Student( 3, "Thanasis", "Aggelakis", 2003, "6943848906", "thanosagg@unipi.com", "21397", "Accounting and Finance"));
        students.add(new Student( 4, "Dimitris", "Kounas", 2004, "6974589062", "jimkounas@unipi.com", "22780", "Shipping Management"));
    	
    	launch();
    }

}

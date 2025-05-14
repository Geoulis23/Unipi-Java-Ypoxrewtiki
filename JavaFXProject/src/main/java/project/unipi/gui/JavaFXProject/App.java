package project.unipi.gui.JavaFXProject;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
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
    	
    	SceneCreator bookManagementSceneCreator = new BookManagementSceneCreator(950, 400);
    	bookManagementScene = bookManagementSceneCreator.createScene();
    	
    	SceneCreator studentManagementSceneCreator = new StudentManagementSceneCreator(950, 400);
    	studentManagementScene = studentManagementSceneCreator.createScene();
    	
    	SceneCreator loanManagementSceneCreator = new LoanManagementSceneCreator(950, 400);
    	loanManagementScene = loanManagementSceneCreator.createScene();
    	
    	SceneCreator paymentManagementSceneCreator = new PaymentManagementSceneCreator(950, 400);
    	paymentManagementScene = paymentManagementSceneCreator.createScene();

        stage.setTitle("UniPi Library Project");
        stage.setScene(mainScene);
        stage.show();
    }

    public static void main(String[] args) {
    	launch();
    }

}

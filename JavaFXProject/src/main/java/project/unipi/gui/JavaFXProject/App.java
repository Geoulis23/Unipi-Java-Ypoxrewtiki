package project.unipi.gui.JavaFXProject;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        var scene = new Scene(new StackPane(label), 640, 480);
        //Image icon = new Image("C:\\Users\\maria\\eclipse-workspace\\JavaFXProject\\sprites\\download.png");
       // stage.getIcons().add(icon);
        stage.setTitle("UniPi Library Project");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        //Starting Books List
        List<Book> books = new ArrayList<>();  
        //BOOKS
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
        //Starting Students List
        List<Student> students = new ArrayList<>();    
        //STUDENTS 
        students.add(new Student( 0, "Gewrgia", "Mitsh", 2006, "698296730" , "gewrgiamits@unipi.com", "24179", "Digital Systems"));
        students.add(new Student( 1, "Spyros", "Koutroumanos", 2005, "6903469057", "spyroskoutro@unipi.com", "23890", "Business Administration"));
        students.add(new Student( 2, "Elena", "Farmakh", 2005, "6908350896", "elenafar@unipi.com", "23456", "Economics"));
        students.add(new Student( 3, "Thanasis", "Aggelakis", 2003, "6943848906", "thanosagg@unipi.com", "21397", "Accounting and Finance"));
        students.add(new Student( 4, "Dimitris", "Kounas", 2004, "6974589062", "jimkounas@unipi.com", "22780", "Shipping Management"));
  
    }
}

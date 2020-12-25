package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			Parent parent = loader.load(); // carregou a view
			Scene mainScene = new Scene(parent); // criei a sena
			primaryStage.setScene(mainScene); // adicionei a sena no palco
			primaryStage.setTitle("Simple javafx Application"); // coloquei um título na minha sena
			primaryStage.show(); // agora mostro a sena
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

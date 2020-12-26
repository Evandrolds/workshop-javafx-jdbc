package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			ScrollPane scroballPene = loader.load(); // carregou a view
			scroballPene.setFitToHeight(true); // configurando a tela
			scroballPene.setFitToWidth(true);
			Scene mainScene = new Scene(scroballPene); // criei a sena
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

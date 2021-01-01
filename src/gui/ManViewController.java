package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import model.services.DepartmentService;

public class ManViewController implements Initializable {
	@FXML
	private MenuItem menuItemSeller;
	@FXML
	private MenuItem menuItemDepartment;
	@FXML
	private MenuItem menuItemAbout;

	@FXML
	public void onMenuItemSellerAction() {

	}

	@FXML
	public void onMenuItemDepartmentAction() {
		loadView2("/gui/DepartmentList.fxml");
	}

	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/About.fxml"); // comando para exibir no console
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

	// para garantir a execução sem nenhum comportamento inesperado Usa-se o
	// (Synchronized)
	// Garante que o processamento não vai ser interrompido
	public synchronized void loadView(String loadview) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(loadview));
			VBox newVbox = loader.load();
			Scene mainscene = Main.getMainScene();
			VBox mainVbox = (VBox) ((ScrollPane) mainscene.getRoot()).getContent();// pegando do primeiro elemento da
																					// View

			Node mainMenu = mainVbox.getChildren().get(0); // pegando o primeiro elemento do Children
			mainVbox.getChildren().clear();
			mainVbox.getChildren().add(mainMenu);
			mainVbox.getChildren().addAll(newVbox.getChildren());// adicionando uma coleção da View
		} catch (IOException e) {
			Alerts.showAlert("IOException error", "Error load view", e.getMessage(), AlertType.ERROR);
		}
	}

	public synchronized void loadView2(String loadview2) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(loadview2));
			VBox newVbox = loader.load();
			Scene mainscene = Main.getMainScene();
			VBox mainVbox = (VBox) ((ScrollPane) mainscene.getRoot()).getContent();// pegando do primeiro elemento da
																					// View

			Node mainMenu = mainVbox.getChildren().get(0); // pegando o primeiro elemento do Children
			mainVbox.getChildren().clear();
			mainVbox.getChildren().add(mainMenu);
			mainVbox.getChildren().addAll(newVbox.getChildren());// adicionando uma coleção da View
			DepartmentListController controller = loader.getController();
			// processo manual de ingetar dependencia
			controller.setDepartmentService(new DepartmentService()); // ingetando dependencia
			controller.updateTableView(); // chamando os dados para atualizar os dados na tela do table view
		} catch (IOException e) {
			Alerts.showAlert("IOException error", "Error load view", e.getMessage(), AlertType.ERROR);
		}
	}

}

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
		System.out.println("onMenuItemDepartmentAction");
	}

	@FXML
	public void onMenuItemAboutAction() {
		loadView("/gui/About.fxml"); // comando para exibir no console
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

	// para garantir a execu��o sem nenhum comportamento inesperado Usa-se o (Synchronized)
	// Garante que o processamento n�o vai ser interrompido
	public synchronized void loadView(String loadview) { 
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(loadview));
			VBox newVbox = loader.load();
			Scene mainscene = Main.getMainScene();
			VBox mainVbox = (VBox) ((ScrollPane) mainscene.getRoot()).getContent();// pegando do primeiro elemento da View

			Node mainMenu = mainVbox.getChildren().get(0); // pegando do primeiro elemento do Children
			mainVbox.getChildren().clear();
			mainVbox.getChildren().add(mainMenu);
			mainVbox.getChildren().addAll(newVbox.getChildren());//adicionando uma cole��o da da View
		} catch (IOException e) {
			Alerts.showAlert("IOException error", "Error load view", e.getMessage(), AlertType.ERROR);
		}
	}

}

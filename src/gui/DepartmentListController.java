package gui;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;

public class DepartmentListController implements Initializable {
	@FXML
	private Button btnDepartmentNew;
	@FXML
	private TableView<Department> tableViewDepartment;
	@FXML
	private TableColumn<Department, Integer> tableColumnID;
	@FXML
	private TableColumn<Department, String> tableColumnName;

	@FXML
	public void onBtDepartmentNewAction() {
		System.out.println("Button New ");
	}

	@FXML
	public void onColumnIdAction() {
		String name = "Ola!";
				tableColumnID.setText(name);
		System.out.println(name);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();

	}
    // método para iniciar o comportamento das colunas
	private void initializeNodes() {
		tableColumnID.setCellValueFactory(new PropertyValueFactory<>("Id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("Name"));
		
		// Macete para fazer a tebleView Acompanhar a altura da janela 
          Stage stage = (Stage) Main.getMainScene().getWindow(); // Window é uma super classe do Stage por isso o DawCast
          tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());// pegando o heigtProperty do Stage

	}

}

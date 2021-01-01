package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable {
	private DepartmentService depService; // dependencia
	private ObservableList<Department> obsList; // carregar a lista de Department
	@FXML
	private Button btnDepartmentNew;
	@FXML
	private TableView<Department> tableViewDepartment;
	@FXML
	private TableColumn<Department, Integer> tableColumnID;
	@FXML
	private TableColumn<Department, String> tableColumnName;

	// Médoto de ingeção de dependencia do departmentService
	public void setDepartmentService(DepartmentService service) { // principio sólid
		this.depService = service;
	}

	@FXML
	public void onBtDepartmentNewAction() {
		System.out.println("Button New ");
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
																// com o Stage
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());// pegando o heigtProperty do Stage

	}

	public void updateTableView() {
		if (depService == null) {
			throw new IllegalArgumentException("Deparment Service was null");
		}
		List<Department> list = depService.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewDepartment.setItems(obsList);
	}

}

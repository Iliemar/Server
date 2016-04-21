package application;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Adult;
import model.Traveler;

public class ChangeBookScene2Controller implements Initializable {

	@FXML
	private Button exitBtn;

	@FXML
	private Button bookBtn;

	@FXML
	private Button myTripsBtn;

	@FXML
	private TableView<Traveler> tableView;

	@FXML
	private TableColumn<Traveler, String> lastNameCollum;

	@FXML
	private Button changeBookingBtn;

	@FXML
	private Label label;

	@FXML
	private AnchorPane anchorPane1;

	@FXML
	private TableColumn<Traveler, String> personalNumberCollum;

	@FXML
	private AnchorPane anchorPane2;

	@FXML
	private TableColumn<Traveler, String> firstNameCollum;

	@FXML
	private HBox hbox;

	@FXML
	private HBox calendarBox;

	@FXML
	private Button backBtn;

	@FXML
	private Button cancelFlightBtn;

	@FXML
	private TableColumn<Traveler, String> disabilitesCollum;

	@FXML
	private Button nextBtn;

	private Client client;

	private final ObservableList<Traveler> list = FXCollections.observableArrayList();

	@FXML
	void changeSceneActionEvent(ActionEvent event) throws IOException {

		if (event.getSource() == bookBtn) {

			Parent p = FXMLLoader.load(getClass().getResource("Scene1FXML.fxml"));
			Scene s = new Scene(p);
			s.setFill(Color.TRANSPARENT);
			Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

			stg.setScene(s);
			stg.show();

		} else if (event.getSource() == changeBookingBtn) {

			Parent p = FXMLLoader.load(getClass().getResource("ChangeBookScene.fxml"));
			Scene s = new Scene(p);
			s.setFill(Color.TRANSPARENT);
			Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

			stg.setScene(s);
			stg.show();

		} else if (event.getSource() == myTripsBtn) {

			Parent p = FXMLLoader.load(getClass().getResource("MyTripsScene.fxml"));
			Scene s = new Scene(p);
			s.setFill(Color.TRANSPARENT);
			Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

			stg.setScene(s);
			stg.show();

		} else if (event.getSource() == cancelFlightBtn) {

			Parent p = FXMLLoader.load(getClass().getResource("CancelFlightScene.fxml"));
			Scene s = new Scene(p);
			s.setFill(Color.TRANSPARENT);
			Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

			stg.setScene(s);
			stg.show();

		}

	}

	@FXML
	void exit(ActionEvent event) {
		if (event.getSource() == exitBtn) {
			System.exit(0);
		}
	}

	// Byt min scene path till changebookScene1
	@FXML
	void backActionEvent(ActionEvent event) throws IOException {

		Parent p = FXMLLoader.load(getClass().getResource("ChangeBookScene.fxml"));
		Scene s = new Scene(p);
		Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

		stg.setScene(s);
		stg.show();
	}

	/////////// SPara saker
	@FXML
	void nextActionEvent(ActionEvent event) {

	}

	@FXML
	void handleEditActionFirstname(CellEditEvent<Traveler, String> t) {

	}

	@FXML
	void handleEditActionLastname(ActionEvent event) {

	}

	@FXML
	void handleEditActionPersonalNumber(ActionEvent event) {

	}

	@FXML
	void handleEditActionDisabilites(ActionEvent event) {

	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	/*
		
		List<Traveler> travelerList = (List<Traveler>) ChangeBookSceneController.selectedBooking.getTravelerList();
		for(int i = 0; i < travelerList.size(); i++)
		{
			list.add(travelerList.get(i));
		}
*/

		// CellFactory for the collums
		firstNameCollum.setCellValueFactory(new PropertyValueFactory<Traveler, String>("Firstname"));
		lastNameCollum.setCellValueFactory(new PropertyValueFactory<Traveler, String>("Lastname"));
		personalNumberCollum.setCellValueFactory(new PropertyValueFactory<Traveler, String>("Personalnumber"));
		disabilitesCollum.setCellValueFactory(new PropertyValueFactory<Traveler, String>("DisabilitiesorAllergies"));

		// adding list to TableView
		tableView.setItems(list);

		// To change items in the List, by textfields
		firstNameCollum.setCellFactory(TextFieldTableCell.forTableColumn());
		lastNameCollum.setCellFactory(TextFieldTableCell.forTableColumn());
		personalNumberCollum.setCellFactory(TextFieldTableCell.forTableColumn());
		disabilitesCollum.setCellFactory(TextFieldTableCell.forTableColumn());

	}

}

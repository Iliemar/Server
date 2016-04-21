package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Booking;
import model.Traveler;

import javax.swing.JOptionPane;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

public class Scene5Controller implements Initializable {

	@FXML
	private Button exitBtn;

	@FXML
	private Button bookBtn;

	@FXML
	private Button myTripsBtn;

	@FXML
	private Button changeBookingBtn;

	@FXML
	private AnchorPane anchorPane1;

	@FXML
	private TextField cardHolderFld;

	@FXML
	private AnchorPane anchorPane2;

	@FXML
	private TextField creditCardNumberFld;

	@FXML
	private ComboBox<Integer> comboBoxMonth;

	@FXML
	private HBox hbox;

	@FXML
	private HBox hBox1;

	@FXML
	private Button backBtn;

	@FXML
	private TextField cscFld;

	@FXML
	private ComboBox<Integer> comboBoxYear;

	@FXML
	private Button cancelFlightBtn;

	@FXML
	private Label errorLabel;

	@FXML
	private Button nextBtn;

	// Controll value
	private String cardHolder;
	private long CardNumber;
	private int monthNumber;
	private int yearNumber;
	private int cscNumber;
	private Client client;

	@FXML
	void changeSceneActionEvent(ActionEvent event) throws IOException {
		// when user clicks on one of the scene alteratives
		if (event.getSource() == bookBtn) {
			JOptionPane.showMessageDialog(null, "Load BookScene!");
			Parent p = FXMLLoader.load(getClass().getResource("Scene1FXML.fxml"));
			Scene s = new Scene(p);
			Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

			stg.setScene(s);
			stg.show();

		} else if (event.getSource() == changeBookingBtn) {
			JOptionPane.showMessageDialog(null, "Load ChangeBookScene!");
			Parent p = FXMLLoader.load(getClass().getResource("ChangeBookScene.fxml"));
			Scene s = new Scene(p);
			Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

			stg.setScene(s);
			stg.show();

		} else if (event.getSource() == myTripsBtn) {
			JOptionPane.showMessageDialog(null, "Load MyTripsScene!");
			Parent p = FXMLLoader.load(getClass().getResource("MyTripsScene.fxml"));
			Scene s = new Scene(p);
			Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

			stg.setScene(s);
			stg.show();

		} else if (event.getSource() == cancelFlightBtn) {
			JOptionPane.showMessageDialog(null, "Load Cancel Flight Scene!");
			Parent p = FXMLLoader.load(getClass().getResource("CancelFlightScene.fxml"));
			Scene s = new Scene(p);
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

	@FXML
	void nextActionEvent(ActionEvent event) throws NumberFormatException, IOException {

		errorLabel.setText("");
		if (cardHolderFld.getText().equals("")) {
			errorLabel.setText("Please fill in Cardholder name");
		}

		if (creditCardNumberFld.getText().equals("")) {
			errorLabel.setText("Please fill in Card number");
		}

		if (cscFld.getText().equals("")) {
			errorLabel.setText("Please fill in CSC number");
		}

		try {

			cardHolder = cardHolderFld.getText();
			CardNumber = Long.parseLong(creditCardNumberFld.getText());
			cscNumber = Integer.parseInt(cscFld.getText());
			yearNumber = comboBoxYear.getValue();
			monthNumber = comboBoxMonth.getValue();

			if (CardNumber <= 99999999) {
				errorLabel.setText("Please fill in correct Card number");
				return;

			} else if (cscNumber >= 1000) {
				errorLabel.setText("Please fill in correct CSC/CVV number");
				return;

			} else if (cscNumber <= 99) {
				errorLabel.setText("Please fill in correct CSC/CVV number");
				return;

			} else {
				JOptionPane.showMessageDialog(null, "CardHolder: " + cardHolder + "\n" + "CardNumber: " + CardNumber
						+ "\n" + "Card Info: " + monthNumber + "/" + yearNumber + " CSC: " + cscNumber);
				
				Booking booking = new Booking();
				booking.setStartDestination(Scene1Controller.fromDestination);
				booking.setEndDestination(Scene1Controller.toDestination);
				booking.setFlightCompany(Scene2Controller.flightCompany);
				for(int i = 0; i < Scene3Controller.travelerList.size(); i++)
				{
					booking.getTravelerList().add(Scene3Controller.travelerList.get(i));
				}
				System.out.println(booking.getStartDestination());
				System.out.println(booking.getEndDestination());
				System.out.println(booking.getFlightCompany().getName());
				List<Traveler> list = (List<Traveler>) booking.getTravelerList();
				for(int i = 0; i < list.size(); i++)
				{
					System.out.println(list.get(i).getFirstName());
				}
				
				client = ClientBuilder.newClient();
				Booking b = client.target("http://localhost:8080/FlightBookingSystem/webapi/bookings").request().post(Entity.entity(booking, MediaType.APPLICATION_JSON), Booking.class);
				
				Parent p = FXMLLoader.load(getClass().getResource("Scene6FXML.fxml"));
				Scene s = new Scene(p);
				s.setFill(Color.TRANSPARENT);

				Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

				stg.setScene(s);
				stg.show();
			}

		} catch (NumberFormatException FormatTmp) {

			errorLabel.setText("Please fill in correct information");
		}

	}

	@FXML
	void backActionEvent(ActionEvent event) throws IOException {
		if (event.getSource() == backBtn) {
			// when user clicks back
			Parent p = FXMLLoader.load(getClass().getResource("Scene3FXML.fxml"));
			Scene s = new Scene(p);
			Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

			stg.setScene(s);
			stg.show();
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// hide labels and field
		errorLabel.setText("");
		creditCardNumberFld.clear();
		cardHolderFld.clear();

		// ComboBox Year
		comboBoxYear.getItems().add(2016);
		comboBoxYear.getItems().add(2017);
		comboBoxYear.getItems().add(2018);
		comboBoxYear.getItems().add(2019);
		comboBoxYear.getItems().add(2020);
		comboBoxYear.getItems().add(2021);
		comboBoxYear.getItems().add(2022);
		comboBoxYear.getItems().add(2023);
		comboBoxYear.setValue(2016); // Default

		// Combobox Month
		comboBoxMonth.getItems().add(1);
		comboBoxMonth.getItems().add(2);
		comboBoxMonth.getItems().add(3);
		comboBoxMonth.getItems().add(4);
		comboBoxMonth.getItems().add(5);
		comboBoxMonth.getItems().add(6);
		comboBoxMonth.getItems().add(7);
		comboBoxMonth.getItems().add(8);
		comboBoxMonth.getItems().add(9);
		comboBoxMonth.getItems().add(10);
		comboBoxMonth.getItems().add(11);
		comboBoxMonth.getItems().add(12);
		comboBoxMonth.setValue(01); // Default

	}
}
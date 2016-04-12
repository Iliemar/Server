/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Booking;

import javax.swing.JOptionPane;

public class Scene1Controller implements Initializable {

	static String ticketClass;

	@FXML
	private Button searchBtn;

	@FXML
	private Button minusKidBtn;

	@FXML
	private Button bookBtn;

	@FXML
	private Button myTripsBtn;

	@FXML
	private Button changeBookingBtn;

	@FXML
	private ComboBox<String> tripTypeComboBox;

	@FXML
	private Button plusAdultBtn;

	@FXML
	private HBox calendar1Box;

	@FXML
	private ComboBox<String> fromComboBox;

	@FXML
	private ComboBox<String> ticketClassComboBox;

	@FXML
	private Label currentAdultsLabel;

	@FXML
	private ComboBox<String> toComboBox;

	@FXML
	private Button minusAdultBtn;

	@FXML
	private Button plusKidBtn;

	@FXML
	private Label currentKidLabel;

	@FXML
	private Button cancelFlightBtn;

	@FXML
	private Label errorDestinationLabel;

	@FXML
	private HBox calendar2Box;

	@FXML
	private Label passengerErrorLabel;

	@FXML
	private Button exitBtn;

	private static String fromLocation;
	private static String toLocation;
	public static int adult = 0; // order counter
	public static int kids = 0;
	private static int maxbook = 5; // max bookings
	static Booking b1;

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
	void searchActionEvent(ActionEvent event) throws IOException {
		// when user clicks on Search
		if (event.getSource() == searchBtn) {
			errorDestinationLabel.setText(""); // hide error label

			if (toComboBox.getValue().equals("Please Select Destination")) {
				errorDestinationLabel.setText("Please fill in destinations");

			} else if (fromComboBox.getValue().equals("Please Select Destination")) {
				errorDestinationLabel.setText("Please fill in destinations");
			} else {
				// create trip
				b1 = new Booking(1, fromComboBox.getValue(), toComboBox.getValue(), adult, kids, 0, "", 0);

				Parent p = FXMLLoader.load(getClass().getResource("Scene2FXML.fxml"));
				Scene s = new Scene(p);
				Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

				stg.setScene(s);
				stg.show();

			}
		}

	}

	@FXML
	void exit(ActionEvent e) {
		if (e.getSource() == exitBtn) {
			System.exit(0);
		}
	}

	@FXML
	void passengersActionEvent(ActionEvent event) {
		errorDestinationLabel.setText("");// hide error
		passengerErrorLabel.setText("");// hide error labelss
		// when user clicks on minus or + button
		passengerErrorLabel.setText(""); // hide error label
		if (event.getSource() == minusAdultBtn) {

			if (adult == 0) {
				passengerErrorLabel.setText("You cant go under 0 passengers");
			} else {

				adult -= 1;
				currentAdultsLabel.setText(String.valueOf(adult));
			}

		} else if (event.getSource() == plusAdultBtn) {

			if (adult == maxbook) {
				passengerErrorLabel.setText("You allready got max adults");
			} else {

				adult += 1;
				currentAdultsLabel.setText(String.valueOf(adult));
			}

		} else if (event.getSource() == minusKidBtn) {
			if (kids == 0) {
				passengerErrorLabel.setText("You cant go under 0 passengers");
			} else {
				kids -= 1;
				currentKidLabel.setText(String.valueOf(kids));
			}

		} else if (event.getSource() == plusKidBtn) {
			if (kids == maxbook) {
				passengerErrorLabel.setText("You allready got max kids");
			} else {
				kids += 1;
				currentKidLabel.setText(String.valueOf(kids));
			}

		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		bookBtn.setDisable(true);
		ticketClass = "" + BookingType.ECONOMY; // Start value

		ticketClassComboBox.setOnAction(event -> {
			if (ticketClassComboBox.getValue().equals("Economy")) {
				// ticketClass.equals(BookingType.ECONOMY);
				ticketClass = "" + BookingType.ECONOMY;

			} else if (ticketClassComboBox.getValue().equals("Business class")) {
				// ticketClass.equals(BookingType.BUSINESS);
				ticketClass = "" + BookingType.BUSINESS;

			} else if (ticketClassComboBox.getValue().equals("First class")) {
				// ticketClass.equals(BookingType.FIRSTCLASS);
				ticketClass = "" + BookingType.FIRSTCLASS;

			}
		});

		// Default label for x adults,kids,handicaped
		currentAdultsLabel.setText(String.valueOf(adult));
		currentKidLabel.setText(String.valueOf(kids));
		passengerErrorLabel.setText(""); // hide error message
		errorDestinationLabel.setText("");// hide error message

		// Create First Calendar
		DatePicker datePicker = new DatePicker();
		datePicker.setValue(LocalDate.now());
		datePicker.setOnAction(event -> {
			LocalDate date = datePicker.getValue();
			// JOptionPane.showMessageDialog(null, date);

		});

		// create Calendar2 for HomeTrip
		DatePicker datePicker2 = new DatePicker();
		datePicker2.setVisible(false); // Hide at start
		datePicker2.setValue(LocalDate.now());
		datePicker2.setOnAction(event -> {
			LocalDate date = datePicker2.getValue();
			// JOptionPane.showMessageDialog(null, "Calendar 2 " + date);
		});

		// add calendars to the boxes
		calendar1Box.getChildren().add(datePicker);
		calendar2Box.getChildren().add(datePicker2);

		// comboBox for Enter origing city
		fromComboBox.getItems().add("Malmö");
		fromComboBox.getItems().add("Köpenhamn");
		fromComboBox.setValue("Please Select Destination");

		// comboBox for Enter Destination city
		toComboBox.getItems().add("Oslo");
		toComboBox.getItems().add("London");
		toComboBox.setValue("Please Select Destination");

		// comboBox for Trip Type - add diffrent types of trip
		tripTypeComboBox.getItems().add("One-way trip");
		tripTypeComboBox.getItems().add("Return trip");
		tripTypeComboBox.setValue("One-way trip"); // default trip
		tripTypeComboBox.setOnAction(event -> {
			if (tripTypeComboBox.getValue().equals("One-way trip")) {
				datePicker2.setVisible(false);
			} else {
				datePicker2.setVisible(true);
			}
		});

		// comboBox for TicketClass - Add diffrent classes
		ticketClassComboBox.getItems().add("Economy");
		ticketClassComboBox.getItems().add("Business class");
		ticketClassComboBox.getItems().add("First class");
		ticketClassComboBox.setValue("Economy"); // default class

	}

}

package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Adult;
import model.Child;
import model.Traveler;

import javax.swing.JOptionPane;

public class Scene3Controller implements Initializable {

	@FXML
	private TextField lastnameFld;

	@FXML
	private Button exitBtn;

	@FXML
	private Button myTripsBtn;

	@FXML
	private CheckBox checkBoxFood;

	@FXML
	private AnchorPane anchorPane1;

	@FXML
	private AnchorPane anchorPane2;

	@FXML
	private TextField firstnameFld;

	@FXML
	private Label labelSpacePrice;

	@FXML
	private HBox hbox;

	@FXML
	private Label maxPersonCounterLabel;

	@FXML
	private CheckBox checkBoxExtraSpace;

	@FXML
	private Button cancelFlightBtn;

	@FXML
	private CheckBox checkBoxPlug;

	@FXML
	private Button bookBtn;

	@FXML
	private TextField handicapFld;

	@FXML
	private Label handicapLabel;

	@FXML
	private Button changeBookingBtn;

	@FXML
	private TextField pnrFld;

	@FXML
	private CheckBox checkBoxWifi;

	@FXML
	private Label labelFoodPrice;

	@FXML
	private Label labelPlugPrice;

	@FXML
	private Label labelWifiPrice;

	@FXML
	private Button backBtn;

	@FXML
	private Label errorLabel;

	@FXML
	private Button nextBtn;

	@FXML
	private Label firstnameLabel;

	@FXML
	private Label lastnameLabel;

	@FXML
	private Label personalnumberLabel;

	@FXML
	private Label currentPersonCounterLabel;

	public static double ExtraCost = 0; // all extra in cash
	private static int currentPersonCounter = 1;
	private int maxAdults = 0;
	private int maxChildren = 0;
	public static List<Traveler> travelerList = new ArrayList<Traveler>();

	private static int TotalTravelers;
	// price for extra items
	private double FoodPrice = 120.00;
	private double PlugPrice = 50.00;
	private double SpacePrice = 75.00;
	private double WifiPrice = 45.00;

	// CheckBox values with boolean
	private boolean wifi;
	private boolean food;
	private boolean extraSpace;
	private boolean Plug;

	@FXML
	void exit(ActionEvent event) {
		if (event.getSource() == exitBtn) {
			System.exit(0);
		}
	}

	@FXML
	void changeSceneActionEvent(ActionEvent event) throws IOException {
		// when user clicks on one of the scene alteratives
		if (event.getSource() == bookBtn) {
			//JOptionPane.showMessageDialog(null, "Load BookScene!");
			Parent p = FXMLLoader.load(getClass().getResource("Scene1FXML.fxml"));
			Scene s = new Scene(p);
			s.setFill(Color.TRANSPARENT);
			Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

			stg.setScene(s);
			stg.show();

		} else if (event.getSource() == changeBookingBtn) {
			//JOptionPane.showMessageDialog(null, "Load ChangeBookScene!");
			Parent p = FXMLLoader.load(getClass().getResource("ChangeBookScene.fxml"));
			Scene s = new Scene(p);
			s.setFill(Color.TRANSPARENT);
			Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

			stg.setScene(s);
			stg.show();

		} else if (event.getSource() == myTripsBtn) {
			//JOptionPane.showMessageDialog(null, "Load MyTripsScene!");
			Parent p = FXMLLoader.load(getClass().getResource("MyTripsScene.fxml"));
			Scene s = new Scene(p);
			s.setFill(Color.TRANSPARENT);
			Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

			stg.setScene(s);
			stg.show();

		} else if (event.getSource() == cancelFlightBtn) {
			//JOptionPane.showMessageDialog(null, "Load Cancel Flight Scene!");
			Parent p = FXMLLoader.load(getClass().getResource("CancelFlightScene.fxml"));
			Scene s = new Scene(p);
			s.setFill(Color.TRANSPARENT);
			Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

			stg.setScene(s);
			stg.show();
		}

	}

	@FXML
	void backActionEvent(ActionEvent event) throws IOException {
		if (event.getSource() == backBtn) {
			// when user clicks back
			Parent p = FXMLLoader.load(getClass().getResource("Scene2FXML.fxml"));
			Scene s = new Scene(p);
			s.setFill(Color.TRANSPARENT);
			Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

			stg.setScene(s);
			stg.show();
		}
	}

	@FXML
	void nextActionEvent(ActionEvent event) throws IOException {
		// Label Basic Fill.
		firstnameLabel.setStyle("-fx-text-fill:#3f3c3c;");
		lastnameLabel.setStyle("-fx-text-fill:#3f3c3c;");
		personalnumberLabel.setStyle("-fx-text-fill:#3f3c3c;");
		errorLabel.setText(""); // hide error message

		if (firstnameFld.getText().equals("")) {
			errorLabel.setText("Please fill in all the fields.");
			firstnameLabel.setStyle("-fx-text-fill:RED;");
		} else if (lastnameFld.getText().equals("")) {
			errorLabel.setText("Please fill in all the fields.");
			lastnameLabel.setStyle("-fx-text-fill:RED;");
		} else if (pnrFld.getText().equals("")) {
			errorLabel.setText("Please fill in all the fields.");
			personalnumberLabel.setStyle("-fx-text-fill:RED;");
		} else if (pnrFld.getLength() != 12) {
			errorLabel.setText("Please fill in YYYY/MM/DD-XXXX");
			personalnumberLabel.setStyle("-fx-text-fill:RED;");

		} else {

			// Calculates extra cost items for economy class
			if (Scene1Controller.ticketClass.equals("" + BookingType.ECONOMY)) {
				if (wifi == true) {
					ExtraCost = WifiPrice += ExtraCost;
				}

				if (food == true) {
					ExtraCost = FoodPrice += ExtraCost;
				}

				if (extraSpace == true) {
					ExtraCost = SpacePrice += ExtraCost;
				}

				if (Plug == true) {
					ExtraCost = PlugPrice += ExtraCost;
				}
			}

			// Calculates extra cost items for Business
			if (Scene1Controller.ticketClass.equals("" + BookingType.BUSINESS)) {
				if (food == true) {
					ExtraCost = FoodPrice += ExtraCost;
				}

				if (extraSpace == true) {
					ExtraCost = SpacePrice += ExtraCost;
				}
			}

			/*JOptionPane.showMessageDialog(null,
					firstnameFld.getText() + " " + lastnameFld.getText() + "\n" + "PNR: " + pnrFld.getText() + "\n"
							+ "Handicap: " + handicapFld.getText() + "\n" + "Wifi: " + wifi + "\n" + "Food on board: "
							+ food + "\n" + "Extra space: " + extraSpace + "\n" + "Plug 220v: " + Plug + "\n"
							+ "Extra cost: " + ExtraCost);*/
			// ______________________________________________
			// After the Save !!
			int year = Integer.parseInt(pnrFld.getText().substring(0, 3));
			if(year <= 1998)
			{
				if(maxAdults >= Scene1Controller.adult)
				{
					JOptionPane.showMessageDialog(null, "Maximum adults reached!");
				}
				else
				{
					Adult adult = new Adult(firstnameFld.getText(), lastnameFld.getText(), pnrFld.getText(), handicapFld.getText());
					travelerList.add(adult);
					maxAdults++;
					System.out.println(adult.getFirstName());
				}
			}
			else
			{
				if(maxChildren >= Scene1Controller.kids)
				{
					JOptionPane.showMessageDialog(null, "Maximum children reached!");
				}
				else
				{
					Child child = new Child(firstnameFld.getText(), lastnameFld.getText(), pnrFld.getText(), handicapFld.getText());
					travelerList.add(child);
					maxChildren++;
					System.out.println(child.getFirstName());
				}
			}

			// Controll if all persons are filld in
			if (currentPersonCounter == TotalTravelers) {
				Parent p = FXMLLoader.load(getClass().getResource("Scene4FXML.fxml"));
				Scene s = new Scene(p);
				s.setFill(Color.TRANSPARENT);

				Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

				stg.setScene(s);
				stg.show();

			}
			currentPersonCounter += 1; // make counter +1 + update label
			currentPersonCounterLabel.setText(String.valueOf(currentPersonCounter));

			// clear fields + checkbox
			firstnameFld.clear();
			lastnameFld.clear();
			pnrFld.clear();
			handicapFld.clear();
			checkBoxWifi.setSelected(false);
			checkBoxFood.setSelected(false);
			checkBoxExtraSpace.setSelected(false);
			checkBoxPlug.setSelected(false);

		}
	}

	@FXML
	void CheckBoxEvent(ActionEvent event) {
		// Controll wifi
		if (checkBoxWifi.isSelected()) {
			wifi = true;
		} else {
			wifi = false;
		}

		// Controll food
		if (checkBoxFood.isSelected()) {
			food = true;
		} else {
			food = false;
		}

		// controll extraSpcae
		if (checkBoxExtraSpace.isSelected()) {
			extraSpace = true;
		} else {
			extraSpace = false;
		}

		// controll is extraPlug
		if (checkBoxPlug.isSelected()) {
			Plug = true;
		} else {
			Plug = false;
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		// Get xAduls xKids and makes them together
		int xAdult = (Scene1Controller.adult);
		int xKids = (Scene1Controller.kids);
		TotalTravelers = xAdult += xKids;

		// labels
		errorLabel.setText("");
		currentPersonCounterLabel.setText(String.valueOf(currentPersonCounter));
		maxPersonCounterLabel.setText(String.valueOf(TotalTravelers));

		// Price for extra items label
		labelFoodPrice.setText(String.valueOf(FoodPrice) + " :- kr");
		labelPlugPrice.setText(String.valueOf(PlugPrice) + " :- kr");
		labelSpacePrice.setText(String.valueOf(SpacePrice) + " :- kr");
		labelWifiPrice.setText(String.valueOf(WifiPrice) + " :- kr");

		// Label Basic Fill.
		errorLabel.setStyle("-fx-text-fill:#c60101;");
		firstnameLabel.setStyle("-fx-text-fill:#3f3c3c;");
		lastnameLabel.setStyle("-fx-text-fill:#3f3c3c;");
		personalnumberLabel.setStyle("-fx-text-fill:#3f3c3c;");

		if (Scene1Controller.ticketClass.equals("" + BookingType.FIRSTCLASS)) {

			// Auto Check
			checkBoxWifi.setSelected(true);
			checkBoxFood.setSelected(true);
			checkBoxExtraSpace.setSelected(true);
			checkBoxPlug.setSelected(true);

			// Lock CheckBox
			checkBoxWifi.setDisable(true);
			checkBoxFood.setDisable(true);
			checkBoxExtraSpace.setDisable(true);
			checkBoxPlug.setDisable(true);

			// Change the boleans
			wifi = true;
			food = true;
			extraSpace = true;
			Plug = true;
		}

		else if (Scene1Controller.ticketClass.equals("" + BookingType.BUSINESS)) {

			// Auto Check
			checkBoxWifi.setSelected(true);
			checkBoxPlug.setSelected(true);

			// Lock CheckBox
			checkBoxWifi.setDisable(true);
			checkBoxPlug.setDisable(true);

			// Change the boleans
			wifi = true;
			Plug = true;

		} else if (Scene1Controller.ticketClass.equals("" + BookingType.ECONOMY)) {

		}

	}
}

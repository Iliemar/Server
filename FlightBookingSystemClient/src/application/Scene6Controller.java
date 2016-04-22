package application;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Scene6Controller implements Initializable {

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
	private AnchorPane anchorPane2;
	@FXML
	private HBox hbox;
	@FXML
	private HBox hBox1;
	@FXML
	private Button backBtn;
	@FXML
	private Button cancelFlightBtn;
	@FXML
	private Label errorLabel;
	@FXML
	private Label fromLbl;
	@FXML
	private Label toLbl;
	@FXML
	private Label flightLbl;
	@FXML
	private Label dateLbl;
	@FXML
	private Label dateLbl2;
	@FXML
	private Label amountLbl;
	@FXML
	private Button nextBtn;
	@FXML
	void changeSceneActionEvent(ActionEvent event) throws IOException {
		// when user clicks on one of the scene alteratives
		if (event.getSource() == bookBtn) {
			//JOptionPane.showMessageDialog(null, "Load BookScene!");
			Parent p = FXMLLoader.load(getClass().getResource("Scene1FXML.fxml"));
			Scene s = new Scene(p);
			Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

			stg.setScene(s);
			stg.show();
			
		} else if (event.getSource() == changeBookingBtn) {
			//JOptionPane.showMessageDialog(null, "Load ChangeBookScene!");
			Parent p = FXMLLoader.load(getClass().getResource("ChangeBookScene.fxml"));
			Scene s = new Scene(p);
			Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

			stg.setScene(s);
			stg.show();

		} else if (event.getSource() == myTripsBtn) {
			//JOptionPane.showMessageDialog(null, "Load MyTripsScene!");
			Parent p = FXMLLoader.load(getClass().getResource("MyTripsScene.fxml"));
			Scene s = new Scene(p);
			Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

			stg.setScene(s);
			stg.show();

		} else if (event.getSource() == cancelFlightBtn) {
			//JOptionPane.showMessageDialog(null, "Load Cancel Flight Scene!");
			Parent p = FXMLLoader.load(getClass().getResource("CancelFlightScene.fxml"));
			Scene s = new Scene(p);
			Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

			stg.setScene(s);
			stg.show();
		}
	}
	@FXML
	void nextActionEvent(ActionEvent event) throws NumberFormatException, IOException {
		Parent p = FXMLLoader.load(getClass().getResource("Scene1FXML.fxml"));
		Scene s = new Scene(p);
		s.setFill(Color.TRANSPARENT);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(s);
		stage.show();
	}
	@FXML
	void exit(ActionEvent event) {
		if (event.getSource() == exitBtn) {
			System.exit(0);
		}
	}
	@FXML
	void backActionEvent(ActionEvent event) throws IOException {
		if (event.getSource() == backBtn) {
			// when user clicks back
			Parent p = FXMLLoader.load(getClass().getResource("Scene5FXML.fxml"));
			Scene s = new Scene(p);
			Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

			stg.setScene(s);
			stg.show();
		}
	}
	String to = Scene1Controller.toDestination;
	String from = Scene1Controller.fromDestination;
	Date d = new Date();
	static LocalDate firstDate = Scene1Controller.firstDate;
	static LocalDate lastDate = Scene1Controller.lastDate;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		fromLbl.setText("From: " + from + " to: " + to);
		toLbl.setText("Return: " + to + " to: " + from);
		dateLbl.setText("Date: " + firstDate);
		dateLbl2.setText("Return date: " + lastDate);
		amountLbl.setText("Amount of persons traveling: " + (Scene1Controller.adult + Scene1Controller.kids) 
				+ '\n' + "Number of adults: " + Scene1Controller.adult + '\n' + "Number of kids: " + Scene1Controller.kids);
	}
}
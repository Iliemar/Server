package application;

import java.io.IOException;
import java.net.URL;
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
	private Label amountLbl;
	@FXML
	private Button nextBtn;
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
	void nextActionEvent(ActionEvent event) throws NumberFormatException {

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
			Parent p = FXMLLoader.load(getClass().getResource("Scene3FXML.fxml"));
			Scene s = new Scene(p);
			Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

			stg.setScene(s);
			stg.show();
		}
	}
	static String to = Scene1Controller.toDestination;
	static String from = Scene1Controller.fromDestination;
	Date d = new Date();

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		fromLbl.setText("From: " + to);
		toLbl.setText("To: " + from);
		dateLbl.setText("Date: " + d);
		amountLbl.setText("Amount of persons traveling: " + (Scene1Controller.adult + Scene1Controller.kids) 
				+ '\n' + "Number of adults: " + Scene1Controller.adult + '\n' + "Number of kids: " + Scene1Controller.kids);
	}
}
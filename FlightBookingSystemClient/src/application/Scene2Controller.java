/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.FlightCompany;

import javax.swing.JOptionPane;

public class Scene2Controller implements Initializable {

    @FXML
    private ListView<FlightCompany> listView;

    @FXML
    private Button backBtn;

    @FXML
    private Button nextBtn;
    
    @FXML
	private Button exitBtn;
    @FXML
    private Button bookBtn;
    @FXML
    private Button changeBookingBtn;
    @FXML
    private Button myTripsBtn;
    @FXML
    private Button cancelFlightBtn;


	@FXML
	void exit(ActionEvent event) {
		if (event.getSource() == exitBtn) {
			System.exit(0);
		}
	}


    public ObservableList<FlightCompany> FlightCompanyList = FXCollections.observableArrayList();

    @FXML
    void nextActionEvent(ActionEvent event) throws IOException {
      // when the user click continue 
        JOptionPane.showMessageDialog(null, listView.getSelectionModel().getSelectedItem());
        Parent p = FXMLLoader.load(getClass().getResource("/application/Scene3FXML.fxml"));
        Scene s = new Scene(p);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stg.setScene(s);
        stg.show();
        
    }

    @FXML
    void backActionEvent(ActionEvent event) throws IOException {
        // when user click back btn
        Parent p = FXMLLoader.load(getClass().getResource("Scene1FXML.fxml"));
        Scene s = new Scene(p);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stg.setScene(s);
        stg.show();

    }
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // creating dummy data FlightCompany
        FlightCompany SAS = new FlightCompany(1, "SAS", Scene1Controller.b1.getFromDestination(), Scene1Controller.b1.getToDestination(), 4500);
        FlightCompany WizzAir = new FlightCompany(1, "WizzAir", Scene1Controller.b1.getFromDestination(), Scene1Controller.b1.getToDestination(), 2500);
        FlightCompany TurkishAirlines = new FlightCompany(1, "TurkishAirLines", Scene1Controller.b1.getFromDestination(), Scene1Controller.b1.getToDestination(), 3500);

        FlightCompanyList.add(SAS);
        FlightCompanyList.add(WizzAir);
        FlightCompanyList.add(TurkishAirlines);

        // add observerlist FlightCompanyList to the listview
        listView.setItems(FlightCompanyList);
    }

}

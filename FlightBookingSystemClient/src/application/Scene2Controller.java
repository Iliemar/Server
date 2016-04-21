/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

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
import model.Emirates;
import model.FlightCompany;
import model.Norwegian;
import model.SAS;

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
    private Client client;
    public static FlightCompany flightCompany;


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
        flightCompany = listView.getSelectionModel().getSelectedItem();
        System.out.println(flightCompany.getName());
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
    public void initialize(URL url, ResourceBundle rb)
    {
    	client = ClientBuilder.newClient();
    	GenericType<List<FlightCompany>> flights = new GenericType<List<FlightCompany>>(){};
    	List<FlightCompany> flightCompanies = client.target("http://localhost:8080/FlightBookingSystem/webapi/flightcompanies").request(MediaType.APPLICATION_JSON).get(flights);
    	for(int i = 0; i < flightCompanies.size(); i++)
    	{
    		FlightCompanyList.add(flightCompanies.get(i));
    	}
        listView.setItems(FlightCompanyList);
    }

}

package application;


import java.awt.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Adult;
import model.Traveler;
import model.Child;
public class Scene4Controller implements Initializable {
		
		@FXML
		private Label label;
	    @FXML
	    private HBox hbox;
	    @FXML
	    private Button exitBtn;

	   
	    @FXML private TableView<Traveler> tableView;
	    @FXML private TableColumn<Traveler,String>firstName;
	    @FXML private TableColumn<Traveler,String>lastName;
	    @FXML private TableColumn<Traveler,String>persNR;
	    @FXML private TableColumn<Traveler,String>handicap;
	   

	    @FXML
	    private Button backBtn;

	    @FXML
	    private Button bookBtn;

	    @FXML
	    private Button myTripsBtn;

	    @FXML
	    private Button changeTravelerBtn;

	    @FXML
	    private AnchorPane anchorPane1;

	    @FXML
	    private Button cancelFlightBtn;

	    @FXML
	    private AnchorPane anchorPane2;

	    @FXML
	    private Button nextBtn;
	    
	    public ObservableList<Traveler>ChangeTravelerList=FXCollections.observableArrayList(
	    		
	    
	    		);
	    
	    
	    
	    @FXML
		void exit(ActionEvent e){
			if(e.getSource()==exitBtn){
				System.exit(0);
			}
		}

	    @FXML
	    void backActionEvent(ActionEvent event) throws IOException {
	    	  if (event.getSource() == backBtn) {
		            JOptionPane.showMessageDialog(null, "Back to Traveler!");
		            Parent p = FXMLLoader.load(getClass().getResource("Scene1FXML.fxml"));
		            Scene s = new Scene(p);
		            Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

		            stg.setScene(s);
		            stg.show();
	    	  }
	    }

	    @FXML
	    void nextActionEvent(ActionEvent event) throws IOException {
	    	if (event.getSource() == nextBtn) {
	            JOptionPane.showMessageDialog(null, "Travelers confirmed, heading to VISA-payment!");
	            Parent p = FXMLLoader.load(getClass().getResource("Scene5FXML.fxml"));
	            Scene s = new Scene(p);
	            Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

	            stg.setScene(s);
	            stg.show();
	    	}
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


	        } else if (event.getSource() == changeTravelerBtn) {
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
	    private void handleEditActionFirstName(CellEditEvent<Traveler, String> t)
	    {
	        ((Traveler) t.getTableView().getItems().get(t.getTablePosition().getRow())).setFirstName(t.getNewValue());
	    }
		 @FXML
	    private void handleEditActionLastName(CellEditEvent<Traveler, String> t) 
	    {
	        ((Traveler) t.getTableView().getItems().get(t.getTablePosition().getRow())).setLastName(t.getNewValue());
	    }
		 @FXML
	    private void handleEditActionPersNR(CellEditEvent<Traveler, String> t)
	    {
	        ((Traveler) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPersNR(t.getNewValue());
	    }
		@FXML
	    private void handleEditActionHandicap(CellEditEvent<Traveler, String> t) 
	    {
			((Traveler) t.getTableView().getItems().get(t.getTablePosition().getRow())).setHandicap(t.getNewValue());
		}
	    @Override
	    public void initialize(URL url, ResourceBundle rb) {
	    	for(int i = 0; i < Scene3Controller.travelerList.size(); i++)
	        {
	    		String firstname = Scene3Controller.travelerList.get(i).getFirstName();
	         	String lastName = Scene3Controller.travelerList.get(i).getLastName();
	         	String pnr = Scene3Controller.travelerList.get(i).getPersNR();
	         	String handicap = Scene3Controller.travelerList.get(i).getHandicap();
	         
	         	Traveler traveler = new Traveler(firstname, lastName, pnr, handicap);
	         	ChangeTravelerList.add(traveler);
	        }
	        firstName.setCellValueFactory(new PropertyValueFactory<Traveler,String>("firstName"));  
	        lastName.setCellValueFactory(new PropertyValueFactory<Traveler,String>("lastName"));
	        persNR.setCellValueFactory(new PropertyValueFactory<Traveler,String>("persNR"));
	        handicap.setCellValueFactory(new PropertyValueFactory<Traveler,String>("handicap"));
	     
	        tableView.setItems(ChangeTravelerList);
	        
	        firstName.setCellFactory(TextFieldTableCell.forTableColumn());
	        lastName.setCellFactory(TextFieldTableCell.forTableColumn());
	        persNR.setCellFactory(TextFieldTableCell.forTableColumn());
	        handicap.setCellFactory(TextFieldTableCell.forTableColumn());
	
	        firstName.setEditable(true);
	        lastName.setEditable(true);
	        persNR.setEditable(true);
	        handicap.setEditable(true); 
	        tableView.setEditable(true);
	     }     
}
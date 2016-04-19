package application;


import java.awt.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

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
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Booking;


public class MyTripsSceneController implements Initializable {
		
		@FXML
		    private Label label;
		@FXML
		    private TextField text; 
	    @FXML
	    	private HBox hbox;
	    @FXML
	    	private Button exitBtn;

	   
	    @FXML private TableView<Booking> tableView;
	    @FXML private TableColumn<Booking,String>Company;
	    @FXML private TableColumn<Booking,String>From;
	    @FXML private TableColumn<Booking,String>To;
	    @FXML private TableColumn<Booking,java.util.Date>Date;
	    @FXML private TableColumn<Booking,String>Price;
	    @FXML private TableColumn<Booking,String>Direct;
	   

	    @FXML
	    private Button backBtn;

	    @FXML
	    private Button bookBtn;

	    @FXML
	    private Button myTripsBtn;

	    @FXML
	    private Button changeBookingBtn;

	    @FXML
	    private AnchorPane anchorPane1;

	    @FXML
	    private Button cancelFlightBtn;

	    @FXML
	    private AnchorPane anchorPane2;

	    @FXML
	    private Button nextBtn;
	    
	   
	    public ObservableList<Booking>ChangeBookingList=FXCollections.observableArrayList(
	            new Booking("Comp1","Malm�","Oslo","99","yes"),
	            new Booking("Comp2","Malm�","Chicago"," 444","no"),
	            new Booking ("Comp3","Malm�","Bucharest", "88","yes") );
	    
	    
	    
	    @FXML
		void exit(ActionEvent e){
			if(e.getSource()==exitBtn){
				System.exit(0);
			}
		}

	    @FXML
	    void backActionEvent(ActionEvent event) throws IOException {
	    	  if (event.getSource() == backBtn) {
		            JOptionPane.showMessageDialog(null, "Back to Booking!");
		            Parent p = FXMLLoader.load(getClass().getResource("Scene1FXML.fxml"));
		            Scene s = new Scene(p);
		            Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();

		            stg.setScene(s);
		            stg.show();
	    	  }
	    }

	    @FXML
	    void nextActionEvent(ActionEvent event) {

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

   
	    @FXML
	    private void handleEditActionCompany(CellEditEvent<Booking, String> t)
	    {
	        ((Booking) t.getTableView().getItems().get(t.getTablePosition().getRow())).setCompany(t.getNewValue());
	    }
		
		
		 @FXML
	    private void handleEditActionFrom(CellEditEvent<Booking, String> t) 
	    {
	        ((Booking) t.getTableView().getItems().get(t.getTablePosition().getRow())). setStartDestination(t.getNewValue());
	    }
		
		
		 @FXML
	    private void handleEditActionTo(CellEditEvent<Booking, String> t)
	    {
	        ((Booking) t.getTableView().getItems().get(t.getTablePosition().getRow())).setEndDestination(t.getNewValue());
	    }
		
		
		 @FXML
	    private void handleEditActionDate(CellEditEvent<Booking, java.util.Date> t) 
	    {
	        ((Booking) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDate(t.getNewValue());
	    }

		@FXML
	    private void handleEditActionPrice(CellEditEvent<Booking, String> t) 
	    {
			((Booking) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPrice(t.getNewValue());
		}
		@FXML
	    private void handleEditActionDirect(CellEditEvent<Booking, String> t) 
	    {
			((Booking) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDirect(t.getNewValue());
		}
		
		
		
		
	    @Override
	    public void initialize(URL url, ResourceBundle rb) {

	        Company.setCellValueFactory(new PropertyValueFactory<Booking,String>("company"));  
	        From.setCellValueFactory(new PropertyValueFactory<Booking,String>("from"));
	        To.setCellValueFactory(new PropertyValueFactory<Booking,String>("to"));
	        Date.setCellValueFactory(new PropertyValueFactory<Booking,java.util.Date>("date"));
	        Price.setCellValueFactory(new PropertyValueFactory<Booking,String>("price"));
	        Direct.setCellValueFactory(new PropertyValueFactory<Booking,String>("direct"));
	      
	       
	        tableView.setItems(ChangeBookingList);
	        
	        Company.setCellFactory(TextFieldTableCell.forTableColumn());
	        From.setCellFactory(TextFieldTableCell.forTableColumn());
	        To.setCellFactory(TextFieldTableCell.forTableColumn());
	       // Date.setCellValueFactory(TextFieldTableCell.forTableColumn());
	        Price.setCellFactory(TextFieldTableCell.forTableColumn());
	        Direct.setCellFactory(TextFieldTableCell.forTableColumn());
	

	        Company.setEditable(true);
	        From.setEditable(true);
	        To.setEditable(true);
	        Date.setEditable(true); 
	        Price.setEditable(true);
	        tableView.setEditable(true);
	        Direct.setEditable(true);
	       
	     }     
}


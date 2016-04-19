package application;


import java.awt.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.beans.value.ChangeListener;
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
		private HBox calendarBox;
		 @FXML
		    private Label label;
		 @FXML
		    private TextField text;
		 
		 	private Booking myBooking;
		    private Boolean access= false;
		    
		   /* @FXML
		    private void textAction(ActionEvent event) {
		        if(access){
		            label.setText("Correct name :)");
		        }
		        else{
		            label.setText("Wrong,try again ;)");
		        }
		        
		    }*/
		 
	    @FXML
	    private HBox hbox;
	   

	    @FXML
	    private Button exitBtn;

	    @FXML
	    private TableView<Booking> tableView;
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
	            new Booking("Comp1","Malmö","Oslo","99","45","yes"),
	            new Booking("Comp2","Malmö","Chicago"," 444","45","no"),
	            new Booking ("Comp3","Malmö","Bucharest", "88","45","yes") );
	    
	    
	    
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
	    	
	    	myBooking=new Booking(null, null, null, null, null,"yes");
	    	 text.textProperty().addListener(new ChangeListener<Object>(){
	    		    
	    	     @Override
	    	     public void changed(ObservableValue observable,Object oldVal,Object newVal){
	    	    access=text.getText().equals(myBooking.getId());
	    	
	    	
	        
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

	        Company.setEditable(false);
	        From.setEditable(false);
	        To.setEditable(false);
	        Date.setEditable(false); 
	        Price.setEditable(false);
	        tableView.setEditable(false);
	        Direct.setEditable(false);
	    	     }
		    	});
	     
}
}

package application;


import java.awt.Label;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.converter.DateStringConverter;
import javafx.util.converter.IntegerStringConverter;
import model.Booking;


public class ChangeBookSceneController implements Initializable {
		@FXML
		private HBox calendarBox;
		 @FXML
		    private Label label;
		 @FXML
		    private TextField text;
		 
		 	//private Booking myBooking;
		    private Boolean access= true;
		    
		    @FXML
		    private void textAction(ActionEvent event) {
		        if(access){
		            label.setText("Correct name :)");
		        }
		        else{
		            label.setText("Wrong,try again ;)");
		        }
		        
		    }
		 
	    @FXML
	    private HBox hbox;
	   

	    @FXML
	    private Button exitBtn;

	    @FXML
	    private TableView<Booking> tableView;
	    @FXML private TableColumn<Booking,Integer>Id;
	    @FXML private TableColumn<Booking,java.sql.Date>Date;
	    @FXML private TableColumn<Booking,String>endDestination;
	    @FXML private TableColumn<Booking,Integer>ticketPrice;
	    @FXML private TableColumn<Booking,String>startDestination;
	    

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
	    
	    private static Booking selectedBookning;
	    
	   
	    public ObservableList<Booking>ChangeBookingList=FXCollections.observableArrayList( );
	    
	    
	    
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
	   	    	 selectedBookning=tableView.getSelectionModel().getSelectedItem();
	   	    	 JOptionPane.showMessageDialog(null, selectedBookning);
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
	    private void deleteBooking(ActionEvent d) {
	        Booking selected = tableView.getSelectionModel().getSelectedItem();
	        if (selected != null) 
	        {
	        	ChangeBookingList.remove(selected);
	            JOptionPane.showMessageDialog(null,"Delete succeeded");
	        } else
	        { 
	        	 JOptionPane.showMessageDialog(null,"Please select something before deleting");
	        }
	    }

   
	    @FXML
	    private void handleEditActionId(CellEditEvent<Booking, Integer> t)
	    {
	        ((Booking) t.getTableView().getItems().get(t.getTablePosition().getRow())).setId(t.getNewValue());
	    }
		
		
		 @FXML
	    private void handleEditActionDate(CellEditEvent<Booking, java.sql.Date> t) 
	    {
	        ((Booking) t.getTableView().getItems().get(t.getTablePosition().getRow())). setDate(t.getNewValue());
	    }
		
		
		 @FXML
	    private void handleEditActionEndDestination(CellEditEvent<Booking, String> t)
	    {
	        ((Booking) t.getTableView().getItems().get(t.getTablePosition().getRow())).setEndDestination(t.getNewValue());
	    }
		
		
		 @FXML
	    private void handleEditActionTicketPrice(CellEditEvent<Booking, Integer> t) 
	    {
	        ((Booking) t.getTableView().getItems().get(t.getTablePosition().getRow())).setPrice(t.getNewValue());
	    }

		@FXML
	    private void handleEditActionStartDestination(CellEditEvent<Booking, String> t) 
	    {
			((Booking) t.getTableView().getItems().get(t.getTablePosition().getRow())).setStartDestination(t.getNewValue());
		}
		
		
		
		
		
	    @Override
	    public void initialize(URL url, ResourceBundle rb) {
	    /*	
	    	myBooking=new Booking(null, null, null, null, null,"yes");
	    	 text.textProperty().addListener(new ChangeListener<Object>(){
	    		    
	    	     @Override
	    	     public void changed(ObservableValue observable,Object oldVal,Object newVal){
	    	    access=text.getText().equals(myBooking.getId());*/
	    	
	    	
	        
	    	Id.setCellValueFactory(new PropertyValueFactory<Booking,Integer>("id"));  
	        Date.setCellValueFactory(new PropertyValueFactory<Booking,java.sql.Date>("date"));
	        endDestination.setCellValueFactory(new PropertyValueFactory<Booking,String>("endDestination"));
	        ticketPrice.setCellValueFactory(new PropertyValueFactory<Booking,Integer>("ticketPrice"));
	       startDestination.setCellValueFactory(new PropertyValueFactory<Booking,String>("startDestination"));
	        
	       
	        tableView.setItems(ChangeBookingList);
	        
	        Id.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
	       // Date.setCellValueFactory(TextFieldTableCell.forTableColumn(new DateStringConverter()));
	        endDestination.setCellFactory(TextFieldTableCell.forTableColumn());
	        ticketPrice.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
	        startDestination.setCellFactory(TextFieldTableCell.forTableColumn());

	        Id.setEditable(true);
	        Date.setEditable(true);
	        endDestination.setEditable(true);
	        ticketPrice.setEditable(true); 
	        startDestination.setEditable(true);
	        
	        tableView.setEditable(true);
	      
	    	    
		    	
	        
	     // Create First Calendar
	     			DatePicker datePicker = new DatePicker();
	     			datePicker.setValue(LocalDate.now());
	     			datePicker.setOnAction(event -> {
	     				LocalDate date = datePicker.getValue();
	     				// JOptionPane.showMessageDialog(null, date);

	     			});
	     			calendarBox.getChildren().add(datePicker);
	    
}
}

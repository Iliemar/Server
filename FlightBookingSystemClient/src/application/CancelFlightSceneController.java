package application;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CancelFlightSceneController  implements Initializable {
	
	

    @FXML
    private HBox hbox;

    @FXML
    private Button exitBtn;

    @FXML
    private ListView<?> listView;

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
    
    @FXML
	void exit(ActionEvent e){
		if(e.getSource()==exitBtn){
			System.exit(0);
		}
	}

    @FXML
    void backActionEvent(ActionEvent event) {

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
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}    


}
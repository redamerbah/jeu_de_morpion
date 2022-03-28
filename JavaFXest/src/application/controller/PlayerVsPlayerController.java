package application.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PlayerVsPlayerController {
	@FXML
    private Button ButtonStart_HumanVsIA;

    @FXML
    void StartLoading(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/application/view/StartGameHuman.fxml"));
        Stage stage=new Stage();
        stage.setTitle("LOADING...");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show(); 
        
        /*Parent root= FXMLLoader.load(getClass().getResource("/application/view/PlayerVsIA.fxml"));
    	Stage window=(Stage) IABtn.getScene().getWindow();
    	window.setTitle("Player Vs IA");
    	window.setScene(new Scene(root));*/
    }
}

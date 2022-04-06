package application.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PlayerVsPlayerController {
	@FXML
    private Button ButtonStart_HumanVsIA;
	
	@FXML
    private TextField namePlayer1;

	@FXML
    private TextField namePlayer2;
	
	public static String name1;
	public static String name2;

    @FXML
    void StartPlaying(ActionEvent event) throws IOException {
    	        
    	name1=namePlayer1.getText();
    	name2=namePlayer2.getText();
        Parent root= FXMLLoader.load(getClass().getResource("/application/view/StartGameHuman.fxml"));
    	Stage window=(Stage) ButtonStart_HumanVsIA.getScene().getWindow();
    	window.setTitle("GAME");
    	window.setScene(new Scene(root));
        
        /*Parent root= FXMLLoader.load(getClass().getResource("/application/view/PlayerVsIA.fxml"));
    	Stage window=(Stage) IABtn.getScene().getWindow();
    	window.setTitle("Player Vs IA");
    	window.setScene(new Scene(root));*/
    }
}

package application.controller;

import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.Icon;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AboutRulesController {


    @FXML
    private Button BackBtn2;
    
    @FXML
    private Label RulesTitle;
    
    @FXML
    void OnClickBack2() throws IOException {
    	Parent root= FXMLLoader.load(getClass().getResource("/application/view/AccueilInterface.fxml"));
	    Stage window=(Stage) BackBtn2.getScene().getWindow();
	    window.setTitle("Morpion");
	    window.setScene(new Scene(root));
    }
}

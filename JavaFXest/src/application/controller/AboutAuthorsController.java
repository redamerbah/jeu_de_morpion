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

public class AboutAuthorsController {

	
	@FXML
    private Label AuthorsName1;

    @FXML
    private Label AuthorsName2;

    @FXML
    private Label AuthorsTitle;

    @FXML
    private Button BackBtn;
    
    @FXML
    void initialize() {
    	
    }

    @FXML
    void OnClickBack() throws IOException {
    	Parent root= FXMLLoader.load(getClass().getResource("/application/view/AccueilInterface.fxml"));
	    Stage window=(Stage) BackBtn.getScene().getWindow();
	    window.setTitle("Morpion");
	    window.setScene(new Scene(root));
    }
}

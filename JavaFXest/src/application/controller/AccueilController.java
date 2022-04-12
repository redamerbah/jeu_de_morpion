package application.controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.print.DocFlavor.URL;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AccueilController {
	 	@FXML
	    private Button IABtn;
	 	
	 	@FXML
	    private Button HumanBtn;

	    @FXML
	    private AnchorPane anchorPane;

	    @FXML
	    private Text text;
	    
	    @FXML
	    private Text underlinne;
	    
	    @FXML
		 void initialize() {

	    	IABtn.setFocusTraversable(false);
	    	HumanBtn.setFocusTraversable(false);
	    	//Transition
	    	FadeTransition ft = new FadeTransition(Duration.millis(2000), underlinne);
	        ft.setFromValue(1);
	        ft.setToValue(0.2);
	        ft.setCycleCount(Timeline.INDEFINITE);
	        ft.setAutoReverse(true);
	    
	        ft.play();
	        
	    }
	    
 
	    @FXML
	    void OnClickIABtn(ActionEvent event) throws IOException {
	    	Parent root= FXMLLoader.load(getClass().getResource("/application/view/PlayerVsIA.fxml"));
	    	Stage window=(Stage) IABtn.getScene().getWindow();
	    	window.setTitle("Player Vs IA");
	    	window.setScene(new Scene(root));
	    }
	    
	    
	    @FXML
	    void EditModels(ActionEvent event) throws IOException {
	    	
	    	Parent root = FXMLLoader.load(getClass().getResource("/application/view/EditingModels.fxml"));
	        Stage stage=new Stage();
	        stage.setTitle("Models");
	        stage.setScene(new Scene(root));
	        stage.setResizable(false);
	        stage.show(); 
        
	    }
	    
	    @FXML
	    void EditConfigs(ActionEvent event) throws IOException {
	    	Parent root = FXMLLoader.load(getClass().getResource("/application/view/EditingConfigs.fxml"));
	        Stage stage=new Stage();
	        stage.setTitle("Models");
	        stage.setScene(new Scene(root));
	        stage.setResizable(false);
	        stage.show(); 
	    }
	        
	    @FXML
	    void OnClickHumanBtn(ActionEvent event) throws IOException {
	        Parent root= FXMLLoader.load(getClass().getResource("/application/view/PlayerVsPlayer.fxml"));
	    	Stage window=(Stage) HumanBtn.getScene().getWindow();
	    	window.setTitle("Player Vs Player");
	    	window.setScene(new Scene(root));
	    }
	    
	    @FXML
	    void OnClickAboutAuthors(ActionEvent event) throws IOException {
	        Parent root= FXMLLoader.load(getClass().getResource("/application/view/AboutAuthors.fxml"));
	    	Stage window=(Stage) HumanBtn.getScene().getWindow();
	    	window.setTitle("AuthorsLabel");
	    	window.setScene(new Scene(root));
	    }
	    
	    @FXML
	    void OnClickAboutRules(ActionEvent event) throws IOException {
	        Parent root= FXMLLoader.load(getClass().getResource("/application/view/AboutRules.fxml"));
	    	Stage window=(Stage) HumanBtn.getScene().getWindow();
	    	window.setTitle("Player Vs Player");
	    	window.setScene(new Scene(root));
	    }
}

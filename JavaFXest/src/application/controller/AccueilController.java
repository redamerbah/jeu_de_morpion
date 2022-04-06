package application.controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.print.DocFlavor.URL;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AccueilController {
	 	@FXML
	    private Button IABtn;
	 	
	 	@FXML
	    private Button HumanBtn;

	    @FXML
	    private AnchorPane anchorPane;

	    @FXML
	    private Text text;
	    
	    /*private Stage stage;
	    private Scene scene;
	    private Parent root;
	    */
	    @FXML
		 void initialize() {
		   	//namePlayer.setText("Player 1");
		   	//System.out.println("Je suis :"+namePlayer.getText());
	    	IABtn.setFocusTraversable(false);
	    	HumanBtn.setFocusTraversable(false);
		    	}
	    
 
	    @FXML
	    void OnClickIABtn(ActionEvent event) throws IOException {
	    	/*Parent root = FXMLLoader.load(getClass().getResource("/application/view/PlayerVsIA.fxml"));
	    	//URL url = new File("/application/view/PlayerVsIA.fxml").toURI().toURL();
			 //Parent root = FXMLLoader.load(url);
	    	stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
	    	scene=new Scene(root);
	    	stage.setScene(root);
	        //Stage stage=new Stage();
	        stage.setTitle("Player Vs IA");
	        stage.setScene(new Scene(root));
	        stage.setResizable(false);
	        stage.show(); */
	    	
	    	Parent root= FXMLLoader.load(getClass().getResource("/application/view/PlayerVsIA.fxml"));
	    	Stage window=(Stage) IABtn.getScene().getWindow();
	    	window.setTitle("Player Vs IA");
	    	window.setScene(new Scene(root));
	        
	    }
	    
	    
	    @FXML
	    void EditModels(ActionEvent event) throws IOException {
	    	/*
	    	//URL url = new File("/application/view/PlayerVsIA.fxml").toURI().toURL();
			 //Parent root = FXMLLoader.load(url);
	    	stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
	    	scene=new Scene(root);
	    	stage.setScene(root);*/ 
	    	
	    	Parent root = FXMLLoader.load(getClass().getResource("/application/view/EditingModels.fxml"));
	        Stage stage=new Stage();
	        stage.setTitle("Models");
	        stage.setScene(new Scene(root));
	        stage.setResizable(false);
	        stage.show(); 
	    	
	        
	    }
	    
	    @FXML
	    void EditConfigs(ActionEvent event) throws IOException {
	    	/*
	    	//URL url = new File("/application/view/PlayerVsIA.fxml").toURI().toURL();
			 //Parent root = FXMLLoader.load(url);
	    	stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
	    	scene=new Scene(root);
	    	stage.setScene(root);*/ 
	    	
	    	Parent root = FXMLLoader.load(getClass().getResource("/application/view/EditingConfigs.fxml"));
	        Stage stage=new Stage();
	        stage.setTitle("Models");
	        stage.setScene(new Scene(root));
	        stage.setResizable(false);
	        stage.show(); 
	    }
	        
	    @FXML
	    void OnClickHumanBtn(ActionEvent event) throws IOException {
	    	/*SParent root = FXMLLoader.load(getClass().getResource("/application/view/PlayerVsPlayer.fxml"));
	        Stage stage=new Stage();
	        stage.setTitle("Player vs player");
	        stage.setScene(new Scene(root));
	        stage.setResizable(false);
	        stage.show(); 
	        */
	        Parent root= FXMLLoader.load(getClass().getResource("/application/view/PlayerVsPlayer.fxml"));
	    	Stage window=(Stage) HumanBtn.getScene().getWindow();
	    	window.setTitle("Player Vs Player");
	    	window.setScene(new Scene(root));
	    	
	    }
}

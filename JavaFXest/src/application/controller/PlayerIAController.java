package application.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import ai.MultiLayerPerceptron;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ai.*;
import application.controller.FirstController;


public class PlayerIAController {
	public static MultiLayerPerceptron m;
	public static String namePlayer1;
	
	 @FXML
	 private Button ButtonStart_HumanVsIA;
	 
	 @FXML
	 private RadioButton easyLvl;

	 @FXML
	 private RadioButton hardLvl;
	 
	 @FXML 
	 private TextField namePlayer;
	 
	 @FXML
	 void initialize() {
	   	//namePlayer.setText("Player 1");
	   	//System.out.println("Je m'appelle :"+namePlayer.getText());
		 easyLvl.setFocusTraversable(false);
		 namePlayer.setFocusTraversable(false);
		 ButtonStart_HumanVsIA.setFocusTraversable(false);

	    	}

	    @FXML
	    void StartLoading(ActionEvent event) throws IOException {
	    	
	    	 File file = new File("C:\\Users\\ACHRAF\\eclipse-workspace\\JavaFXest\\resources\\config.txt");
	         BufferedReader br = new BufferedReader(new FileReader(file));
	         Scanner sc = new Scanner(file);        
	         String facile=sc.nextLine();
	         String difficile=sc.nextLine();
	         String[] facileTab = facile.split(":"); 
	         String[] difficileTab = difficile.split(":"); 
	         for(int i=0; i<facileTab.length; i++)  
	         {  
	         	System.out.println(facileTab[i]);  
	         }
	         if (easyLvl.isSelected()) {
	        	 FirstController.h=Integer.parseInt(facileTab[1]);
	        	 FirstController.lr=Double.parseDouble(facileTab[2]);
	        	 FirstController.l=Integer.parseInt(facileTab[3]);
	        	 System.out.println("****************** FACILE ******************");	        	 
	         }else if (hardLvl.isSelected()) {
	        	 FirstController.h=Integer.parseInt(difficileTab[1]);
	        	 FirstController.lr=Double.parseDouble(difficileTab[2]);
	        	 FirstController.l=Integer.parseInt(difficileTab[3]);
	        	 System.out.println("****************** DIFFICILE ******************");
	         }
	    	
	    	
	    	
            
	         String path="resources/models/"+"ModelLearningSave-H"+FirstController.h+"-LR"+FirstController.lr+"-L"+FirstController.l+".srl";
	         namePlayer1=namePlayer.getText();
	         //System.out.println("Je m'appelle :"+namePlayer1);
	         if(new File(path).exists()){
                m=MultiLayerPerceptron.load(path);
                /*Parent root = FXMLLoader.load(getClass().getResource("/application/view/StartGameIA.fxml"));
    	        Stage stage=new Stage();
    	        stage.setTitle("LOADING...");
    	        stage.setScene(new Scene(root));
    	        stage.setResizable(false);
    	        stage.show(); */
    	        
    	        //Parent root= FXMLLoader.load(getClass().getResource("/application/view/StartGameIA.fxml"));
                Parent root= FXMLLoader.load(getClass().getResource("/application/view/StartGameIA.fxml"));
            	
                Stage window=(Stage) ButtonStart_HumanVsIA.getScene().getWindow();
            	window.setTitle("LET'S PLAY");
            	window.setScene(new Scene(root));
                
            }else{         
            	
            	
            	Parent root= FXMLLoader.load(getClass().getResource("/application/view/LoadingLayout.fxml"));
    	    	Stage window=(Stage) ButtonStart_HumanVsIA.getScene().getWindow();
    	    	window.setTitle("Player Vs IA");
    	    	window.setScene(new Scene(root));
            	
            	/*Parent root = FXMLLoader.load(getClass().getResource("/application/view/LoadingLayout.fxml"));
            	Stage stage=new Stage();
            	stage.setTitle("LOADING...");
            	stage.setScene(new Scene(root));
            	stage.setResizable(false);
            	stage.show(); */ 
            	
            	
            }
            
            
            /*ButtonStart_HumanVsIA.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
            	public void handle(ActionEvent event) {
            		namePlayer1=namePlayer.getText();
            		//System.out.println();
            		System.out.println("Je m'appelle :"+namePlayer.getText());
            		}
            	}
            );*/
            //System.out.println("TESTTTTTTTTTTT");
            
            
            

	    }
}

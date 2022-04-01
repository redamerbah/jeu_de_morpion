package application.controller;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ConfigsController {

	 @FXML
	 private TextField Hfield;

	 @FXML
	 private TextField LRfield;
	 
	 @FXML
	 private TextField Lfield;

	 @FXML
	 private Button validateConfigs;
	 
	 @FXML
	 private RadioButton easyLVL2;

	 @FXML
	 private RadioButton hardLVL2;

	 @FXML
	 void EditConfigs(ActionEvent event) throws IOException {
		 File file = new File("C:\\Users\\ACHRAF\\eclipse-workspace\\JavaFXest\\resources\\config.txt");
         BufferedReader br = new BufferedReader(new FileReader(file));
         Scanner sc = new Scanner(file);        
         String facile=sc.nextLine();
         String difficile=sc.nextLine();
         String[] facileTab = facile.split(":"); 
         String[] difficileTab = difficile.split(":"); 
		 File file2 = new File("C:\\Users\\ACHRAF\\eclipse-workspace\\JavaFXest\\resources\\config2.txt");
		 
     	 
     	// create the file if it doesn't exist
     	   if (!file2.exists()) {
				file2.createNewFile();
     	   }
        if (easyLVL2.isSelected()) {
        		String content="F:"+Hfield.getText()+":"+LRfield.getText()+":"+Lfield.getText();
        		FileWriter fw = new FileWriter(file2.getAbsoluteFile());
        		BufferedWriter bw = new BufferedWriter(fw);
        		bw.write(content);
        		bw.write("\r\n");
        		bw.write(difficile);
        		bw.close();
        }
        else if (hardLVL2.isSelected()) {
    		String content="D:"+Hfield.getText()+":"+LRfield.getText()+":"+Lfield.getText();
    		FileWriter fw = new FileWriter(file.getAbsoluteFile());
    		BufferedWriter bw = new BufferedWriter(fw);
    		bw.write(facile);
    		bw.write("\r\n");
    		bw.write(content);
    		bw.close();
        }
        	 
        	 /*
        	 FirstController.h=Integer.parseInt(facileTab[1]);
        	 FirstController.lr=Double.parseDouble(facileTab[2]);
        	 FirstController.l=Integer.parseInt(facileTab[3]);
        	 System.out.println("****************** FACILE ******************");
        	 Hfield.setText(facileTab[1]);
        	 LRfield.setText(facileTab[2]);
        	 Lfield.setText(facileTab[3]);
        	 for(int i=0; i<facileTab.length; i++)  
             {  
             	System.out.println(facileTab[i]);  
             }	 
         }
         */
        
    }
	 
	 
	 @SuppressWarnings("unchecked")
	@FXML
	 <Toggle> void initialize() throws FileNotFoundException{
		 
		 File file = new File("C:\\Users\\ACHRAF\\eclipse-workspace\\JavaFXest\\resources\\config.txt");
         BufferedReader br = new BufferedReader(new FileReader(file));
         Scanner sc = new Scanner(file);        
         String facile=sc.nextLine();
         String difficile=sc.nextLine();
         String[] facileTab = facile.split(":"); 
         String[] difficileTab = difficile.split(":");   
         
         
         if (easyLVL2.isSelected()) {
        	 
        	 FirstController.h=Integer.parseInt(facileTab[1]);
        	 FirstController.lr=Double.parseDouble(facileTab[2]);
        	 FirstController.l=Integer.parseInt(facileTab[3]);
        	 System.out.println("****************** FACILE ******************");
        	 Hfield.setText(facileTab[1]);
        	 LRfield.setText(facileTab[2]);
        	 Lfield.setText(facileTab[3]);
        	 for(int i=0; i<facileTab.length; i++)  
             {  
             	System.out.println(facileTab[i]);  
             }
        	 
         }
        
         else if (hardLVL2.isSelected()) {
        	 FirstController.h=Integer.parseInt(difficileTab[1]);
        	 FirstController.lr=Double.parseDouble(difficileTab[2]);
        	 FirstController.l=Integer.parseInt(difficileTab[3]);
        	 
        	 Hfield.setText(difficileTab[1]);
        	 LRfield.setText(difficileTab[2]);
        	 Lfield.setText(difficileTab[3]);
        	 System.out.println("****************** DIFFICILE ******************");
        	 for(int i=0; i<facileTab.length; i++)  
        	 {  
        		 System.out.println(difficileTab[i]);  
        	 }
         }
    	 
         
        final ToggleGroup group = new ToggleGroup(); 
        easyLVL2.setToggleGroup(group);
        hardLVL2.setToggleGroup(group);
        
        group.selectedToggleProperty().addListener((ChangeListener<? super javafx.scene.control.Toggle>) new ChangeListener<Toggle>() {
        		public void changed(ObservableValue<? extends Toggle> ob, Toggle o, Toggle n) {
        			RadioButton rb = (RadioButton)group.getSelectedToggle();
        			 if (rb != null) {
                         String s = rb.getText();
                         System.out.print(s);
                         if (s.equals("EASY")) {
             				System.out.print("Tets");
             				// change the label
             				Hfield.setText(facileTab[1]);
             	        	 LRfield.setText(facileTab[2]);
             	        	 Lfield.setText(facileTab[3]);
             			}
             			else if (s.equals("HARD")) {
             				Hfield.setText(difficileTab[1]);
            	        	LRfield.setText(difficileTab[2]);
            	        	Lfield.setText(difficileTab[3]);
             			}
             			else {
             				System.out.print("Veuillez selectionner un choix");             				
             			}

                     }
        			
			}
        });

         /*if (easyLVL2.isSelected()) {
        	 
        	 FirstController.h=Integer.parseInt(facileTab[1]);
        	 FirstController.lr=Double.parseDouble(facileTab[2]);
        	 FirstController.l=Integer.parseInt(facileTab[3]);
        	 System.out.println("****************** FACILE ******************");
        	 Hfield.setText(facileTab[1]);
        	 LRfield.setText(facileTab[2]);
        	 Lfield.setText(facileTab[3]);
        	 for(int i=0; i<facileTab.length; i++)  
             {  
             	System.out.println(facileTab[i]);  
             }
        	 
         }
        
         else if (hardLVL2.isSelected()) {
        	 FirstController.h=Integer.parseInt(difficileTab[1]);
        	 FirstController.lr=Double.parseDouble(difficileTab[2]);
        	 FirstController.l=Integer.parseInt(difficileTab[3]);
        	 
        	 Hfield.setText(difficileTab[1]);
        	 LRfield.setText(difficileTab[2]);
        	 Lfield.setText(difficileTab[3]);
        	 System.out.println("****************** DIFFICILE ******************");
        	 for(int i=0; i<facileTab.length; i++)  
        	 {  
        		 System.out.println(difficileTab[i]);  
        	 }
         }*/
		 
	 }
		 
}



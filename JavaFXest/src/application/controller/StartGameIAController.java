package application.controller;

import java.io.FileNotFoundException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;



public class StartGameIAController {
	
	@FXML
    private Label textBienvenu;
	
	@FXML
    private Button testBtn;
	
	 @FXML
	  private Button Button0;

	    @FXML
	    private Button Button1;

	    @FXML
	    private Button Button2;

	    @FXML
	    private Button Button3;

	    @FXML
	    private Button Button4;

	    @FXML
	    private Button Button5;

	    @FXML
	    private Button Button6;

	    @FXML
	    private Button Button7;

	    @FXML
	    private Button Button8;

	    @FXML
	    private ImageView imageIA;

	    @FXML
	    private ImageView imagePlayer;

	    @FXML
	    private Label namePlayerLabel;
	

	public void initialize(){		
		//System.out.println("ALLO");
		//System.out.println("jOUEUR :"+PlayerIAController.namePlayer1);
		if ((PlayerIAController.namePlayer1).equals("")) {
			PlayerIAController.namePlayer1="Player1";
		}
		else {	
			namePlayerLabel.setText(PlayerIAController.namePlayer1);
			}
	}
	
	@FXML
	void testClick(){		
		/*
		 System.out.println("ALLO");
		System.out.println("Je m'appelle :"+PlayerIAController.namePlayer1);
		textBienvenu.setText("Bienvenu "+PlayerIAController.namePlayer1);
		*/
	}
	
	
	

}

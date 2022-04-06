package application.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.text.Font;



public class StartGameHumanController {
		
		int compteur=0;
	
		@FXML
	 	private Button ReplayBtn;
		
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
	    
	    @FXML
	    private Label namePlayerLabel2;
	    
	    @FXML
	    private Label winnerName;
	    
	    @FXML
	    private Label TextWinner;
	

	public void initialize(){		
		//System.out.println("ALLO");
		//System.out.println("jOUEUR :"+PlayerVsPlayerController.name1);
		if ((PlayerVsPlayerController.name1).equals("")) {
			PlayerVsPlayerController.name1="Player1";
		}
		else {	
			namePlayerLabel.setText(PlayerVsPlayerController.name1);
			}
		
		if ((PlayerVsPlayerController.name2).equals("")) {
			PlayerVsPlayerController.name2="Player2";
		}
		else {	
			namePlayerLabel2.setText(PlayerVsPlayerController.name2);
			}
		TextWinner.setVisible(false);
		winnerName.setVisible(false);
		Button0.setFocusTraversable(false);
		Button1.setFocusTraversable(false);
		Button2.setFocusTraversable(false);
		Button3.setFocusTraversable(false);
		Button4.setFocusTraversable(false);
		Button5.setFocusTraversable(false);
		Button6.setFocusTraversable(false);
		Button7.setFocusTraversable(false);
		Button8.setFocusTraversable(false);
		
		
		
	}
	
	@FXML
	void Btn0Click(){
		if (compteur % 2 ==0) {
			Button0.setText("X");
			Button0.setTextFill(Color.BLUE);}
		else {
			Button0.setText("O");
			Button0.setTextFill(Color.RED);
			}
		UpdateBtn(Button0);
		}
	
	@FXML
	void Btn1Click(){
		if (compteur % 2 ==0) {Button1.setText("X");
				Button1.setTextFill(Color.BLUE);
				}
		else {
			Button1.setText("O");
			Button1.setTextFill(Color.RED);
		}
		UpdateBtn(Button1);
		}
	
	@FXML
	void Btn2Click(){
		if (compteur % 2 ==0) {
				Button2.setText("X");
				Button2.setTextFill(Color.BLUE);
				}
		else {
			Button2.setText("O");
			Button2.setTextFill(Color.RED);
		}
		UpdateBtn(Button2);
		}
	
	@FXML
	void Btn3Click(){
		if (compteur % 2 ==0) {Button3.setText("X");
				Button3.setTextFill(Color.BLUE);
				}
		else {
			Button3.setText("O");
			Button3.setTextFill(Color.RED);
		}
		UpdateBtn(Button3);
	}
	
	@FXML
	void Btn4Click(){
		if (compteur % 2 ==0) {Button4.setText("X");
			Button4.setTextFill(Color.BLUE);
				}
		else {
			Button4.setText("O");
			Button4.setTextFill(Color.RED);
		}
		UpdateBtn(Button4);
		}
	
	@FXML
	void Btn5Click(){
		if (compteur % 2 ==0) {Button5.setText("X");
			Button5.setTextFill(Color.BLUE);
		}
		else {
			Button5.setText("O");
			Button5.setTextFill(Color.RED);
		}
		UpdateBtn(Button5);
		}
	
	@FXML
	void Btn6Click(){
		if (compteur % 2 ==0) {Button6.setText("X");
		Button6.setTextFill(Color.BLUE);
				}
		else {
			Button6.setText("O");
			Button6.setTextFill(Color.RED);
		}
		UpdateBtn(Button6);
		}
	
	@FXML
	void Btn7Click(){
		if (compteur % 2 ==0) {Button7.setText("X");
		Button7.setTextFill(Color.BLUE);
				}
		else {
			Button7.setText("O");
			Button7.setTextFill(Color.RED);
		}
		UpdateBtn(Button7);
		}
	
	@FXML
	void Btn8Click(){
		if (compteur % 2 ==0) {Button8.setText("X");
		Button8.setTextFill(Color.BLUE);
		//Button8.setStyle("-fx-opacity: 1");
				}
		else {
			Button8.setText("O");
			Button8.setTextFill(Color.RED);
			//Button8.setStyle("-fx-opacity: 1");
		}
		UpdateBtn(Button8);
		}
	
	public void winneralternate(Button b1,Button b2,Button b3) {
		
		if ((b1.getText()+b2.getText()+b3.getText()).equals("XXX") ) {
			System.out.println("The Winnner is "+ PlayerVsPlayerController.name1);
			
			b1.setStyle("-fx-background-color: #32CD32	; ");
			b2.setStyle("-fx-background-color: #32CD32	; ");
			b3.setStyle("-fx-background-color: #32CD32	; ");
			
			DisableAll();
			TextWinner.setVisible(true);
			winnerName.setText(PlayerVsPlayerController.name1);
			winnerName.setVisible(true);
		}
		else if ((b1.getText()+b2.getText()+b3.getText()).equals("OOO")){
			System.out.println("The Winnner is "+ PlayerVsPlayerController.name2);
			
			b1.setStyle("-fx-background-color: #32CD32	; ");
			b2.setStyle("-fx-background-color: #32CD32	; ");
			b3.setStyle("-fx-background-color: #32CD32	; ");
			
			DisableAll();
			TextWinner.setVisible(true);
			winnerName.setText(PlayerVsPlayerController.name2);
			winnerName.setVisible(true);
		}
	}
	/*
	 
	  
	  
	 */
	
	public void checkTheWinner(String conbin){
		if (conbin.equals("XXX")) {
			System.out.println("The Winnner is "+ PlayerVsPlayerController.name1);
			DisableAll();
			TextWinner.setVisible(true);
			winnerName.setText(PlayerVsPlayerController.name1);
			winnerName.setVisible(true);
		}
		else if (conbin.equals("OOO")){
			System.out.println("The Winnner is "+ PlayerVsPlayerController.name2);
			DisableAll();
			TextWinner.setVisible(true);
			winnerName.setText(PlayerVsPlayerController.name2);
			winnerName.setVisible(true);
		}
		
		
	};
	public void checkGameOverAlternate() {
		winneralternate(Button0,Button1,Button2);
		winneralternate(Button3,Button4,Button5);
		winneralternate(Button6,Button7,Button8);
		
		winneralternate(Button0,Button3,Button6);
		winneralternate(Button1,Button4,Button7);
		winneralternate(Button2,Button5,Button8);
		

		winneralternate(Button0,Button4,Button8);
		winneralternate(Button2,Button4,Button6);		
	}
	
	public void checkIfGameIsOver(){
        //for (int a = 0; a < 8; a++) {
        	//if ((Button0.getText()+Button1.getText()+Button2.getText()).equals("XXX") || (Button0.getText()+Button1.getText()+Button2.getText()).equals("OOO")){
        		/*checkTheWinner(Button0.getText()+Button1.getText()+Button2.getText());
        		checkTheWinner(Button3.getText()+Button4.getText()+Button5.getText());
        		checkTheWinner(Button6.getText()+Button7.getText()+Button8.getText());
        		
        		checkTheWinner(Button0.getText()+Button3.getText()+Button6.getText());
        		checkTheWinner(Button1.getText()+Button4.getText()+Button7.getText());
        		checkTheWinner(Button2.getText()+Button5.getText()+Button8.getText());
        		
        		checkTheWinner(Button0.getText()+Button4.getText()+Button8.getText());
        		checkTheWinner(Button2.getText()+Button4.getText()+Button6.getText());
        		*/
		winneralternate(Button0,Button1,Button2);
		winneralternate(Button3,Button4,Button5);
		winneralternate(Button6,Button7,Button8);
		
		winneralternate(Button0,Button3,Button6);
		winneralternate(Button1,Button4,Button7);
		winneralternate(Button2,Button5,Button8);
		

		winneralternate(Button0,Button4,Button8);
		winneralternate(Button2,Button4,Button6);
        	//}
        //}
        
        		
            
    }
	
	public void DisableAll() {
		Button0.setDisable(true);
		Button1.setDisable(true);
		Button2.setDisable(true);
		Button3.setDisable(true);
		Button4.setDisable(true);
		Button5.setDisable(true);
		Button6.setDisable(true);
		Button7.setDisable(true);
		Button8.setDisable(true);		
	}
	
	public void Replay() throws IOException {
		
    	Parent root= FXMLLoader.load(getClass().getResource("/application/view/StartGameHuman.fxml"));
    	Stage window=(Stage) ReplayBtn.getScene().getWindow();
    	window.setTitle("Player Vs IA");
    	window.setScene(new Scene(root)); 
	}
	
	public void UpdateBtn(Button Btn) {
		Btn.setFont(Font.font("Arial", FontWeight.BOLD, 46));
		Btn.setStyle("-fx-opacity: 1");
		Btn.setDisable(true);
		compteur++;
		checkIfGameIsOver();
		
	}
	
	
	}

	

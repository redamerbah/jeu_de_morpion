package application.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import ai.Coup;
import ai.MultiLayerPerceptron;
import ai.Test;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;



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
	    private Button BackBtn;

	    @FXML
	    private ImageView imageIA;

	    @FXML
	    private ImageView imagePlayer;

	    @FXML
	    private Label namePlayerLabel;
	    
	    @FXML
	    private Label TextWinner;
	    
	    @FXML
	    private Label winnerName;
	    
	    @FXML
	 	private Button ReplayBtn;
	    
	    int compteur=0;
	    Coup coup;
	    
	    MultiLayerPerceptron net;
	    int l,h;
	    double lr;
	    
	    
	    double[] board = {0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0};
	

	public void initialize(){		
		if ((PlayerIAController.namePlayer1).equals("")) {
			PlayerIAController.namePlayer1="Player1";
		}
		else {	
			namePlayerLabel.setText(PlayerIAController.namePlayer1);
			}
		
		/*h = FirstController.h;
        lr = FirstController.lr;
        l = FirstController.l;*/
        
        coup = new Coup(9,"test");
        net = ai.MultiLayerPerceptron.load("resources/models/ModelLearningSave-H"+FirstController.h+"-LR"+FirstController.lr+"-L"+FirstController.l+".srl");

	}
	
	@FXML
	void OnClickBack5() throws IOException {
	    	Parent root= FXMLLoader.load(getClass().getResource("/application/view/PlayerVsIA.fxml"));
		    Stage window=(Stage) BackBtn.getScene().getWindow();
		    window.setTitle("Morpion");
		    window.setScene(new Scene(root));
	   }
	
	
	void IAPlay() {
		/*try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		coup.addInBoard(board);
		double[] res = Test.play(net, coup);
		while (compteur%2==0) {
			double max=0;
			int indice=0;
			for (int i=0;i<9;i++) {
				if ((res[i]>max)&&(compteur<8)){
					max= res[i];
					indice=i;
				}
			}
			if(compteur==8){
				break;
			}
			if (board[indice]!=Coup.EMPTY) {	
				max=0;
				res[indice]=-1;
			}else {
				Button Btn=Button0;
				String BtnStr="Button"+indice;

				if ((Button0.getId()).equals(BtnStr)) Btn=Button0;
				else if ((Button1.getId()).equals(BtnStr)) Btn=Button1;
				else if ((Button2.getId()).equals(BtnStr)) Btn=Button2;
				else if ((Button3.getId()).equals(BtnStr)) Btn=Button3;
				else if ((Button4.getId()).equals(BtnStr)) Btn=Button4;
				else if ((Button5.getId()).equals(BtnStr)) Btn=Button5;
				else if ((Button6.getId()).equals(BtnStr)) Btn=Button6;
				else if ((Button7.getId()).equals(BtnStr)) Btn=Button7;
				else Btn=Button8;				

				board[indice]=Coup.O;
				Btn.setText("O");
				Btn.setTextFill(Color.RED);
				UpdateBtn(Btn);
			}
		}
	
	}
	
	public void UpdateBtn(Button Btn) {
		Btn.setFont(Font.font("Arial", FontWeight.BOLD, 46));
		Btn.setStyle("-fx-opacity: 1");
		Btn.setDisable(true);
		compteur++;
		checkIfGameIsOver();
		
	}


	@FXML
	void Btn0Click(){
		if (compteur % 2 ==0) {
			Button0.setText("X");
			Button0.setTextFill(Color.BLUE);
			board[0]=Coup.X;
			IAPlay();
		}
		UpdateBtn(Button0);
		}
	
	@FXML
	void Btn1Click(){
		if (compteur % 2 ==0) {Button1.setText("X");
				Button1.setTextFill(Color.BLUE);
				board[1]=Coup.X;
				IAPlay();
				}
		UpdateBtn(Button1);
		}
	
	@FXML
	void Btn2Click(){
		if (compteur % 2 ==0) {
				Button2.setText("X");
				Button2.setTextFill(Color.BLUE);
				board[2]=Coup.X;
				IAPlay();
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
				board[3]=Coup.X;
				IAPlay();
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
			board[4]=Coup.X;
			IAPlay();
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
			board[5]=Coup.X;
			IAPlay();
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
		board[6]=Coup.X;	
		IAPlay();
		}
		UpdateBtn(Button6);
		}
	
	@FXML
	void Btn7Click(){
		if (compteur % 2 ==0) {Button7.setText("X");
		Button7.setTextFill(Color.BLUE);
		board[7]=Coup.X;
		IAPlay();
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
		board[8]=Coup.X;
		IAPlay();
		//Button8.setStyle("-fx-opacity: 1");
				}
		else {
			Button8.setText("O");
			Button8.setTextFill(Color.RED);
			//Button8.setStyle("-fx-opacity: 1");
		}
		UpdateBtn(Button8);
		}
	
	
	
	
	
	public void checkIfGameIsOver(){
		winneralternate(Button0,Button1,Button2);
		winneralternate(Button3,Button4,Button5);
		winneralternate(Button6,Button7,Button8);
		winneralternate(Button0,Button3,Button6);
		winneralternate(Button1,Button4,Button7);
		winneralternate(Button2,Button5,Button8);
		winneralternate(Button0,Button4,Button8);
		winneralternate(Button2,Button4,Button6);

    }
	
public void winneralternate(Button b1,Button b2,Button b3) {
		
		if ((b1.getText()+b2.getText()+b3.getText()).equals("XXX") ) {
			System.out.println("The Winnner is "+ PlayerIAController.namePlayer1);
			
			b1.setStyle("-fx-background-color: #EAF411	; ");
			b2.setStyle("-fx-background-color: #EAF411	; ");
			b3.setStyle("-fx-background-color: #EAF411	; ");
			
			DisableAll();
			TextWinner.setVisible(true);
			winnerName.setText(PlayerIAController.namePlayer1);
			winnerName.setVisible(true);
		}
		else if ((b1.getText()+b2.getText()+b3.getText()).equals("OOO")){
			System.out.println("The Winnner is the ROBOT");
			
			b1.setStyle("-fx-background-color: #EAF411	; ");
			b2.setStyle("-fx-background-color: #EAF411	; ");
			b3.setStyle("-fx-background-color: #EAF411	; ");
			
			DisableAll();
			TextWinner.setVisible(true);
			winnerName.setText("ROBOT");
			winnerName.setVisible(true);
						
		}else if (compteur==9){
			//System.out.println("EQUAL");
			DisableAll();
			//TextWinner.setVisible(true);
			winnerName.setText("Egalité");
			winnerName.setVisible(true);
		}
		RotateTransition rt=new RotateTransition(Duration. millis(500), winnerName);
		rt.setByAngle(-5);
		rt.setCycleCount(9);
		rt.setAutoReverse(true);
		rt.play();
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
	
	Parent root= FXMLLoader.load(getClass().getResource("/application/view/StartGameIA.fxml"));
	Stage window=(Stage) ReplayBtn.getScene().getWindow();
	window.setTitle("Player Vs IA");
	window.setScene(new Scene(root)); 
}
	
	
	

}

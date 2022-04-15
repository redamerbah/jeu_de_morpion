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
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
	private ImageView Crown;

	@FXML
	private Label namePlayerLabel;

	@FXML
	private Label TextWinner;

	@FXML
	private Label winnerName;

	@FXML
	private Label LabelP1;

	@FXML
	private Label LabelP2;

	@FXML
	private Button ReplayBtn;

	int compteur = 0;
	Coup coup;

	MultiLayerPerceptron net;
	int l, h;
	double lr;

	double[] tab = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };

	public void initialize() {
		if ((PlayerIAController.namePlayer1).equals("")) {
			PlayerIAController.namePlayer1 = "Player1";
		} else {
			namePlayerLabel.setText(PlayerIAController.namePlayer1);
		}
		coup = new Coup(9, "test");
		net = ai.MultiLayerPerceptron.load("resources/models/ModelLearningSave-H" + FirstController.h + "-LR"
				+ FirstController.lr + "-L" + FirstController.l + ".srl");
	}

	@FXML
	void OnClickBack5() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/application/view/PlayerVsIA.fxml"));
		Stage window = (Stage) BackBtn.getScene().getWindow();
		window.setTitle("Morpion");
		window.setScene(new Scene(root));
	}

	void IAPlay() {
		coup.addInBoard(tab);
		double[] res = Test.play(net, coup);
		while (compteur % 2 == 0) {
			double max = 0;
			int indice = 0;
			for (int i = 0; i < 9; i++) {
				if ((res[i] > max) && (compteur < 8)) {
					max = res[i];
					indice = i;
				}
			}
			if (compteur == 8) {
				break;
			}
			if (tab[indice] != Coup.EMPTY) {
				max = 0;
				res[indice] = -1;
			} else {
				Button Btn = Button0;
				String BtnStr = "Button" + indice;

				if ((Button0.getId()).equals(BtnStr))
					Btn = Button0;
				else if ((Button1.getId()).equals(BtnStr))
					Btn = Button1;
				else if ((Button2.getId()).equals(BtnStr))
					Btn = Button2;
				else if ((Button3.getId()).equals(BtnStr))
					Btn = Button3;
				else if ((Button4.getId()).equals(BtnStr))
					Btn = Button4;
				else if ((Button5.getId()).equals(BtnStr))
					Btn = Button5;
				else if ((Button6.getId()).equals(BtnStr))
					Btn = Button6;
				else if ((Button7.getId()).equals(BtnStr))
					Btn = Button7;
				else
					Btn = Button8;

				tab[indice] = Coup.O;
				Btn.setText("O");
				Btn.setTextFill(Color.RED);
				UpdateBtn(Btn);
			}
		}

	}

	
	//UpadteBtn permet de modifier le style du bouton après l'avoir utiliser
	//Permet aussi de verifier si le jeu est terminé en utilisant la fonction checkIfGameIsOver()
	//Permet de changer le tour du joueur
	public void UpdateBtn(Button Btn) {
		Btn.setFont(Font.font("Arial", FontWeight.BOLD, 46));
		Btn.setStyle("-fx-opacity: 1");
		Btn.setDisable(true);
		compteur++;
		checkIfGameIsOver();

	}

	@FXML
	void Btn0Click() {
		if (compteur % 2 == 0) {
			Button0.setText("X");
			Button0.setTextFill(Color.BLUE);
			tab[0] = Coup.X;
			IAPlay();
		}
		UpdateBtn(Button0);
	}

	@FXML
	void Btn1Click() {
		if (compteur % 2 == 0) {
			Button1.setText("X");
			Button1.setTextFill(Color.BLUE);
			tab[1] = Coup.X;
			IAPlay();
		}
		UpdateBtn(Button1);
	}

	@FXML
	void Btn2Click() {
		if (compteur % 2 == 0) {
			Button2.setText("X");
			Button2.setTextFill(Color.BLUE);
			tab[2] = Coup.X;
			IAPlay();
		}
		UpdateBtn(Button2);
	}

	@FXML
	void Btn3Click() {
		if (compteur % 2 == 0) {
			Button3.setText("X");
			Button3.setTextFill(Color.BLUE);
			tab[3] = Coup.X;
			IAPlay();
		}
		UpdateBtn(Button3);
	}

	@FXML
	void Btn4Click() {
		if (compteur % 2 == 0) {
			Button4.setText("X");
			Button4.setTextFill(Color.BLUE);
			tab[4] = Coup.X;
			IAPlay();
		}
		UpdateBtn(Button4);
	}

	@FXML
	void Btn5Click() {
		if (compteur % 2 == 0) {
			Button5.setText("X");
			Button5.setTextFill(Color.BLUE);
			tab[5] = Coup.X;
			IAPlay();
		}
		UpdateBtn(Button5);
	}

	@FXML
	void Btn6Click() {
		if (compteur % 2 == 0) {
			Button6.setText("X");
			Button6.setTextFill(Color.BLUE);
			tab[6] = Coup.X;
			IAPlay();
		}
		UpdateBtn(Button6);
	}

	@FXML
	void Btn7Click() {
		if (compteur % 2 == 0) {
			Button7.setText("X");
			Button7.setTextFill(Color.BLUE);
			tab[7] = Coup.X;
			IAPlay();
		}
		UpdateBtn(Button7);
	}

	@FXML
	void Btn8Click() {
		if (compteur % 2 == 0) {
			Button8.setText("X");
			Button8.setTextFill(Color.BLUE);
			tab[8] = Coup.X;
			IAPlay();
		}
		UpdateBtn(Button8);
	}

	// Vérifie si le jeu est fini en essayant toutes les combinaisons possible pour
	// gagner
	public void checkIfGameIsOver() {
		winneralternate(Button0, Button1, Button2);
		winneralternate(Button3, Button4, Button5);
		winneralternate(Button6, Button7, Button8);
		winneralternate(Button0, Button3, Button6);
		winneralternate(Button1, Button4, Button7);
		winneralternate(Button2, Button5, Button8);
		winneralternate(Button0, Button4, Button8);
		winneralternate(Button2, Button4, Button6);

	}

	public void winneralternate(Button b1, Button b2, Button b3) {
		// Si joueur 1 a gagné
		if ((b1.getText() + b2.getText() + b3.getText()).equals("XXX")) {
			System.out.println("The Winnner is " + PlayerIAController.namePlayer1);
			//Changement de couleur du fond des boutons 
			b1.setStyle("-fx-background-color: #EAF411	; ");
			b2.setStyle("-fx-background-color: #EAF411	; ");
			b3.setStyle("-fx-background-color: #EAF411	; ");

			DisableAll();
			TextWinner.setVisible(true);
			winnerName.setText(PlayerIAController.namePlayer1);
			winnerName.setVisible(true);
			
			//Animation pour le gagnant
			WinnerAnimationCrown(60);

		} // Si joueur 2 a gagné
		else if ((b1.getText() + b2.getText() + b3.getText()).equals("OOO")) {
			System.out.println("The Winnner is the ROBOT");

			//Changement de couleur du fond des boutons 
			b1.setStyle("-fx-background-color: #EAF411	; ");
			b2.setStyle("-fx-background-color: #EAF411	; ");
			b3.setStyle("-fx-background-color: #EAF411	; ");
			DisableAll();
			TextWinner.setVisible(true);
			winnerName.setText("ROBOT");
			winnerName.setVisible(true);
			Crown.setVisible(true);
			
			//Animation pour le gagnant
			WinnerAnimationCrown(277);

		} else if (compteur == 9) {
			DisableAll();
			winnerName.setText("Equality");
			winnerName.setVisible(true);
		}
		RotateTransition rt = new RotateTransition(Duration.millis(500), winnerName);
		rt.setByAngle(-5);
		rt.setCycleCount(Timeline.INDEFINITE);
		rt.setAutoReverse(true);
		rt.play();
	}
	
	// Désactive tous le boutons
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
		Parent root = FXMLLoader.load(getClass().getResource("/application/view/StartGameIA.fxml"));
		Stage window = (Stage) ReplayBtn.getScene().getWindow();
		window.setTitle("Player Vs IA");
		window.setScene(new Scene(root));
	}

	
	//Permet d'animer la page quand un joueur a gagné en utilisant deux trnasitions
	public void WinnerAnimationCrown(int y) {
		//première transition: Une rotation du Crown 
		Crown.setVisible(true);
		RotateTransition rt = new RotateTransition(Duration.millis(1000), Crown);
		rt.setByAngle(360);
		rt.setCycleCount(2);
		rt.setAutoReverse(false);
		rt.play();
		//deuxième transition: Mouvement du Crown au-dessus du gagnant
		TranslateTransition translate = new TranslateTransition();
		translate.setByY(y);
		translate.setDuration(Duration.millis(1000));
		translate.setCycleCount(1);
		translate.setAutoReverse(true);
		translate.setNode(Crown);
		translate.play();

	}

}

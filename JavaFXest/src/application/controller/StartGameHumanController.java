package application.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
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
import javafx.util.Duration;
import javafx.scene.text.Font;

public class StartGameHumanController {

	int compteur = 0;

	@FXML
	private Button ReplayBtn;

	@FXML
	private ImageView Crown;

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
	private Label LabelP1;

	@FXML
	private Label LabelP2;

	@FXML
	private Label namePlayerLabel2;

	@FXML
	private Label winnerName;

	@FXML
	private Label TextWinner;

	@FXML
	private Button BackBtn;

	public void initialize() {
		if ((PlayerVsPlayerController.name1).equals("")) {
			PlayerVsPlayerController.name1 = "Player1";
		} else {
			namePlayerLabel.setText(PlayerVsPlayerController.name1);
		}

		if ((PlayerVsPlayerController.name2).equals("")) {
			PlayerVsPlayerController.name2 = "Player2";
		} else {
			namePlayerLabel2.setText(PlayerVsPlayerController.name2);
		}

		System.out.println("Player1 :" + PlayerVsPlayerController.scorePLayer1 + " - "
				+ PlayerVsPlayerController.scorePLayer2 + ": Player2 ");

		// Calcul du score
		if (PlayerVsPlayerController.replay == true) {
			int s1 = PlayerVsPlayerController.scorePLayer1;
			int s2 = PlayerVsPlayerController.scorePLayer2;
			LabelP1.setText(String.valueOf(s1));
			LabelP2.setText(String.valueOf(s2));
			LabelP1.setStyle("-fx-font-weight: BOLD; -fx-font-size: 30;");
			LabelP2.setStyle("-fx-font-weight: BOLD; -fx-font-size: 30;");
		}
	}

	// Bouton permet de retourner en arrière
	@FXML
	void OnClickBack6() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/application/view/PlayerVsPlayer.fxml"));
		Stage window = (Stage) BackBtn.getScene().getWindow();
		window.setTitle("Morpion");
		window.setScene(new Scene(root));
	}

	// Le tour de joueur est identifié en fonction du compteur
	// Si le compteur est paire, c'est au joueur 1 de jouer
	// Sinon c'est le tour du joueur 2
	@FXML
	void Btn0Click() {
		if (compteur % 2 == 0) {
			Button0.setText("X");
			Button0.setTextFill(Color.BLUE);
		} else {
			Button0.setText("O");
			Button0.setTextFill(Color.RED);
		}
		UpdateBtn(Button0);
	}

	@FXML
	void Btn1Click() {
		if (compteur % 2 == 0) {
			Button1.setText("X");
			Button1.setTextFill(Color.BLUE);
		} else {
			Button1.setText("O");
			Button1.setTextFill(Color.RED);
		}
		UpdateBtn(Button1);
	}

	@FXML
	void Btn2Click() {
		if (compteur % 2 == 0) {
			Button2.setText("X");
			Button2.setTextFill(Color.BLUE);
		} else {
			Button2.setText("O");
			Button2.setTextFill(Color.RED);
		}
		UpdateBtn(Button2);
	}

	@FXML
	void Btn3Click() {
		if (compteur % 2 == 0) {
			Button3.setText("X");
			Button3.setTextFill(Color.BLUE);
		} else {
			Button3.setText("O");
			Button3.setTextFill(Color.RED);
		}
		UpdateBtn(Button3);
	}

	@FXML
	void Btn4Click() {
		if (compteur % 2 == 0) {
			Button4.setText("X");
			Button4.setTextFill(Color.BLUE);
		} else {
			Button4.setText("O");
			Button4.setTextFill(Color.RED);
		}
		UpdateBtn(Button4);
	}

	@FXML
	void Btn5Click() {
		if (compteur % 2 == 0) {
			Button5.setText("X");
			Button5.setTextFill(Color.BLUE);
		} else {
			Button5.setText("O");
			Button5.setTextFill(Color.RED);
		}
		UpdateBtn(Button5);
	}

	@FXML
	void Btn6Click() {
		if (compteur % 2 == 0) {
			Button6.setText("X");
			Button6.setTextFill(Color.BLUE);
		} else {
			Button6.setText("O");
			Button6.setTextFill(Color.RED);
		}
		UpdateBtn(Button6);
	}

	@FXML
	void Btn7Click() {
		if (compteur % 2 == 0) {
			Button7.setText("X");
			Button7.setTextFill(Color.BLUE);
		} else {
			Button7.setText("O");
			Button7.setTextFill(Color.RED);
		}
		UpdateBtn(Button7);
	}

	@FXML
	void Btn8Click() {
		if (compteur % 2 == 0) {
			Button8.setText("X");
			Button8.setTextFill(Color.BLUE);
		} else {
			Button8.setText("O");
			Button8.setTextFill(Color.RED);

		}
		UpdateBtn(Button8);
	}

	public void winneralternate(Button b1, Button b2, Button b3) {
		// Si joueur 1 a gagné
		if ((b1.getText() + b2.getText() + b3.getText()).equals("XXX")) {
			System.out.println("The Winnner is " + PlayerVsPlayerController.name1);
			// Changement de couleur du fond des boutons
			b1.setStyle("-fx-background-color: #EAF411	; ");
			b2.setStyle("-fx-background-color: #EAF411	; ");
			b3.setStyle("-fx-background-color: #EAF411	; ");

			DisableAll();
			TextWinner.setVisible(true);
			winnerName.setText(PlayerVsPlayerController.name1);
			winnerName.setVisible(true);

			// Animation pour le gagnant
			WinnerAnimationCrown(60);

			// Incrémentation du score
			PlayerVsPlayerController.scorePLayer1 += 1;

		} // Si joueur 2 a gagné
		else if ((b1.getText() + b2.getText() + b3.getText()).equals("OOO")) {
			System.out.println("The Winnner is " + PlayerVsPlayerController.name2);
			// Changement de couleur du fond des boutons
			b1.setStyle("-fx-background-color: #EAF411	; ");
			b2.setStyle("-fx-background-color: #EAF411	; ");
			b3.setStyle("-fx-background-color: #EAF411	; ");

			DisableAll();
			TextWinner.setVisible(true);
			winnerName.setText(PlayerVsPlayerController.name2);
			winnerName.setVisible(true);

			// Animation pour le gagnant
			WinnerAnimationCrown(277);

			// Incrémentation du score
			PlayerVsPlayerController.scorePLayer2 += 1;
		} else if (compteur == 9) {
			System.out.println("EQUALS");
			DisableAll();
			winnerName.setText("Egalité");
			winnerName.setVisible(true);
		}

		// Transition du nom du gagnant
		RotateTransition rt = new RotateTransition(Duration.millis(500), winnerName);
		rt.setByAngle(-5);
		rt.setCycleCount(Timeline.INDEFINITE);
		rt.setAutoReverse(true);
		rt.play();
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
		PlayerVsPlayerController.replay = true;
		Parent root = FXMLLoader.load(getClass().getResource("/application/view/StartGameHuman.fxml"));
		Stage window = (Stage) ReplayBtn.getScene().getWindow();
		window.setTitle("Player Vs IA");
		window.setScene(new Scene(root));
	}

	// UpadteBtn permet de modifier le style du bouton après l'avoir utiliser
	// Permet aussi de verifier si le jeu est terminé en utilisant la fonction
	// checkIfGameIsOver()
	// Permet de changer le tour du joueur
	public void UpdateBtn(Button Btn) {
		Btn.setFont(Font.font("Arial", FontWeight.BOLD, 46));
		Btn.setStyle("-fx-opacity: 1");
		Btn.setDisable(true);
		compteur++;
		checkIfGameIsOver();
	}

	// Permet d'animer la page quand un joueur a gagné en utilisant deux trnasitions
	public void WinnerAnimationCrown(int y) {
		// première transition: Une rotation du Crown
		Crown.setVisible(true);
		RotateTransition rt = new RotateTransition(Duration.millis(1000), Crown);
		rt.setByAngle(360);
		rt.setCycleCount(2);
		rt.setAutoReverse(false);
		rt.play();
		// deuxième transition: Mouvement du Crown au-dessus du gagnant
		TranslateTransition translate = new TranslateTransition();
		translate.setByY(y);
		translate.setDuration(Duration.millis(1000));
		translate.setCycleCount(1);
		translate.setAutoReverse(true);
		translate.setNode(Crown);
		translate.play();
	}

}

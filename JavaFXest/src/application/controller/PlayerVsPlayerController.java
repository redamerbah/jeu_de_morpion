package application.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PlayerVsPlayerController {
	@FXML
	private Button ButtonStart_HumanVsIA;

	@FXML
	private TextField namePlayer1;

	@FXML
	private TextField namePlayer2;

	public static String name1;
	public static String name2;
	public static int scorePLayer1 = 0;
	public static int scorePLayer2 = 0;
	public static boolean replay = false;

	@FXML
	private Button BackBtn;

	@FXML
	void initialize() throws IOException {
		//Initialisation du score de 2 joueurs.
		scorePLayer1 = 0;
		scorePLayer2 = 0;
		
		//Si la variable boolean est true, ça veut dire que l'utilisateur veut rejouer, donc calcul du score.
		replay = false;
	}

	@FXML
	void StartPlaying(ActionEvent event) throws IOException {
		//Récuperation des noms des joueurs 
		name1 = namePlayer1.getText();
		name2 = namePlayer2.getText();
		
		Parent root = FXMLLoader.load(getClass().getResource("/application/view/StartGameHuman.fxml"));
		Stage window = (Stage) ButtonStart_HumanVsIA.getScene().getWindow();
		window.setTitle("GAME");
		window.setScene(new Scene(root));
	}

	@FXML
	void OnClickBack4() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/application/view/AccueilInterface.fxml"));
		Stage window = (Stage) BackBtn.getScene().getWindow();
		window.setTitle("Morpion");
		window.setScene(new Scene(root));
	}
}

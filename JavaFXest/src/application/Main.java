package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
//import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//BorderPane root = new BorderPane();
			//Scene scene = new Scene(root,400,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Parent root = FXMLLoader.load(getClass().getResource("view/AccueilInterface.fxml"));
			Scene scene =  new Scene(root);
			//primaryStage.getIcons().add(new Image(getClass().getResource("../../../resources/images/TicTacToe/cross.png").toString(), true));
			
			
			primaryStage.setTitle("Morpion");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

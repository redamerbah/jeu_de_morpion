package application.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import ai.*;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import ai.Coup;
import ai.MultiLayerPerceptron;
import ai.SigmoidalTransferFunction;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import java.net.MalformedURLException;
import java.net.URL;

public class FirstController {

	@FXML
	private ProgressBar progressBarItem;

	@FXML
	private ProgressIndicator progressIndicatorItem;

	@FXML
	private Button PlayBtn;

	@FXML
	private Circle Bounce1;

	@FXML
	private Circle Bounce2;

	@FXML
	private Circle Bounce3;

	@FXML
	private TextField textField1;

	private Task<Double> task;
	public static Thread thread;
	static int l, h;
	static double lr;

	int epochs;
	MultiLayerPerceptron net;

	@FXML
	public void initialize() throws InterruptedException, IOException {

		try {
			System.out.println();
			System.out.println("START TRAINING ...");
			System.out.println();

			int size = 9;
			int[] layers = new int[l + 2];
			layers[0] = size;
			for (int i = 0; i < l; i++) {
				layers[i + 1] = h;
			}
			layers[layers.length - 1] = size;
			double error = 0.0;
			this.net = new MultiLayerPerceptron(layers, lr, new SigmoidalTransferFunction());
			this.epochs = 10000;
			System.out.println("---");
			System.out.println("Load data ...");
			HashMap<Integer, Coup> mapTrain = Test.loadCoupsFromFile("./resources/train_dev_test/train.txt");
			HashMap<Integer, Coup> mapDev = Test.loadCoupsFromFile("./resources/train_dev_test/dev.txt");
			HashMap<Integer, Coup> mapTest = Test.loadCoupsFromFile("./resources/train_dev_test/test.txt");
			System.out.println("---");

			// Boutton n'est pas accessble(cliquable)
			PlayBtn.setDisable(true);

			// Intialiser les progress Bars
			progressBarItem.progressProperty().unbind();
			progressBarItem.setProgress(0);
			progressIndicatorItem.progressProperty().unbind();
			progressIndicatorItem.setProgress(0);

			// Création de la tâche et sa liaison avec la progress Bar
			task = getTask(mapTrain);
			progressIndicatorItem.progressProperty().bind(task.progressProperty());
			progressBarItem.progressProperty().bind(task.progressProperty());

			// Ecouteur
			task.messageProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
					textField1.setText(t1);
				}
			});
			// TRAINING ...
			task.setOnFailed(e -> {
				System.out.println("task failed");
			});
			task.setOnSucceeded(e -> {
				System.out.println("task succeeded");
				PlayBtn.setDisable(false);
			});
			System.out.println("Learning completed!");
			thread = new Thread(this.task);
			thread.start();
			// Save
			net.save("resources/models/" + "ModelLearningSave-H" + h + "-LR" + lr + "-L" + l + ".srl");
		} catch (Exception e) {
			System.out.println("Test.learn()");
			e.printStackTrace();
			System.exit(-1);
		}

	}

	private Task<Double> getTask(HashMap<Integer, Coup> mapTrain) {
		return new Task<Double>() {
			@Override
			protected Double call() throws Exception {
				double error = 0.0;
				System.out.println("" + (epochs / 100));
				for (int i = 0; i < epochs; i++) {
					Coup c = null;
					while (c == null)
						c = mapTrain.get((int) (Math.round(Math.random() * mapTrain.size())));
					error += net.backPropagate(c.in, c.out);
					if (i % (epochs / 100) == 0) {
						System.out.println("Error at step " + i + " is " + (error / (double) i));
						updateMessage("Error at step " + i + " is " + (error / (double) i));
					}
					updateProgress(i, epochs);
				}
				error /= epochs;
				if (epochs < 0) {
					updateMessage("Error is " + error);
				}
				return error;
			}
		};
	}

	@FXML
	private void LoadingToPlayGame(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/application/view/StartGameIA.fxml"));
		Stage window = (Stage) PlayBtn.getScene().getWindow();
		window.setTitle("Player Vs IA");
		window.setScene(new Scene(root));
	}

};

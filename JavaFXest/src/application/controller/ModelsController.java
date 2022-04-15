package application.controller;

import java.io.*;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class ModelsController {

	@FXML
	private ListView<String> ModelsList;

	@FXML
	private Button deleteBtn;

	public void initialize() {
		deleteBtn.setDisable(true);
		
		//Listener qui active le bouton si un fichier est séléctionné 
		ModelsList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				deleteBtn.setDisable(false);
			}
		});

		//Lister les fichiers du repertoire models dans une liste
		File file = new File("resources/models");
		String liste[] = file.list();
		if (liste != null) {
			ModelsList.getItems().setAll(liste);
			for (int i = 0; i < liste.length; i++) {
				System.out.println(liste[i]);
			}
		} else {
			System.err.println("Nom de repertoire invalide");
		}
	}

	//Cette fonction permet de supprimer le model selectionné
	public void DeleteModel(ActionEvent event) {
		String model = ModelsList.getItems().get(ModelsList.getSelectionModel().getSelectedIndex());
		File fileDelete = new File("resources/models/" + model);
		ModelsList.getItems().removeAll(ModelsList.getSelectionModel().getSelectedItems());
		if (fileDelete.delete()) {
			System.out.println(fileDelete.getName() + " supprimé.");
		} else {
			System.out.println("Echoué");
		}
	}

}

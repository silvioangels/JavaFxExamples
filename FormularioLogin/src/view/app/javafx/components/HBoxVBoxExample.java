package view.app.javafx.components;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HBoxVBoxExample extends Application {

	private AnchorPane pane;

	@Override
	public void start(Stage stage) throws Exception {

		initComponents();
		initHBoxAndVBox();

		Scene scene = new Scene(pane);
		stage.setScene(scene);

		// Remove a opção de maximizar a tela
		stage.setResizable(false);

		// Dá um título para a tela
		stage.setTitle("Accordion Component");

		stage.show();

	}

	private void initComponents() {
		pane = new AnchorPane();
		pane.setPrefSize(800, 600);
	}

	private void initHBoxAndVBox() {

		HBox hBox = new HBox();
		Label lbHBox1 = new Label("Estamos... ");
		Label lbHBox2 = new Label("na caixa... ");
		Label lbHBox3 = new Label("horizontal!!!");
		hBox.getChildren().addAll(lbHBox1, lbHBox2, lbHBox3);
		VBox vBox = new VBox();
		vBox.setLayoutY(30);
		Label lbVBox1 = new Label("Agora estamos...");
		Label lbVBox2 = new Label("na caixa...");
		Label lbVBox3 = new Label("vertical!!!");
		vBox.getChildren().addAll(lbVBox1, lbVBox2, lbVBox3);
		pane.getChildren().addAll(hBox,vBox);
	}

	public static void main(String[] args) {
		launch(args);
	}
}

package view.app.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaComJavaFX extends Application {
	private AnchorPane pane;
	private Label lbMensagem;

	@Override
	public void start(Stage stage) throws Exception {
		pane = new AnchorPane();
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Nossa tela com JavaFX!");
		stage.show();
		initComponents();
	}

	private void initComponents() {
		lbMensagem = new Label("Casa do Código!");
		pane.getChildren().add(lbMensagem);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
package view.app.javafx.components;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ToolTipExample extends Application {

	private AnchorPane pane;

	@Override
	public void start(Stage stage) throws Exception {

		initComponents();
		initTooltip();

		Scene scene = new Scene(pane);
		stage.setScene(scene);

		// Remove a opção de maximizar a tela
		stage.setResizable(false);

		// Dá um título para a tela
		stage.setTitle("HTML Editor Example");

		stage.show();

	}

	private void initComponents() {
		pane = new AnchorPane();
		pane.setPrefSize(800, 600);
	}

	private void initTooltip() {

		Label lbNome = new Label("Nome: ");
		TextField txNome = new TextField();
		txNome.setLayoutX(50);
		Tooltip.install(txNome, new Tooltip("Digite aqui seu nome completo..."));

		pane.getChildren().addAll(lbNome,txNome);
	}

	public static void main(String[] args) {
		launch(args);
	}
}

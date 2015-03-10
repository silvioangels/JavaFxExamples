package view.app.javafx.components;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneExample extends Application {

	private AnchorPane pane;

	@Override
	public void start(Stage stage) throws Exception {

		initComponents();
		initGridPane();

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

	private void initGridPane() {

		GridPane gPane = new GridPane();
		gPane.setHgap(10);
		gPane.setVgap(10);
		Label lbLogin = new Label("Login:");
		TextField txLogin = new TextField();
		Label lbSenha = new Label("Senha:");
		PasswordField txSenha = new PasswordField();
		Button btEntrar = new Button("Entrar");
		Button btSair = new Button("Sair");
		gPane.addRow(0, lbLogin, txLogin);
		gPane.addRow(1, lbSenha, txSenha);
		gPane.addRow(2, btEntrar, btSair);
		
		pane.getChildren().addAll(gPane);
	}

	public static void main(String[] args) {
		launch(args);
	}
}

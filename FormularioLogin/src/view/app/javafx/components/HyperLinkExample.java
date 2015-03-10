package view.app.javafx.components;

import java.awt.Desktop;
import java.net.URI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HyperLinkExample extends Application {

	private AnchorPane pane;

	@Override
	public void start(Stage stage) throws Exception {

		initComponents();
		initHyperlink();

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

	private void initHyperlink() {

		Hyperlink link = new Hyperlink("Clique aqui...");
		link.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					Desktop.getDesktop().browse(
							new URI("http://www.casadocodigo.com.br"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		pane.getChildren().addAll(link);
	}

	public static void main(String[] args) {
		launch(args);
	}
}

package view.app.javafx.components;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AccordionExample extends Application {

	private AnchorPane pane;
	private Accordion accordion;

	@Override
	public void start(Stage stage) throws Exception {

		initComponents();
		initAccordion();
		
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

	private void initAccordion() {
		
		accordion = new Accordion();
		TitledPane tPane1 = new TitledPane("Primeiro Painel", new Label(
				"Primeiro painel aberto!"));
		TitledPane tPane2 = new TitledPane("Segundo Painel", new Label(
				"Segundo painel aberto!"));
		TitledPane tPane3 = new TitledPane("Terceiro Painel", new Label(
				"Terceiro painel aberto!"));
		accordion.getPanes().addAll(tPane1, tPane2, tPane3);
		pane.getChildren().addAll(accordion);
	}

	public static void main(String[] args) {
		launch(args);
	}
}

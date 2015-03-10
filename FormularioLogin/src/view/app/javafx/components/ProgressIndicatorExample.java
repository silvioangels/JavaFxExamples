package view.app.javafx.components;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.JOptionPane;

public class ProgressIndicatorExample extends Application {

	private AnchorPane pane;

	@Override
	public void start(Stage stage) throws Exception {

		initComponents();
		initProgressIndicator();

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

	private void initProgressIndicator() {

		ProgressIndicator progress = new ProgressIndicator(0.0);
		Task<Void> task = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				final int max = 10;
				for (int i = 1; i <= max; i++) {
					updateProgress(i, max);
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				JOptionPane.showMessageDialog(null, "Progresso concluído!");
				return null;
			}
		};
		progress.progressProperty().bind(task.progressProperty());
		new Thread(task).start();

		pane.getChildren().addAll(progress);
	}

	public static void main(String[] args) {
		launch(args);
	}
}

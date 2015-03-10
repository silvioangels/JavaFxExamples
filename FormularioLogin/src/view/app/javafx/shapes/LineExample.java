package view.app.javafx.shapes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class LineExample extends Application {

	private AnchorPane pane;

	@Override
	public void start(Stage stage) throws Exception {

		initComponents();
		initLine();
		
		Scene scene = new Scene(pane);
		stage.setScene(scene);

		// Remove a opção de maximizar a tela
		stage.setResizable(false);

		// Dá um título para a tela
		stage.setTitle("Audio Video Examples");

		stage.show();

	}

	private void initComponents() {
		pane = new AnchorPane();
		pane.setPrefSize(800, 600);
	}

	private void initLine() {
		
		Line line = new Line();
		line.setLayoutX(10);
		line.setLayoutY(10);
		line.setStartX(0);
		line.setStartY(0);
		line.setEndX(100);
		line.setEndY(100);
		Line line2 = new Line();
		line2.setLayoutX(10);
		line2.setLayoutY(10);
		line2.setStartX(100);
		line2.setStartY(0);
		line2.setEndX(0);
		line2.setEndY(100);
		
		pane.getChildren().addAll(line,line2 );
	}

	public static void main(String[] args) {
		launch(args);
	}
}

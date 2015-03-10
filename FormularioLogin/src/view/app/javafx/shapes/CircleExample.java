package view.app.javafx.shapes;

import javafx.animation.FadeTransition;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class CircleExample extends Application {

	private AnchorPane pane;

	@Override
	public void start(Stage stage) throws Exception {

		initComponents();
		initCircle();
		
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

	private void initCircle() {
		
		Circle circle = new Circle();
		circle.setFill(Color.AQUA);
		circle.setCenterX(100);
		circle.setCenterY(100);
		circle.setRadius(50);
		FadeTransition transition = new FadeTransition(
		Duration.millis(1000), circle);
		transition.setFromValue(0.0);
		transition.setToValue(1.0);
		transition.setAutoReverse(true);
		transition.setCycleCount(Transition.INDEFINITE);
		transition.play();
		
		pane.getChildren().addAll(circle);
	}

	public static void main(String[] args) {
		launch(args);
	}
}

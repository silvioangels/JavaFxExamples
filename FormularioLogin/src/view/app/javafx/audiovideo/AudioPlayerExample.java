package view.app.javafx.audiovideo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import view.app.swing.TelaComSwing;

public class AudioPlayerExample extends Application {

	private AnchorPane pane;

	@Override
	public void start(Stage stage) throws Exception {

		initComponents();
		initAudioPlayer();
		
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

	private void initAudioPlayer() {
		
		Label lbTocando = new Label("Tocando música...");
		Media media = new Media(TelaComSwing.class.getResource("audio.mp3")
		.toExternalForm());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		
		pane.getChildren().addAll(lbTocando);
	}

	public static void main(String[] args) {
		launch(args);
	}
}

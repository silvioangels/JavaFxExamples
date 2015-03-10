package view.app.javafx.audiovideo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import view.app.swing.TelaComSwing;

public class VideoPlayerExample extends Application {

	private AnchorPane pane;

	@Override
	public void start(Stage stage) throws Exception {

		initComponents();
		initVideoPlayer();

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

	private void initVideoPlayer() {

		Media media = new Media(TelaComSwing.class.getResource("video.mp4").toExternalForm());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		mediaPlayer.setAutoPlay(true);
		MediaView mediaView = new MediaView(mediaPlayer);
		mediaView.setFitWidth(300);
		mediaView.setFitHeight(200);

		pane.getChildren().addAll(mediaView);
	}

	public static void main(String[] args) {
		launch(args);
	}
}

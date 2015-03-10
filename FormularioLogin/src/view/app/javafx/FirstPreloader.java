package view.app.javafx;

import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FirstPreloader extends Preloader {

	ProgressBar bar;
	Stage stage;

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;
		stage.setScene(createPreloaderScene());
		stage.show();
	}

	private Scene createPreloaderScene() {
		bar = new ProgressBar();
		BorderPane p = new BorderPane();
		p.setCenter(bar);
		return new Scene(p, 300, 150);
	}

	@Override
	public void handleProgressNotification(ProgressNotification pn) {
		bar.setProgress(pn.getProgress());
	}

	@Override
	public void handleStateChangeNotification(StateChangeNotification evt) {
		if (evt.getType() == StateChangeNotification.Type.BEFORE_START) {
			stage.hide();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

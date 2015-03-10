package view.app.swing;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TelaComSwingJavaFx extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static void initComponents() {
		JFrame frame = new JFrame("Tela com Swing + JavaFX!");
		final JFXPanel fxPanel = new JFXPanel();
		frame.add(fxPanel);
		frame.setSize(300, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				initFX(fxPanel);
			}
		});
	}

	private static void initFX(JFXPanel fxPanel) {
		Scene scene = createScene();
		fxPanel.setScene(scene);
	}

	private static Scene createScene() {
		AnchorPane root = new AnchorPane();
		Scene scene = new Scene(root);
		Label lbMensagem = new Label("Casa do Código!");
		root.getChildren().add(lbMensagem);
		return scene;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				initComponents();
			}
		});
	}

}

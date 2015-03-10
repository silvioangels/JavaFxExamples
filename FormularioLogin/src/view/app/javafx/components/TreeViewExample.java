package view.app.javafx.components;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TreeViewExample extends Application {

	private AnchorPane pane;

	@Override
	public void start(Stage stage) throws Exception {

		initComponents();
		initTreeView();

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

	@SuppressWarnings("unchecked")
	private void initTreeView() {

		TreeView<String> treeView = new TreeView<String>();
		TreeItem<String> item1 = new TreeItem<String>("Tópico 1");
		TreeItem<String> subitem1 = new TreeItem<String>("Tópico 1.1");
		TreeItem<String> subitem1_1 = new TreeItem<String>("Tópico 1.1.1");
		TreeItem<String> subitem1_2 = new TreeItem<String>("Tópico 1.1.2");
		TreeItem<String> subitem2 = new TreeItem<String>("Tópico 1.2");
		TreeItem<String> subitem3 = new TreeItem<String>("Tópico 1.3");
		TreeItem<String> subitem3_1 = new TreeItem<String>("Tópico 1.3.1");
		item1.getChildren().addAll(subitem1, subitem2, subitem3);
		subitem1.getChildren().addAll(subitem1_1, subitem1_2);
		subitem3.getChildren().add(subitem3_1);
		treeView.setRoot(item1);

		pane.getChildren().addAll(treeView);
	}

	public static void main(String[] args) {
		launch(args);
	}
}

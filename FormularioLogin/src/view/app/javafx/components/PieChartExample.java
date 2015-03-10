package view.app.javafx.components;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PieChartExample extends Application {

	private AnchorPane pane;

	@Override
	public void start(Stage stage) throws Exception {

		initComponents();
		initPieChart();

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

	@SuppressWarnings("unchecked")
	private void initPieChart() {

		PieChart chartLinguagens = new PieChart();
		chartLinguagens
				.setTitle("Ranking de Linguagens de Programação Mar/2013");
		ObservableList<PieChart.Data> datas = FXCollections
				.observableArrayList(new PieChart.Data("Java", 18.156),
						new PieChart.Data("C", 17.141), new PieChart.Data(
								"Objective-C", 10.230), new PieChart.Data(
								"C++", 9.115), new PieChart.Data("C#", 6.597),
						new PieChart.Data("Outros", 38.761));
		chartLinguagens.setData(datas);

		pane.getChildren().addAll(chartLinguagens);
	}

	public static void main(String[] args) {
		launch(args);
	}
}

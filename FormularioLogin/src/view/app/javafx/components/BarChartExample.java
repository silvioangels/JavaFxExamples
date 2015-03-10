package view.app.javafx.components;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class BarChartExample extends Application {

	private AnchorPane pane;

	@Override
	public void start(Stage stage) throws Exception {

		initComponents();
		initBarChart();

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
	private void initBarChart() {

		BarChart<String, Number> chartLinguagens = new BarChart<String, Number>(
				new CategoryAxis(), new NumberAxis());
		chartLinguagens.setCategoryGap(20);
		chartLinguagens
				.setTitle("Ranking de Linguagens de Programação Mar/2013");
		XYChart.Data<String, Number> dataJava = new XYChart.Data<String, Number>("Java", 18.156);
		XYChart.Data<String, Number> dataC = new XYChart.Data<String, Number>("C", 17.141);
		XYChart.Data<String, Number> dataObjectiveC = new XYChart.Data<String, Number>("Objective-C", 10.230);
		XYChart.Data<String, Number> dataCPlus = new XYChart.Data<String, Number>("C++", 9.115);
		XYChart.Data<String, Number> dataCSharp = new XYChart.Data<String, Number>("C#", 6.597);
		XYChart.Series<String, Number> seriesData = new XYChart.Series<String, Number>();
		seriesData.setName("Porcentagem (%)");
		seriesData.getData().addAll(dataJava, dataC, dataObjectiveC, dataCPlus,dataCSharp);
		chartLinguagens.getData().add(seriesData);

		pane.getChildren().addAll(chartLinguagens);
	}

	public static void main(String[] args) {
		launch(args);
	}
}

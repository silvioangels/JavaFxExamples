package view.app.javafx.components;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LineChartExample extends Application {

	private AnchorPane pane;

	@Override
	public void start(Stage stage) throws Exception {

		initComponents();
		initLineChart();

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
	private void initLineChart() {

		LineChart<Number, Number> chartLinguagens = new LineChart<Number, Number>(new NumberAxis(2008, 2013, 5), new NumberAxis());
		chartLinguagens.setTitle("Ranking de Linguagens de Programação Mar/2013");
		XYChart.Series<Number, Number> serieJava = new XYChart.Series<Number, Number>();
		serieJava.setName("Java");
		serieJava.getData().addAll(new XYChart.Data<Number, Number>(2008, 1),new XYChart.Data<Number, Number>(2013, 1));
		XYChart.Series<Number, Number> serieC = new XYChart.Series<Number, Number>();
		serieC.setName("C");
		serieC.getData().addAll(new XYChart.Data<Number, Number>(2008, 2),new XYChart.Data<Number, Number>(2013, 2));
		XYChart.Series<Number, Number> serieObjectiveC = new XYChart.Series<Number, Number>();
		serieObjectiveC.setName("Objective-C");
		serieObjectiveC.getData().addAll(new XYChart.Data<Number, Number>(2008, 45),new XYChart.Data<Number, Number>(2013, 3));
		XYChart.Series<Number, Number> serieCPlus = new XYChart.Series<Number, Number>();
		serieCPlus.setName("C++");
		serieCPlus.getData().addAll(new XYChart.Data<Number, Number>(2008, 5),new XYChart.Data<Number, Number>(2013, 4));
		XYChart.Series<Number, Number> serieCSharp = new XYChart.Series<Number, Number>();
		serieCSharp.setName("C#");
		serieCSharp.getData().addAll(new XYChart.Data<Number, Number>(2008, 8),new XYChart.Data<Number, Number>(2013, 5));
		chartLinguagens.getData().addAll(serieJava, serieC, serieObjectiveC,serieCPlus, serieCSharp);

		pane.getChildren().addAll(chartLinguagens);
	}

	public static void main(String[] args) {
		launch(args);
	}
}

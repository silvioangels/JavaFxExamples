package view.app.javafx;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.InnerShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Produto;

public class ItemApp extends Application {

	private AnchorPane pane;
	private ImageView imgItem;
	private Label lbPreco, lbDescricao;
	private Button btAddCarrinho;
	public static Stage stage;
	private static Produto produto;

	private static int index;
	private static String[] images = {
			"http://www.sportcenterlopes.com.br/images/250_topper_campo_2009replic.jpg",
			"http://1.bp.blogspot.com/_H8uGs8K8kaY/TLZTXR8nIgI/AAAAAAAAF_0/BvpxdqGF4PE/s1600/luva_umbro.png",
			"http://bimg2.mlstatic.com/camisa-nike-active-importada-manga-longa-esportiva-vermelha_MLB-F-199843960_1391.jpg",
			"http://www.showtenis.com.br/images/_product/979/979112/chuteira-nike-mercurial-glide-3-fg-campo--199fd9.jpg",
			"http://www.sportcenterlopes.com.br/images/17102012_174044.jpg" };

	@Override
	public void start(Stage stage) throws Exception {

		initComponents();
		initLayout();
		initListeners();
		initTransition();
		initTimeline();

		Scene scene = new Scene(pane);
		stage.setScene(scene);

		// Remove a opção de maximizar a tela
		stage.setResizable(false);

		// Dá um título para a tela
		stage.setTitle("Item - GolFX");

		stage.show();

		ItemApp.stage = stage;

	}

	private void initTimeline() {
		Timeline timeline = new Timeline();
		KeyValue kv = new KeyValue(imgItem.opacityProperty(), 0.0);
		KeyFrame kf = new KeyFrame(Duration.millis(2000), kv);
		timeline.getKeyFrames().add(kf);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.setAutoReverse(true);
		timeline.play();
	}

	private void initTransition() {

		FadeTransition fTransition = new FadeTransition(Duration.millis(2000),
				imgItem);
		fTransition.setFromValue(0.0);
		fTransition.setToValue(1.0);
		fTransition.play();

		/**
		 * Transicao Paralela
		 */
		/*
		 * FadeTransition fTransition = new
		 * FadeTransition(Duration.millis(2000), imgItem);
		 * fTransition.setFromValue(0.0); fTransition.setToValue(1.0);
		 * 
		 * ScaleTransition sTransition = new ScaleTransition(
		 * Duration.millis(2000), btAddCarrinho); sTransition.setToX(1.5);
		 * sTransition.setToY(1.5); sTransition.setAutoReverse(true);
		 * ParallelTransition pTransition = new ParallelTransition();
		 * pTransition.getChildren().addAll(fTransition, sTransition);
		 * pTransition.play();
		 */

	}

	private void initComponents() {

		try {

			pane = new AnchorPane();
			pane.setPrefSize(600, 400);
			pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, blue 0%, silver 100%);");
			imgItem = new ImageView(new Image(images[index]));
			imgItem.setFitWidth(300);
			imgItem.setFitHeight(200);
			imgItem.setEffect(new Reflection());

			lbDescricao = new Label("Descricao: " + getProduto().getProduto());
			lbPreco = new Label("Preco: " + getProduto().getPreco());

			btAddCarrinho = new Button("Adicionar ao Carrinho");
			InnerShadow is = new InnerShadow();
			is.setColor(Color.RED);
			btAddCarrinho.setEffect(is);

			pane.getChildren().addAll(imgItem, lbDescricao, lbPreco,
					btAddCarrinho);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initLayout() {

		lbPreco.setLayoutX(350);
		lbPreco.setLayoutY(120);
		lbPreco.setTextFill(Color.WHITE);

		lbDescricao.setLayoutX(350);
		lbDescricao.setLayoutY(150);
		lbDescricao.setTextFill(Color.WHITE);

		btAddCarrinho.setLayoutX(350);
		btAddCarrinho.setLayoutY(250);

	}

	private void initListeners() {
		btAddCarrinho.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				VitrineApp.getCarrinho().addProdutos(produto);
				try {
					new CarrinhoApp().start(new Stage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		/**
		 * Efetiro Aumentar Diminuir Tamanho
		 */
		btAddCarrinho.setOnMouseEntered(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				ScaleTransition transition = new ScaleTransition(Duration
						.millis(2000), btAddCarrinho);
				transition.setToX(1.5);
				transition.setToY(1.5);
				transition.play();
			}
		});

		btAddCarrinho.setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				ScaleTransition transition = new ScaleTransition(Duration
						.millis(2000), btAddCarrinho);
				transition.setToX(1.0);
				transition.setToY(1.0);
				transition.play();
			}
		});

	}

	public static Stage getStage() {
		return stage;
	}

	public static Produto getProduto() {
		return produto;
	}

	public static void setProduto(Produto produto) {
		ItemApp.produto = produto;
	}

	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		ItemApp.index = index;
	}

	public static void main(String[] args) {
		launch(args);
	}

}

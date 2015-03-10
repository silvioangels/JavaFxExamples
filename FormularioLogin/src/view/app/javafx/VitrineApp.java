package view.app.javafx;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Produto;
import controller.Carrinho;
import controller.Vitrine;

public class VitrineApp extends Application {

	private AnchorPane pane;
	private TextField txPesquisa;
	private TableView<ItensProperty> tbVitrine;
	private TableColumn<ItensProperty, String> columnProduto;
	private TableColumn<ItensProperty, Double> columnPreco;
	private static ObservableList<ItensProperty> listItens = FXCollections
			.observableArrayList();
	public static Carrinho carrinho;
	private static Stage stage;

	private static Produto[] produtos = { new Produto("Bola Topper", 15.00),
			new Produto("Luvas Umbro", 9.00),
			new Produto("Camisa Esportiva", 40.00),
			new Produto("Chuteira Nike Mercurial", 199.00),
			new Produto("Caneleira Topper", 10.00) };

	@Override
	public void start(Stage stage) throws Exception {
		initComponents();
		initItens();
		initListeners();

		Scene scene = new Scene(pane);
		stage.setScene(scene);

		// Remove a opção de maximizar a tela
		stage.setResizable(false);

		// Dá um título para a tela
		stage.setTitle("Vitrini - GolFX");

		stage.show();

		VitrineApp.stage = stage;
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public static Stage getStage() {
		return stage;
	}

	@SuppressWarnings("unchecked")
	private void initComponents() {
		pane = new AnchorPane();
		pane.setPrefSize(800, 600);
		pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, blue 0%, silver 100%);");

		txPesquisa = new TextField();
		txPesquisa.setLayoutX(550);
		txPesquisa.setPrefWidth(200);
		txPesquisa.setPromptText("Digite o item para pesquisa");
		DropShadow ds = new DropShadow();
		ds.setSpread(0.5);
		ds.setColor(Color.RED);
		txPesquisa.setEffect(ds);

		tbVitrine = new TableView<ItensProperty>();
		tbVitrine.setPrefSize(780, 550);
		tbVitrine.setLayoutY(40);

		columnProduto = new TableColumn<ItensProperty, String>();
		columnPreco = new TableColumn<ItensProperty, Double>();

		columnProduto
				.setCellValueFactory(new PropertyValueFactory<ItensProperty, String>(
						"produto"));
		columnPreco
				.setCellValueFactory(new PropertyValueFactory<ItensProperty, Double>(
						"preco"));

		columnProduto.setPrefWidth(600);
		columnPreco.setPrefWidth(180);

		columnProduto.setText("produto");
		columnPreco.setText("preco");

		tbVitrine.getColumns().addAll(columnProduto, columnPreco);

		pane.getChildren().addAll(txPesquisa, tbVitrine);

		carrinho = new Carrinho();
	}

	private void initItens() {
		Vitrine v = new Vitrine();
		v.addProdutos(produtos);

		for (Produto p : v.getProdutos()) {
			listItens.add(new ItensProperty(p.getProduto(), p.getPreco()));
		}

	}

	private ObservableList<ItensProperty> findItems() {
		ObservableList<ItensProperty> itensEncontrados = FXCollections
				.observableArrayList();

		for (ItensProperty itens : listItens) {
			if (itens.getProduto().contains(txPesquisa.getText())) {
				itensEncontrados.add(itens);
			}
		}
		return itensEncontrados;
	}

	private void initListeners() {

		txPesquisa.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (!txPesquisa.getText().equals("")) {
					tbVitrine.setItems(findItems());
				} else {
					tbVitrine.setItems(listItens);
				}
			}
		});

		tbVitrine.getSelectionModel().selectedItemProperty()
				.addListener(new ChangeListener<ItensProperty>() {
					@Override
					public void changed(
							ObservableValue<? extends ItensProperty> value,
							ItensProperty oldItem, ItensProperty newItem) {
						/*
						 * Indicando os valores de produto e index para ItemApp
						 */
						ItemApp.setProduto(new Produto(newItem.getProduto(),
								newItem.getPreco()));
						ItemApp.setIndex(tbVitrine.getSelectionModel()
								.getSelectedIndex());
						/* Chamando o formulário de exibição de item */
						try {
							new ItemApp().start(new Stage());
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

	}

	public class ItensProperty {
		private SimpleStringProperty produto;
		private SimpleDoubleProperty preco;

		public ItensProperty(String produto, double preco) {
			this.produto = new SimpleStringProperty(produto);
			this.preco = new SimpleDoubleProperty(preco);
		}

		public String getProduto() {
			return produto.get();
		}

		public void setProduto(String produto) {
			this.produto.set(produto);
		}

		public double getPreco() {
			return preco.get();
		}

		public void setPreco(double preco) {
			this.preco.set(preco);
		}
	}

	public static Carrinho getCarrinho() {
		return carrinho;
	}

	public static void setCarrinho(Carrinho carrinho) {
		VitrineApp.carrinho = carrinho;
	}

}

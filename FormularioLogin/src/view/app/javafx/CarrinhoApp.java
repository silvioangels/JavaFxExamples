package view.app.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.JOptionPane;

import model.Produto;

public class CarrinhoApp extends Application {

	private AnchorPane pane;
	private TableView<ItensProperty> tbCarrinho;
	private TableColumn<ItensProperty, String> columnProduto;
	private TableColumn<ItensProperty, Double> columnPreco;
	private Button btExcluirItem, btVoltarVitrine, btConfirmarCompra;
	private static ObservableList<ItensProperty> listItens;
	private static Stage stage;

	@Override
	public void start(Stage stage) throws Exception {

		initComponents();
		initItens();
		initLayout();
		initListeners();

		Scene scene = new Scene(pane);
		stage.setScene(scene);

		// Remove a opção de maximizar a tela
		stage.setResizable(false);

		// Dá um título para a tela
		stage.setTitle("Carrinho - GolFX");

		stage.show();

		CarrinhoApp.stage = stage;

	}

	@SuppressWarnings("unchecked")
	private void initComponents() {

		try {

			pane = new AnchorPane();
			pane.setPrefSize(800, 600);
			pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, blue 0%, silver 100%);");

			listItens = FXCollections.observableArrayList();

			tbCarrinho = new TableView<ItensProperty>();
			tbCarrinho.setPrefSize(780, 550);
			tbCarrinho.setLayoutY(40);

			columnProduto = new TableColumn<ItensProperty, String>();
			columnPreco = new TableColumn<ItensProperty, Double>();

			columnProduto
					.setCellValueFactory(new PropertyValueFactory<ItensProperty, String>(
							"produto"));
			columnPreco
					.setCellValueFactory(new PropertyValueFactory<ItensProperty, Double>(
							"preco"));

			columnProduto.setText("produto");
			columnPreco.setText("preco");

			columnProduto.setPrefWidth(600);
			columnPreco.setPrefWidth(180);

			tbCarrinho.getColumns().addAll(columnProduto, columnPreco);

			btExcluirItem = new Button("Excluir Item");
			btVoltarVitrine = new Button("Voltar Vitrini");
			btConfirmarCompra = new Button("Confirmar Compra");

			pane.getChildren().addAll(tbCarrinho, btExcluirItem,
					btVoltarVitrine, btConfirmarCompra);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initLayout() {

		btVoltarVitrine.setLayoutX(200);
		btConfirmarCompra.setLayoutX(400);

	}

	private void initItens() {
		for (Produto p : VitrineApp.getCarrinho().getProdutos()) {
			listItens.add(new ItensProperty(p.getProduto(), p.getPreco()));
		}
	}

	private void initListeners() {

		tbCarrinho.setItems(listItens);

		btExcluirItem.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				VitrineApp.carrinho.removeProduto(new Produto(tbCarrinho
						.getSelectionModel().getSelectedItem().getProduto(),
						tbCarrinho.getSelectionModel().getSelectedItem()
								.getPreco()));
				tbCarrinho.getItems().remove(
						tbCarrinho.getSelectionModel().getSelectedItem());
			}
		});

		btVoltarVitrine.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				CarrinhoApp.getStage().close();
				ItemApp.getStage().close();
			}
		});

		btConfirmarCompra.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Thread thread = new Thread() {
					public void run() {
						try {
							sleep(5000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(null,"Compra realizada com sucesso!");
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								CarrinhoApp.getStage().close();
								ItemApp.getStage().close();
							}
						});
					};
				};
				thread.start();
			}
		});

	}

	public static Stage getStage() {
		return stage;
	}

	public static void main(String[] args) {
		launch(args);
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

}

package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import view.app.javafx.LoginApp;
import view.app.javafx.VitrineApp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	@FXML
	private TextField txLogin;

	@FXML
	private PasswordField txSenha;

	@FXML
	private Button btEntrar, btSair;

	@Override
	public void initialize(URL url, ResourceBundle bundle) {
		btEntrar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				logar();
			}
		});
		btSair.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				fecharAplicacao();
			}
		});

	}
	
	private void logar() {
		if (txLogin.getText().equals("admin")
				&& txSenha.getText().equals("admin")) {
			try {
				new VitrineApp().start(new Stage());
				LoginApp.getStage().close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Login e/ou senha inválidos",
					"Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void fecharAplicacao() {
		System.exit(0);
	}


}

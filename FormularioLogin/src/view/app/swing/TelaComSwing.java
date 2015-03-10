package view.app.swing;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaComSwing extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pane;
	private JLabel lbMensagem;

	public TelaComSwing() {
		super("Nossa tela com Swing!");
		initComponents();
	}

	private void initComponents() {
		pane = new JPanel();
		lbMensagem = new JLabel("Casa do Código!");
		pane.add(lbMensagem);
		getContentPane().add(pane, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new TelaComSwing();
	}

}

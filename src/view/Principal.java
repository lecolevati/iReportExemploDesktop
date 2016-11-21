package view;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.RelatorioController;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfEmpresa;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmpresa = new JLabel("Empresa");
		lblEmpresa.setBounds(35, 80, 69, 14);
		contentPane.add(lblEmpresa);
		
		tfEmpresa = new JTextField();
		tfEmpresa.setBounds(114, 77, 173, 20);
		contentPane.add(tfEmpresa);
		tfEmpresa.setColumns(10);
		
		JButton btnGerar = new JButton("Gerar");
		btnGerar.setBounds(319, 76, 89, 23);
		contentPane.add(btnGerar);
		ActionListener rc = new RelatorioController(tfEmpresa);
		btnGerar.addActionListener(rc);
	}
}

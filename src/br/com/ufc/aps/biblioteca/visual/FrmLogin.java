package br.com.ufc.aps.biblioteca.visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.ufc.aps.biblioteca.visual.controller.FrmLoginController;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmLogin extends JFrame {
	private JComboBox<Object> comboBox;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMatricula;
	private JPasswordField txtSenha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					FrmLogin frame = new FrmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmLogin() throws ClassNotFoundException {
		setTitle("Login - Biblioteca");
		this.setLocationRelativeTo(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 289, 214);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
		});
		btnEntrar.setBounds(89, 135, 89, 23);
		contentPane.add(btnEntrar);

		txtMatricula = new JTextField();
		txtMatricula.setBounds(41, 25, 187, 20);
		contentPane.add(txtMatricula);
		txtMatricula.setColumns(10);

		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setBounds(41, 11, 64, 14);
		contentPane.add(lblMatricula);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(41, 56, 46, 14);
		contentPane.add(lblSenha);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(41, 71, 187, 20);
		contentPane.add(txtSenha);
		
	    comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Aluno", "Bibliotecario"}));
		comboBox.setBounds(79, 102, 106, 22);
		contentPane.add(comboBox);
	}

	@SuppressWarnings("deprecation")
	public void logar() {
		
		int matricula = Integer.parseInt(txtMatricula.getText());
		String senha = txtSenha.getText();
		
		if (!new FrmLoginController().authenticateLogin(comboBox.getSelectedIndex(), matricula, senha)) {
			JOptionPane.showMessageDialog(null, "Matricula ou Senha invalida");
			return;
		}
		if (comboBox.getSelectedIndex() == 1) 
			new FrmMenuBibliotecario().setVisible(true);
		else
			new FrmMenuAluno().setVisible(true);
		JOptionPane.showMessageDialog(null, "Bem vindo ao sistema!");

		dispose();
	}
		
}

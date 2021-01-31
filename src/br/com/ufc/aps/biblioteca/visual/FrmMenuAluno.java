package br.com.ufc.aps.biblioteca.visual;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

public class FrmMenuAluno extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMenuAluno frame = new FrmMenuAluno();
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
	public FrmMenuAluno() {
		//this.setExtendedState(MAXIMIZED_BOTH); //Maximizar a tela
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBuscarLivro = new JButton("Buscar Livro");
		btnBuscarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmLivroFind jt = new FrmLivroFind();
				jt.setVisible(true);
				
			}
		});
		btnBuscarLivro.setBounds(238, 71, 142, 70);
		contentPane.add(btnBuscarLivro);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Você foi deslogado","Biblioteca", JOptionPane.INFORMATION_MESSAGE);
				dispose();
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
		btnSair.setBounds(335, 11, 89, 23);
		contentPane.add(btnSair);
		
		JButton btnRealizarAluguel = new JButton("Buscar aluguel");
		btnRealizarAluguel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrmAluguelFind al = new FrmAluguelFind();
				al.setVisible(true);
			}
		});
		btnRealizarAluguel.setBounds(43, 71, 148, 70);
		contentPane.add(btnRealizarAluguel);
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}

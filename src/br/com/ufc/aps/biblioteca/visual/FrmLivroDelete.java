package br.com.ufc.aps.biblioteca.visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import br.com.ufc.aps.biblioteca.visual.controller.FrmLivroController;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmLivroDelete extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLivro;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblLivro;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLivroDelete frame = new FrmLivroDelete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmLivroDelete() {

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtLivro = new JTextField();
		txtLivro.setBounds(10, 27, 175, 20);
		contentPane.add(txtLivro);
		txtLivro.setColumns(10);

		table = new JTable(new FrmLivroController().getAllLivro());

		JButton btnOk = new JButton("Deletar");
		btnOk.setBounds(96, 67, 89, 23);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletar();
			}
		});
		contentPane.add(btnOk);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 447, 164);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
	
		lblLivro = new JLabel("Livro");
		lblLivro.setBounds(10, 11, 46, 14);
		contentPane.add(lblLivro);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void deletar() {
		int status = new FrmLivroController().removeLivro(Integer.parseInt(txtLivro.getText()));
		
		if (status == 0) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar livro");
			return;
		}
		
		JOptionPane.showMessageDialog(null, "Livro deletado com sucesso!");
		
		table.setModel(new FrmLivroController().getAllLivro());
	}
}

package br.com.ufc.aps.biblioteca.visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.com.ufc.aps.biblioteca.DAO.AluguelDAO;
import br.com.ufc.aps.biblioteca.DAO.LivroDAO;
import br.com.ufc.aps.biblioteca.model.Aluguel;
import br.com.ufc.aps.biblioteca.model.Livro;
import br.com.ufc.aps.biblioteca.visual.controller.FrmAluguelController;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmAluguelDelete extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAluguelId;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblLivro;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAluguelDelete frame = new FrmAluguelDelete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmAluguelDelete() {

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtAluguelId = new JTextField();
		txtAluguelId.setBounds(10, 27, 175, 20);
		contentPane.add(txtAluguelId);
		txtAluguelId.setColumns(10);

		table = new JTable(new FrmAluguelController().getAllAluguel());

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
	
		lblLivro = new JLabel("Aluguel - Id");
		lblLivro.setBounds(10, 11, 80, 14);
		contentPane.add(lblLivro);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void deletar() {
		if(txtAluguelId.getText().equals(""))
			return;
		
		Aluguel aluguel = new AluguelDAO().getAluguel(Integer.parseInt(txtAluguelId.getText()));
		int status = new FrmAluguelController().removeAluguel(Integer.parseInt(txtAluguelId.getText()));
		
		if (status == 0) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar aluguel");
			return;
		}
		
		JOptionPane.showMessageDialog(null, "Aluguel deletado com sucesso!");
		Livro livro = aluguel.getLivro();
		livro.setQuantidade(livro.getQuantidade() +1);
		new LivroDAO().updateLivro(livro);
		
		table.setModel(new FrmAluguelController().getAllAluguel());
	}
}

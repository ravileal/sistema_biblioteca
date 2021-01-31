package br.com.ufc.aps.biblioteca.visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.com.ufc.aps.biblioteca.DAO.LivroDAO;
import br.com.ufc.aps.biblioteca.model.Livro;
import br.com.ufc.aps.biblioteca.visual.controller.FrmAluguelController;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmAluguelRegister extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdLi;
	private JTextField txtMat;
	private JScrollPane scrollPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAluguelRegister frame = new FrmAluguelRegister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmAluguelRegister() {

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtIdLi = new JTextField();
		txtIdLi.setBounds(10, 39, 127, 20);
		txtIdLi.setColumns(10);
		contentPane.add(txtIdLi);

		txtMat = new JTextField();
		txtMat.setBounds(268, 39, 127, 20);
		txtMat.setColumns(10);
		contentPane.add(txtMat);

		JLabel lblGenero = new JLabel("ID - Livro");
		lblGenero.setBounds(10, 22, 46, 14);
		contentPane.add(lblGenero);

		JLabel lblQuantidade = new JLabel("Matricula");
		lblQuantidade.setBounds(268, 22, 78, 14);
		contentPane.add(lblQuantidade);

		table = new JTable(new FrmAluguelController().getAllAluguel());

		JButton btnOk = new JButton("Cadastrar");
		btnOk.setBounds(149, 105, 89, 23);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});

		contentPane.add(btnOk);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 151, 618, 164);
		contentPane.add(scrollPane);

		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.setModel(new FrmAluguelController().getAllAluguel());
			}
		});

		scrollPane.setViewportView(table);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void cadastrar() {
		if (txtMat.getText().equals("") || txtIdLi.getText().equals(""))
			return;

		FrmAluguelController aluguel = new FrmAluguelController();

		int res = aluguel.setAluguel(Integer.parseInt(txtMat.getText()), Integer.parseInt(txtIdLi.getText()));

		switch (res) {
		case -1:
			JOptionPane.showMessageDialog(null, "Aluno nao encontrado");
			break;
		case -2:
			JOptionPane.showMessageDialog(null, "Livro nao encontrado");
			break;
		case -3:
			JOptionPane.showMessageDialog(null, "Quantidade de livro esgotada");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Aluguel cadastrado com sucesso");
			
			Livro livro = new LivroDAO().getLivro(Integer.parseInt(txtIdLi.getText()));
			livro.setQuantidade(livro.getQuantidade() - 1);
			new LivroDAO().updateLivro(livro);

			cleanFields();
			table.setModel(new FrmAluguelController().getAllAluguel());
		}
	}

	public void cleanFields() {
		txtMat.setText("");
		txtIdLi.setText("");
	}
}

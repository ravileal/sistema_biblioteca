package br.com.ufc.aps.biblioteca.visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.com.ufc.aps.biblioteca.DAO.LivroDAO;
import br.com.ufc.aps.biblioteca.model.Livro;
import br.com.ufc.aps.biblioteca.visual.controller.FrmLivroController;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmLivroRegister extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtGen;
	private JTextField txtDesc;
	private JTextField txtQtd;
	private JScrollPane scrollPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLivroRegister frame = new FrmLivroRegister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmLivroRegister() {

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtNome = new JTextField();
		txtNome.setBounds(10, 39, 127, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtGen = new JTextField();
		txtGen.setBounds(10, 90, 127, 20);
		txtGen.setColumns(10);
		contentPane.add(txtGen);

		txtDesc = new JTextField();
		txtDesc.setBounds(280, 39, 127, 20);
		txtDesc.setColumns(10);
		contentPane.add(txtDesc);

		txtQtd = new JTextField();
		txtQtd.setBounds(280, 90, 127, 20);
		txtQtd.setColumns(10);
		contentPane.add(txtQtd);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 22, 46, 14);
		contentPane.add(lblNome);

		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(10, 70, 46, 14);
		contentPane.add(lblGenero);

		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(280, 22, 78, 14);
		contentPane.add(lblDescrio);

		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(280, 70, 78, 14);
		contentPane.add(lblQuantidade);

		table = new JTable(new FrmLivroController().getAllLivro());

		JButton btnOk = new JButton("Buscar");
		btnOk.setBounds(155, 135, 89, 23);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});
		contentPane.add(btnOk);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 184, 447, 164);
		contentPane.add(scrollPane);

		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.setModel(new FrmLivroController().getAllLivro());
			}
		});

		scrollPane.setViewportView(table);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void cadastrar() {
		Livro livro = new Livro();

		livro.setNome(txtNome.getText());
		livro.setGenero(txtGen.getText());
		livro.setDescricao(txtDesc.getText());
		livro.setQuantidade(Integer.parseInt(txtQtd.getText()));

		int status = new LivroDAO().setLivro(livro);

		if(status == 0) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar livro");
			return;
		}
		
		JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso");	
		
		table.setModel(new FrmLivroController().getAllLivro());
	}
}

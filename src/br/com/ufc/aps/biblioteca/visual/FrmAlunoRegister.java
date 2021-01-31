package br.com.ufc.aps.biblioteca.visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.com.ufc.aps.biblioteca.DAO.AlunoDAO;
import br.com.ufc.aps.biblioteca.model.Aluno;
import br.com.ufc.aps.biblioteca.visual.controller.FrmAlunoController;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmAlunoRegister extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtIda;
	private JTextField txtEnd;
	private JTextField txtMat;
	private JTextField txtTel;
	private JTextField txtEm;
	private JTextField txtSen;
	private JLabel lblSenha;
	private JScrollPane scrollPane;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAlunoRegister frame = new FrmAlunoRegister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmAlunoRegister() {

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

		txtIda = new JTextField();
		txtIda.setBounds(10, 90, 127, 20);
		txtIda.setColumns(10);
		contentPane.add(txtIda);

		txtEnd = new JTextField();
		txtEnd.setBounds(280, 39, 127, 20);
		txtEnd.setColumns(10);
		contentPane.add(txtEnd);

		txtMat = new JTextField();
		txtMat.setBounds(280, 90, 127, 20);
		txtMat.setColumns(10);
		contentPane.add(txtMat);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 22, 46, 14);
		contentPane.add(lblNome);

		JLabel lblGenero = new JLabel("Idade");
		lblGenero.setBounds(10, 70, 46, 14);
		contentPane.add(lblGenero);

		JLabel lblDescrio = new JLabel("Endere\u00E7o");
		lblDescrio.setBounds(280, 22, 78, 14);
		contentPane.add(lblDescrio);

		JLabel lblQuantidade = new JLabel("Matricula");
		lblQuantidade.setBounds(280, 70, 78, 14);
		contentPane.add(lblQuantidade);

		table = new JTable(new FrmAlunoController().getAllAluno());

		JButton btnOk = new JButton("Cadastrar");
		btnOk.setBounds(160, 222, 89, 23);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();
			}
		});
		
		contentPane.add(btnOk);

		txtTel = new JTextField();
		txtTel.setBounds(280, 144, 127, 20);
		txtTel.setColumns(10);
		contentPane.add(txtTel);

		txtEm = new JTextField();
		txtEm.setBounds(10, 144, 127, 20);
		txtEm.setColumns(10);
		contentPane.add(txtEm);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 121, 46, 14);
		contentPane.add(lblEmail);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(280, 121, 46, 14);
		contentPane.add(lblTelefone);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 256, 447, 164);
		contentPane.add(scrollPane);

		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.setModel(new FrmAlunoController().getAllAluno());
			}
		});

		scrollPane.setViewportView(table);

		txtSen = new JTextField();
		txtSen.setColumns(10);
		txtSen.setBounds(10, 193, 127, 20);
		contentPane.add(txtSen);

		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 175, 46, 14);
		contentPane.add(lblSenha);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	
	public void cadastrar() {
		if (txtMat.getText().equals("") || txtIda.getText().equals(""))
			return;
		
		Aluno aluno = new Aluno();

		aluno.setMatricula(Integer.parseInt(txtMat.getText()));
		aluno.setNome(txtNome.getText());
		aluno.setIdade(Integer.parseInt(txtIda.getText()));
		aluno.setEndereco(txtEnd.getText());
		aluno.setEmail(txtEm.getText());
		aluno.setSenha(txtSen.getText());
		aluno.setTelefone(txtTel.getText());

		if(new AlunoDAO().setAluno(aluno) == 0) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar aluno");
			return;
		}
		
		JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso");
	
		cleanFields();
		table.setModel(new FrmAlunoController().getAllAluno());
	}
	
	public void cleanFields() {
		txtMat.setText("");
		txtNome.setText("");
		txtIda.setText("");
		txtEnd.setText("");
		txtEm.setText("");
		txtSen.setText("");
		txtTel.setText("");
	}
}

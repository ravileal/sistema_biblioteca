package br.com.ufc.aps.biblioteca.visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

public class FrmMenuBibliotecario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMenuBibliotecario frame = new FrmMenuBibliotecario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmMenuBibliotecario() {
		//this.setExtendedState(MAXIMIZED_BOTH); //Maximizar a tela
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrarAluno = new JButton("Cadastrar Aluno");
		btnCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmAlunoRegister jt = new FrmAlunoRegister();
				jt.setVisible(true);
				
			}
		});
		btnCadastrarAluno.setBounds(168, 11, 148, 70);
		contentPane.add(btnCadastrarAluno);
		
		JButton btnCadastrarLivro = new JButton("Cadastrar Livro");
		btnCadastrarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmLivroRegister jt = new FrmLivroRegister();
				jt.setVisible(true);
				
			}
		});
		btnCadastrarLivro.setBounds(168, 92, 148, 70);
		contentPane.add(btnCadastrarLivro);
		
		JButton btnBuscarAluno = new JButton("Buscar Aluno");
		btnBuscarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmAlunoFind jt = new FrmAlunoFind();
				jt.setVisible(true);
				
			}
		});
		btnBuscarAluno.setBounds(10, 11, 148, 70);
		contentPane.add(btnBuscarAluno);
		
		JButton btnBuscarLivro = new JButton("Buscar Livro");
		btnBuscarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmLivroFind jt = new FrmLivroFind();
				jt.setVisible(true);
				
			}
		});
		btnBuscarLivro.setBounds(10, 92, 148, 70);
		contentPane.add(btnBuscarLivro);
		
		JButton btnDeletarAluno = new JButton("Deletar Aluno");
		btnDeletarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrmAlunoDelete jt = new FrmAlunoDelete();
				jt.setVisible(true);
	
			}
		});
		btnDeletarAluno.setBounds(326, 11, 148, 70);
		contentPane.add(btnDeletarAluno);
		
		JButton btnDeletarLivro = new JButton("Deletar Livro");
		btnDeletarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrmLivroDelete jt = new FrmLivroDelete();
				jt.setVisible(true);
			}
		});
		btnDeletarLivro.setBounds(326, 92, 148, 70);
		contentPane.add(btnDeletarLivro);
		
		JButton btnAtualizarAluno = new JButton("Atualizar Aluno");
		btnAtualizarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrmAlunoUpdate jt = new FrmAlunoUpdate();
				jt.setVisible(true);
				
			}
		});
		btnAtualizarAluno.setBounds(484, 11, 148, 70);
		contentPane.add(btnAtualizarAluno);
		
		JButton btnAtualizarLivro = new JButton("Atualizar Livro");
		btnAtualizarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrmLivroUpdate jt = new FrmLivroUpdate();
				jt.setVisible(true);
				
				
			}
		});
		btnAtualizarLivro.setBounds(484, 92, 148, 70);
		contentPane.add(btnAtualizarLivro);
		
		JButton btnCadastrarAluguel = new JButton("Cadastrar aluguel");
		btnCadastrarAluguel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrmAluguelRegister alu = new FrmAluguelRegister();
				alu.setVisible(true);
			}
		});
		btnCadastrarAluguel.setBounds(224, 173, 194, 70);
		contentPane.add(btnCadastrarAluguel);
		
		JButton btnDeletarAluguel = new JButton("Deletar aluguel");
		btnDeletarAluguel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrmAluguelDelete del = new FrmAluguelDelete();
				del.setVisible(true);
			}
		});
		btnDeletarAluguel.setBounds(428, 173, 204, 70);
		contentPane.add(btnDeletarAluguel);
		
		JButton btnRealizarAluguel = new JButton("Buscar aluguel");
		btnRealizarAluguel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrmAluguelFind al = new FrmAluguelFind();
				al.setVisible(true);
			}
		});
		btnRealizarAluguel.setBounds(10, 173, 204, 70);
		contentPane.add(btnRealizarAluguel);
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}

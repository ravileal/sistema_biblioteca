package br.com.ufc.aps.biblioteca.visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.com.ufc.aps.biblioteca.visual.controller.FrmAlunoController;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmAlunoDelete extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JComboBox<Object> comboBox;
	private JTextField txtAluno;
	private JLabel lblAluno;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAlunoDelete frame = new FrmAlunoDelete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmAlunoDelete() {

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblAluno = new JLabel("Aluno");
		lblAluno.setBounds(10, 11, 46, 14);
		contentPane.add(lblAluno);

		txtAluno = new JTextField();
		txtAluno.setBounds(10, 27, 175, 20);
		contentPane.add(txtAluno);
		txtAluno.setColumns(10);

		comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] { "Id", "Matricula" }));
		comboBox.setBounds(324, 19, 133, 36);
		contentPane.add(comboBox);
		
		table = new JTable(new FrmAlunoController().getAllAluno());

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 447, 164);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
		JButton btnOk = new JButton("Deletar");
		btnOk.setBounds(96, 67, 89, 23);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletar();
			}
		});
		contentPane.add(btnOk);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void deletar() {
		if (txtAluno.getText().equals(""))
			return;

		int opc = comboBox.getSelectedIndex();
		int value = Integer.parseInt(txtAluno.getText());
			
		int qtdRemove = new FrmAlunoController().removeAluno(opc, value);
		
		if(qtdRemove == 0)
			JOptionPane.showMessageDialog(null, "Aluno nao encontrado");
		else
			JOptionPane.showMessageDialog(null, "Aluno deletado com sucesso!");
		
		table.setModel(new FrmAlunoController().getAllAluno());
	}
}

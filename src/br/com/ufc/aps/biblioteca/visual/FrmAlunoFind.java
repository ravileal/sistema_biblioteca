package br.com.ufc.aps.biblioteca.visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.ufc.aps.biblioteca.visual.controller.FrmAlunoController;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmAlunoFind extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAluno;
	private JScrollPane scrollPane;
	private JTable table;
	private JComboBox<Object> comboBox;
	private JLabel lblAluno;
	private JButton btnListar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAlunoFind frame = new FrmAlunoFind();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmAlunoFind() {

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable(new FrmAlunoController().getAllAluno());

		JButton btnOk = new JButton("Buscar");
		btnOk.setBounds(96, 67, 89, 23);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		contentPane.add(btnOk);

		comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] { "Id", "Matricula", "Nome" }));
		comboBox.setBounds(324, 19, 133, 36);
		contentPane.add(comboBox);

		txtAluno = new JTextField();
		txtAluno.setBounds(10, 27, 175, 20);
		contentPane.add(txtAluno);
		txtAluno.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 447, 164);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(table);

		lblAluno = new JLabel("Aluno");
		lblAluno.setBounds(10, 11, 46, 14);
		contentPane.add(lblAluno);

		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new FrmAlunoController().getAllAluno());
			}
		});
		btnListar.setBounds(265, 67, 89, 23);
		contentPane.add(btnListar);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void buscar() {
		if (txtAluno.getText().equals(""))
			return;

		int opc = comboBox.getSelectedIndex();

		DefaultTableModel model = new FrmAlunoController().getAlunoOpc(opc, txtAluno.getText());

		if (model == null) {
			JOptionPane.showMessageDialog(null, "Aluno nao encontrado");
			return;
		}

		table.setModel(model);
	}
	
}

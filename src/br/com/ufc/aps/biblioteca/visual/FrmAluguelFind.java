package br.com.ufc.aps.biblioteca.visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.ufc.aps.biblioteca.visual.controller.FrmAluguelController;

import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class FrmAluguelFind extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAluguel;
	private JScrollPane scrollPane;
	private JTable table;
	private JComboBox<Object> comboBox;
	private JButton btnListar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAluguelFind frame = new FrmAluguelFind();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmAluguelFind() {
		setTitle("Aluguel - Busca e Renovacao");

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();
		DefaultTableModel model = new FrmAluguelController().getAllAluguel();
		if (model != null)
			table.setModel(model);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 77, 743, 175);
		contentPane.add(scrollPane);

		txtAluguel = new JTextField();
		txtAluguel.setBounds(10, 11, 629, 21);
		txtAluguel.setColumns(10);
		contentPane.add(txtAluguel);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(10, 43, 306, 23);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		contentPane.add(btnBuscar);

		JButton btnRenovar = new JButton("Renovar");
		btnRenovar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				renovar();
			}
		});
		btnRenovar.setBounds(326, 43, 313, 23);
		contentPane.add(btnRenovar);

		scrollPane.setViewportView(table);

		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listar();
			}
		});
		btnListar.setBounds(648, 43, 104, 23);
		contentPane.add(btnListar);

		comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] { "Id Aluguel", "Matricula Aluno" }));
		comboBox.setBounds(649, 11, 104, 21);
		contentPane.add(comboBox);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void listar() {
		DefaultTableModel model = new FrmAluguelController().getAllAluguel();
		if(model == null) { 
			JOptionPane.showMessageDialog(null, "Nenhum aluguel realizado");
			return;
		}
		table.setModel(model);
	}

	public void buscar() {
		if (txtAluguel.getText().equals(""))
			return;

		int opc = comboBox.getSelectedIndex();

		DefaultTableModel model = new FrmAluguelController().getAluguelOpc(opc, txtAluguel.getText());

		if (model == null) {
			JOptionPane.showMessageDialog(null, "Aluguel nao encontrado");
			return;
		}

		table.setModel(model);
	}

	public void renovar() {
		if (txtAluguel.getText().equals(""))
			return;

		int status = new FrmAluguelController().renovar(Integer.parseInt(txtAluguel.getText()));

		switch (status) {
		case -2: 
			JOptionPane.showMessageDialog(null, "Aluguel nao encontrado");
			break;
		case -1:
			JOptionPane.showMessageDialog(null, "Limite de renovacoes atingido");
			break;
		case 0:
			JOptionPane.showMessageDialog(null, "Erro ao renovar");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Renovacao realizada");
			table.setModel(new FrmAluguelController().getAllAluguel());
		}
	}

}

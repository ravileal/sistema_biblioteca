package br.com.ufc.aps.biblioteca.visual.controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import br.com.ufc.aps.biblioteca.DAO.AluguelDAO;
import br.com.ufc.aps.biblioteca.model.Aluguel;

public class FrmAluguelController {

	public FrmAluguelController() {
	}

	private Object[] aluguelToObjectVector(Aluguel aluguel) {
		if (aluguel == null)
			return null;

		Object[] coluna = new Object[10];
		coluna[0] = aluguel.getIdAluguel();
		coluna[1] = aluguel.getLivro().getId();
		coluna[2] = aluguel.getAluno().getId();
		coluna[3] = aluguel.getAluno().getMatricula();
		coluna[4] = aluguel.getAluno().getNome();
		coluna[5] = aluguel.getLivro().getNome();
		coluna[6] = aluguel.getDataAluguel();
		coluna[7] = aluguel.getDataDevolucao();
		coluna[8] = (aluguel.getPendencia())? "sim": "nao";
		coluna[9] = aluguel.getRenovacoes();
		
		return coluna;

	}

	private DefaultTableModel getAluguel(Aluguel aluguel) {
		if (aluguel == null)
			return null;
		ArrayList<Aluguel> listAluguel = new ArrayList<Aluguel>();
		listAluguel.add(aluguel);
		return getAluguel(listAluguel);
	}
	
	private DefaultTableModel getAluguel(ArrayList<Aluguel> listAluguel) {
		if (listAluguel == null)
			return null;

		String[] nomeColunas = { 
				"IdAluguel", 
				"IdLivro", "IdAluno", "Matricula", "Aluno", "Livro", "Data Aluguel", "Data Devolucao", "Pendente", "Renovacoes"};

		DefaultTableModel modelo = new DefaultTableModel(null, nomeColunas);

		for (Aluguel aluguel : listAluguel)
			modelo.addRow(aluguelToObjectVector(aluguel));

		return modelo;
	}
	
	private DefaultTableModel getAluguel(int id) {
		return getAluguel(new AluguelDAO().getAluguel(id));
	}
	

	private DefaultTableModel getAllAluguelAlunoMatricula(int matricula) {
		return getAluguel(new AluguelDAO().getAluguelAluno(matricula));
	}

	// metodos publicos
	
	public int setAluguel(int matricula, int idLivro) {
		return new AluguelDAO().setAluguelMatricula(matricula, idLivro);
	}
	
	public DefaultTableModel getAllAluguel() {
		DefaultTableModel model = getAluguel(new AluguelDAO().getAllAluguel());
		return (model == null) ? null : model;
	}
	
	public DefaultTableModel getAluguelOpc(int opcao, String value) {
		switch (opcao) {
		case 0:
			return getAluguel(Integer.parseInt(value));
		case 1:
			return getAllAluguelAlunoMatricula(Integer.parseInt(value));	
		default:
			return null;
		}
	}

	public int removeAluguel(int id) {
		return new AluguelDAO().removeAluguel(id);
	}

	public int renovar(int id){
		return new AluguelDAO().renovar(id);
	}
	
}

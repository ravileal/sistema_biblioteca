package br.com.ufc.aps.biblioteca.visual.controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import br.com.ufc.aps.biblioteca.DAO.AlunoDAO;
import br.com.ufc.aps.biblioteca.model.Aluno;

public class FrmAlunoController {

	public FrmAlunoController() {
	}

	private Object[] alunoToObjectVector(Aluno aluno) {
		if (aluno == null)
			return null;

		Object[] coluna = new Object[7];
		coluna[0] = aluno.getId();
		coluna[1] = aluno.getMatricula();
		coluna[2] = aluno.getNome();
		coluna[3] = aluno.getIdade();
		coluna[4] = aluno.getTelefone();
		coluna[5] = aluno.getEmail();
		coluna[6] = aluno.getEndereco();

		return coluna;
	}

	private DefaultTableModel getAluno(Aluno aluno) {
		if (aluno == null)
			return null;
		ArrayList<Aluno> listAluno = new ArrayList<Aluno>();
		listAluno.add(aluno);
		return getAluno(listAluno);
	}

	private DefaultTableModel getAluno(ArrayList<Aluno> listAluno) {
		if (listAluno == null)
			return null;

		String[] nomeColunas = { "Id", "Matricula", "Nome", "Idade", "Telefone", "Email", "Endereco" };
		DefaultTableModel modelo = new DefaultTableModel(null, nomeColunas);

		for (Aluno aluno : listAluno)
			modelo.addRow(alunoToObjectVector(aluno));

		return modelo;
	}

	private DefaultTableModel getAlunoId(int id) {
		return getAluno(new AlunoDAO().getAlunoId(id));
	}

	private DefaultTableModel getAluno(int matricula) {
		return getAluno(new AlunoDAO().getAluno(matricula));
	}

	private DefaultTableModel getAluno(String nome) {
		return getAluno(new AlunoDAO().getAluno(nome));
	}

	//metodos publicos
	
	public DefaultTableModel getAlunoOpc(int opcao, Object value) {
		switch (opcao) {
		case 0:
			return getAlunoId(Integer.parseInt((String) value));
		case 1:
			return getAluno(Integer.parseInt((String) value));
		case 2:
			return getAluno((String) value);
		default:
			return null;
		}
	}

	public DefaultTableModel getAllAluno() {
		DefaultTableModel model = getAluno(new AlunoDAO().getAllAluno());
		return (model == null) ? new DefaultTableModel() : model;
	}
	
	public int updateAluno(Aluno aluno) {
		return new AlunoDAO().updateAluno(aluno);
	}
	
	public int removeAluno(int opcao, int value) {
		if (opcao == 0)
			return new AlunoDAO().removeAlunoId(value);
		else
			return new AlunoDAO().removeAluno(value);
	}
	
}

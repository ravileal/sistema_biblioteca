package br.com.ufc.aps.biblioteca.visual.controller;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import br.com.ufc.aps.biblioteca.DAO.LivroDAO;
import br.com.ufc.aps.biblioteca.model.Livro;

public class FrmLivroController {

	public FrmLivroController() {
	}

	private Object[] livroToObjectVector(Livro livro) {
		if (livro == null)
			return null;

		Object[] coluna = new Object[5];
		coluna[0] = livro.getId();
		coluna[1] = livro.getNome();
		coluna[2] = livro.getGenero();
		coluna[3] = livro.getDescricao();
		coluna[4] = livro.getQuantidade();

		return coluna;
	}

	private DefaultTableModel getLivro(Livro livro) {
		if (livro == null)
			return null;
		ArrayList<Livro> listLivro = new ArrayList<Livro>();
		listLivro.add(livro);
		return getLivro(listLivro);
	}
	
	private DefaultTableModel getLivro(ArrayList<Livro> listLivro) {
		if (listLivro == null)
			return null;

		String[] nomeColunas = { "Id", "Nome", "Genero", "Descricao", "Quantidade" };
		DefaultTableModel modelo = new DefaultTableModel(null, nomeColunas);

		for (Livro livro : listLivro)
			modelo.addRow(livroToObjectVector(livro));

		return modelo;
	}

	private DefaultTableModel getLivroId(int id) {
		return getLivro(new LivroDAO().getLivro(id));
	}

	private DefaultTableModel getLivro(String nome) {
		return getLivro(new LivroDAO().getLivro(nome));
	}
	
	// metodos publicos
	
	public DefaultTableModel getAllLivro() {
		DefaultTableModel model = getLivro(new LivroDAO().getAllLivro());
		return (model == null) ? new DefaultTableModel() : model;
	}
	
	public DefaultTableModel getLivroOpc(int opcao, String value) {
		switch (opcao) {
		case 0:
			return getLivroId(Integer.parseInt(value));
		case 1:
			return getLivro(value);
		default:
			return null;
		}
	}

	public int updateLivro(Livro livro) {
		return new LivroDAO().updateLivro(livro);
	}
	
	public int removeLivro(int value) {
		return new LivroDAO().removeLivro(value);
	}

}

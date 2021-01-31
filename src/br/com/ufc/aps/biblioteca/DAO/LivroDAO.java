package br.com.ufc.aps.biblioteca.DAO;

import java.util.ArrayList;

import br.com.ufc.aps.biblioteca.conexao.Row;
import br.com.ufc.aps.biblioteca.conexao.query.QueryDelete;
import br.com.ufc.aps.biblioteca.conexao.query.QuerySelect;
import br.com.ufc.aps.biblioteca.conexao.query.QueryUpdate;
import br.com.ufc.aps.biblioteca.model.Livro;

public class LivroDAO {

	public LivroDAO() {

	}

	private Livro rowToLivro(Row row) {
		Livro l = new Livro();

		l.setId(Integer.parseInt(row.getColuna(0)));
		l.setNome(row.getColuna(1));
		l.setGenero(row.getColuna(2));
		l.setDescricao(row.getColuna(3));
		l.setQuantidade(Integer.parseInt(row.getColuna(4)));

		return l;
	}

	private Row livroToRow(Livro livro) {
		Row row = new Row();

		row.addColuna(livro.getNome());
		row.addColuna(livro.getGenero());
		row.addColuna(livro.getDescricao());
		row.addColuna(livro.getQuantidade());

		return row;
	}

	private ArrayList<Livro> getLivroDefault(String sqlWhere) {
		QuerySelect query = new QuerySelect("SELECT * FROM livro "+ sqlWhere);
		ArrayList<Row> listRow = query.getRows();
		
		if (listRow == null)
			return null;

		ArrayList<Livro> listLivros = new ArrayList<Livro>();

		for (Row row : listRow)
			listLivros.add(rowToLivro(row));

		return listLivros;
	}
	
	public Livro getLivro(Livro livro) {
		ArrayList<Livro> listLivro = getLivroDefault("WHERE id =" + livro.getId()); 
		return (listLivro == null)? null: listLivro.get(0);
	}

	public Livro getLivro(int id) {
		ArrayList<Livro> listLivro = getLivroDefault("WHERE id =" + id); 
		return (listLivro == null)? null: listLivro.get(0);
	}

	public ArrayList<Livro> getLivro(String nome) {
		return getLivroDefault("WHERE nome LIKE '%" + nome + "%'");
	}

	public ArrayList<Livro> getAllLivro() {
		return getLivroDefault("");
	}

	public int setLivro(Livro livro) {
		String sql = "INSERT INTO livro(nome,genero,descricao,quantidade) VALUES (?,?,?,?) ";

		return new QueryUpdate().execute(sql, livroToRow(livro));
	}

	public int updateLivro(Livro livro) {
		String sql = "UPDATE Livro SET nome=?,genero=?,descricao=?,quantidade=? WHERE id='" + livro.getId() + "'";

		return new QueryUpdate().execute(sql, livroToRow(livro));
	}

	public int removeLivro(Livro livro) {
		return new QueryDelete().execute("DELETE FROM livro WHERE id=" + livro.getId());
	}

	public int removeLivro(int id) {
		return new QueryDelete().execute("DELETE FROM livro WHERE id=" + id);
	}

}

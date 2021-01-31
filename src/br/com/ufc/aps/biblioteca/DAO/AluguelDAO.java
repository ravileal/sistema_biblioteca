package br.com.ufc.aps.biblioteca.DAO;

import java.util.ArrayList;

import br.com.ufc.aps.biblioteca.conexao.Row;
import br.com.ufc.aps.biblioteca.conexao.query.QueryDelete;
import br.com.ufc.aps.biblioteca.conexao.query.QuerySelect;
import br.com.ufc.aps.biblioteca.conexao.query.QueryUpdate;
import br.com.ufc.aps.biblioteca.model.Aluguel;
import br.com.ufc.aps.biblioteca.model.Aluno;
import br.com.ufc.aps.biblioteca.model.Livro;

public class AluguelDAO {

	public AluguelDAO() {
	}

	private Row aluguelToRow(Aluguel aluguel, int numRows) {
		Row row = new Row();

		row.addColuna(aluguel.getIdAluno());
		if(numRows == 1 ) return row;
		row.addColuna(aluguel.getIdLivro());
		if(numRows == 2 ) return row;
		row.addColuna(String.valueOf(aluguel.getPendencia()));
		if(numRows == 3 ) return row;
		row.addColuna(aluguel.getRenovacoes());
		if(numRows == 4 ) return row;
		
		return row;
	}

	public Aluguel getAluguel(int id) {
		ArrayList<Aluguel> listAluguel = getAluguelDefault("WHERE id =" + id);
		return (listAluguel == null) ? null : listAluguel.get(0);
	}

	public Aluguel getAluguel(Aluguel aluguel) {
		ArrayList<Aluguel> listAluguel = getAluguelDefault("WHERE id =" + aluguel.getIdAluguel());
		return (listAluguel == null) ? null : listAluguel.get(0);
	}

	private ArrayList<Aluguel> getAluguelDefault(String sqlWhere) {
		QuerySelect qSelect = new QuerySelect("SELECT * FROM aluguel " + sqlWhere);
		ArrayList<Row> listRow = qSelect.getRows();

		if (listRow == null)
			return null;

		ArrayList<Aluguel> listAluguel = new ArrayList<Aluguel>();

		for (Row row : listRow) {
			Aluguel l = new Aluguel();

			l.setIdAluguel(Integer.parseInt(row.getColuna(0)));
			l.setIdAluno(Integer.parseInt(row.getColuna(1)));
			l.setIdLivro(Integer.parseInt(row.getColuna(2)));
			l.setDataAluguel(row.getColuna(3));
			l.setDataDevolucao(row.getColuna(4));
			l.setPendencia(Boolean.parseBoolean(row.getColuna(5)));
			l.setRenovacoes(Integer.parseInt(row.getColuna(6)));

			listAluguel.add(l);
		}
			
		return listAluguel;
	}

	public ArrayList<Aluguel> getAllAluguel() {
		return getAluguelDefault("");
	}

	public ArrayList<Aluguel> getAluguelAluno(Aluno aluno) {
		if (aluno == null)
			return null;
		return getAluguelDefault("WHERE idaluno =" + aluno.getId());
	}

	public ArrayList<Aluguel> getAluguelAlunoId(int id) {
		Aluno aluno = new AlunoDAO().getAlunoId(id);
		return getAluguelAluno(aluno);
	}

	public ArrayList<Aluguel> getAluguelAluno(int matricula) {
		Aluno aluno = new AlunoDAO().getAluno(matricula);
		return getAluguelAluno(aluno);
	}

	public int setAluguelDefalt(Aluguel aluguel) {
		if (aluguel == null)
			return 0;
		
		//aluguel.setDataAluguel("");
		
		String sql = "INSERT INTO aluguel(idAluno,idLivro) VALUES (?,?) ";
		return new QueryUpdate().execute(sql, aluguelToRow(aluguel,2));
	}

	public int setAluguel(Aluno aluno, Livro livro) {
		if (aluno == null)
			return -1;
		else if (livro == null)
			return -2;
		else if (livro.getQuantidade() < 1)
			return -3;
		else
			return setAluguelDefalt(new Aluguel(aluno, livro));
	}

	public int setAluguel(int idAluno, int idLivro) {
		Aluno aluno = new AlunoDAO().getAlunoId(idAluno);
		Livro livro = new LivroDAO().getLivro(idLivro);
		return setAluguel(aluno, livro);
	}

	public int setAluguelMatricula(int matricula, int idLivro) {
		Aluno aluno = new AlunoDAO().getAluno(matricula);
		Livro livro = new LivroDAO().getLivro(idLivro);
		return setAluguel(aluno, livro);
	}
	
	private int updateAluguelRenova(String sqlWhere, Aluguel aluguel) {
		String sql = "UPDATE aluguel SET idaluno=?, idlivro=?, datadev=CURRENT_DATE + integer '30', pendencia=?, renovacoes=renovacoes+1"
				+ sqlWhere;
		return new QueryUpdate().execute(sql, aluguelToRow(aluguel,3));
	}
	/*
	private int updateAluguelDefault(String sqlWhere, Aluguel aluguel) {
		String sql = "UPDATE aluguel SET idaluno=?, idlivro=?, datadev=?, pendencia=?, renovacoes=?"
				+ sqlWhere;
		return new QueryUpdate().execute(sql, aluguelToRow(aluguel));
	}
	
	public int updateAluguel(Aluguel aluguel) {
		return updateAluguelDefault("WHERE id='" + aluguel.getIdAluguel() + "'", aluguel);
	}
	*/
	public int removeAluguel(int id) {
		return new QueryDelete().execute("DELETE FROM aluguel WHERE id =" + id);
	}

	public int removeAluguel(Aluguel l) {
		return removeAluguel(l.getIdAluguel());
	}

	public int renovar(int id) {
		Aluguel aluguel = getAluguel(id);
		
		if(aluguel == null)
			return -2;
		else if(aluguel.getRenovacoes() > 1)
			return -1;
		
		aluguel.setRenovacoes(aluguel.getRenovacoes()+1);
	
		return updateAluguelRenova("WHERE id='" + aluguel.getIdAluguel() + "'", aluguel);
	}

}

package br.com.ufc.aps.biblioteca.DAO;

import java.util.ArrayList;

import br.com.ufc.aps.biblioteca.conexao.Row;
import br.com.ufc.aps.biblioteca.conexao.query.QueryDelete;
import br.com.ufc.aps.biblioteca.conexao.query.QuerySelect;
import br.com.ufc.aps.biblioteca.conexao.query.QueryUpdate;
import br.com.ufc.aps.biblioteca.model.Aluno;

public class AlunoDAO {

	QuerySelect qSelect = null;

	public AlunoDAO() {
	}

	private Aluno rowToAluno(Row row) {
		Aluno a = new Aluno();

		a.setId(Integer.parseInt(row.getColuna(0)));
		a.setNome(row.getColuna(1));
		a.setIdade(Integer.parseInt(row.getColuna(2)));
		a.setEmail(row.getColuna(3));
		a.setSenha(row.getColuna(4));
		a.setEndereco(row.getColuna(5));
		a.setTelefone(row.getColuna(6));
		a.setMatricula(Integer.parseInt(row.getColuna(7)));

		return a;
	}

	private Row alunoToRow(Aluno aluno) {
		Row row = new Row();

		row.addColuna(aluno.getNome());
		row.addColuna(Integer.toString(aluno.getIdade()));
		row.addColuna(aluno.getEmail());
		row.addColuna(aluno.getSenha());
		row.addColuna(aluno.getEndereco());
		row.addColuna(aluno.getTelefone());
		row.addColuna(Integer.toString(aluno.getMatricula()));

		return row;
	}

	private ArrayList<Aluno> getAlunoDefault(String sqlWhere) {
		qSelect = new QuerySelect("SELECT * FROM aluno "+sqlWhere);

		if (qSelect.getRows() == null)
			return null;

		ArrayList<Aluno> listAlunos = new ArrayList<Aluno>();

		for (Row row : qSelect.getRows())
			listAlunos.add(rowToAluno(row));

		return listAlunos;
	}
	
	public ArrayList<Aluno> getAllAluno() {
		return getAlunoDefault("");
	}
	
	public ArrayList<Aluno> getAluno(String nome) {
		return getAlunoDefault("WHERE nome LIKE '%" + nome + "%'");
	}
	
	public Aluno getAluno(int matricula) {
		ArrayList<Aluno> listAluno = getAlunoDefault("WHERE matricula ='" + matricula+"'"); 
		return (listAluno == null)? null: listAluno.get(0);
	}

	public Aluno getAlunoId(int id) {
		ArrayList<Aluno> listAluno = getAlunoDefault("WHERE id =" + id); 
		return (listAluno == null)? null: listAluno.get(0);
	}
	
	public Aluno getAluno(Aluno aluno) {
		if(aluno == null)
			return null;
		return getAlunoId(aluno.getId());
	}
	
	
	public int setAluno(Aluno aluno) {
		String sql = "INSERT INTO aluno(nome,idade,email,senha,endereco,telefone,matricula) VALUES (?,?,?,?,?,?,?) ";

		return new QueryUpdate().execute(sql, alunoToRow(aluno));
	}

	private int updateAlunoDefault(String sqlWhere, Aluno aluno) {
		String sql = "UPDATE aluno SET nome=?, idade=?, email=?, senha=?, endereco=?, telefone=?, matricula=?"
				+ sqlWhere;
		return new QueryUpdate().execute(sql, alunoToRow(aluno));
	}

	public int updateAluno(Aluno aluno) {
		return updateAlunoDefault("WHERE matricula='" + aluno.getMatricula() + "'", aluno);
	}

	public int updateAlunoId(Aluno aluno) {
		return updateAlunoDefault("WHERE id='" + aluno.getId() + "'", aluno);
	}

	public int removeAluno(Aluno aluno) {
		return new QueryDelete().execute("DELETE FROM aluno WHERE matricula ='" + aluno.getMatricula() + "'");
	}

	public int removeAlunoId(int id) {
		return new QueryDelete().execute("DELETE FROM aluno WHERE id ='" + id + "'");
	}

	public int removeAluno(Integer matricula) {
		return new QueryDelete().execute("DELETE FROM aluno WHERE matricula ='" + matricula + "'");
	}

}

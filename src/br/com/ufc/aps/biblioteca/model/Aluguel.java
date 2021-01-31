package br.com.ufc.aps.biblioteca.model;

import br.com.ufc.aps.biblioteca.DAO.AlunoDAO;
import br.com.ufc.aps.biblioteca.DAO.LivroDAO;

public class Aluguel {

	private int idAluguel = 0;
	private Aluno aluno = null;
	private Livro livro = null;
	private String dataAluguel = "";
	private String dataDevolucao = "";
	private boolean pendencia = false;
	private int renovacoes = 0;
	
	public Aluguel() {
	}

	public Aluguel(Aluno aluno, Livro livro) {
		super();
		this.aluno = aluno;
		this.livro = livro;
	}
	
	public Aluguel(int idAluno, int idLivro) {
		aluno = new AlunoDAO().getAlunoId(idAluno);
		livro = new LivroDAO().getLivro(idLivro);
	}
	
	public Aluguel(int id, int idAluno, int idLivro) {
		this.idAluguel = id;
		aluno = new AlunoDAO().getAlunoId(idAluno);
		livro = new LivroDAO().getLivro(idLivro);
	}	
	
	public Aluguel(int idAluguel, Aluno aluno, Livro livro) {
		super();
		this.idAluguel = idAluguel;
		this.aluno = aluno;
		this.livro = livro;
	}
	
	public Aluguel(int idAluguel, Aluno aluno, Livro livro, String dataAluguel, String dataDevolucao, boolean pendencia, int renovacoes) {
		super();
		this.idAluguel = idAluguel;
		this.aluno = aluno;
		this.livro = livro;
		this.dataAluguel = dataAluguel;
		this.dataDevolucao = dataDevolucao;
		this.pendencia = pendencia;
		this.renovacoes = renovacoes;
	}
	
	public int getIdAluguel() {
		return idAluguel;
	}

	public void setIdAluguel(int id) {
		this.idAluguel = id;
	}

	public int getIdLivro() {
		return livro.getId();
	}

	public void setIdLivro(int idLivro) {
		livro = new LivroDAO().getLivro(idLivro);
	}

	public int getIdAluno() {
		return aluno.getId();
	}

	public void setIdAluno(int idAluno) {
		aluno = new AlunoDAO().getAlunoId(idAluno);
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public boolean alunoIsNull() {
		return (aluno == null)? true: false;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public boolean livroIsNull() {
		return (livro == null)? true: false;
	}

	public String getDataAluguel() {
		return dataAluguel;
	}

	public void setDataAluguel(String dataAluguel) {
		this.dataAluguel = dataAluguel;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public boolean isPendencia() {
		return pendencia;
	}

	public boolean getPendencia() {
		return pendencia;
	}
	
	public void setPendencia(boolean pendencia) {
		this.pendencia = pendencia;
	}

	public int getRenovacoes() {
		return renovacoes;
	}

	public void setRenovacoes(int renovacoes) {
		this.renovacoes = renovacoes;
	}

	@Override
	public String toString() {
		return "\nAluguel \nidAluguel=" + idAluguel + "\n" + aluno + "\n" + livro + "\nData aluguel=" + dataAluguel + "\nData Recebimento=" + dataDevolucao + "\nPendencias=" + pendencia + "\nRenovacoes="+ renovacoes;
	}
	
}

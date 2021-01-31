package br.com.ufc.aps.biblioteca.model;

public class Livro {
	
	private int id;
	private String nome;
	private String genero;
	private String descricao;
	private Integer quantidade;

	public Livro() {
		
	}

	public Livro(int id, String nome, String genero, String descricao, int quantidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.genero = genero;
		this.descricao = descricao;
		this.quantidade = quantidade;
	}

	public Livro(String nome, String genero, String descricao, int quantidade) {
		super();
		this.nome = nome;
		this.genero = genero;
		this.descricao = descricao;
		this.quantidade = quantidade;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "\nLivro \nid: " + id + "\nnome=" + nome + "\ngenero=" + genero + "\ndescricao=" + descricao
				+ "\nquantidade=" + quantidade;
	}
	
	
}

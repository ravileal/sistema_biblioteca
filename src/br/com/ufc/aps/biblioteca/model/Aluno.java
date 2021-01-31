package br.com.ufc.aps.biblioteca.model;

public class Aluno{
	private Integer Matricula;
	private int id;
	private String nome;
	private int idade;
	private String email;
	private String senha;
	private String endereco;
	private String telefone;
	
	public Aluno() {
		
	}

	public Aluno(String nome, int idade, String email, String senha, String endereco,
			String telefone,Integer matricula) {
		super();
		Matricula = matricula;
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Aluno(Integer matricula, int id, String nome, int idade, String email, String senha, String endereco,
			String telefone) {
		super();
		Matricula = matricula;
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Integer getMatricula() {
		return Matricula;
	}

	public void setMatricula(Integer matricula) {
		Matricula = matricula;
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

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "\nAluno \nMatricula=" + Matricula + "\nid=" + id + "\nnome=" + nome + "\nidade=" + idade + "\nemail="
				+ email + "\nsenha=" + senha + "\nendereco=" + endereco + "\ntelefone=" + telefone;
	}
	
}

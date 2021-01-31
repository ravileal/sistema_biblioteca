package br.com.ufc.aps.biblioteca.model;

public class Bibliotecario {
	
	private int matricula = 12345;
	private String senha = "admin";
	
	private static Bibliotecario instance;
	
	
	private Bibliotecario() {
		super();
	}
	
	public static Bibliotecario getInstance() {
		if(instance == null) 
			synchronized (Bibliotecario.class) {
				if(instance == null)
					instance = new Bibliotecario();
			}
		
		return instance;
	}
	
	public int getMatricula() {
		return matricula;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}	
	
}

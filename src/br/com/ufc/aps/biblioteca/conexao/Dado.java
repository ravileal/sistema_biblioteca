package br.com.ufc.aps.biblioteca.conexao;

public class Dado {

	int inteiro = 0;
	String string = null;
	
	public Dado() {
	}

	public Dado(String string) {
		this.string = string;
	}
	
	public Dado(int inteiro) {
		this.inteiro = inteiro;
	}
	
	public int getInteiro() {
		return inteiro;
	}

	public void setInteiro(int inteiro) {
		this.inteiro = inteiro;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

}

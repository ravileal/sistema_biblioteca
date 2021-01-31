package br.com.ufc.aps.biblioteca.conexao;
import java.util.ArrayList;

public class Row {
	private ArrayList<Dado> colunas = null;

	public Row() {
		colunas = new ArrayList<Dado>();
	}
	
	public Row(ArrayList<String> colunas) {
		for (String string : colunas) {
			this.colunas.add(new Dado(string));
		}
	}
	
	public void addRow(ArrayList<String> linha) {
		for (String string : linha) {
			this.colunas.add(new Dado(string));
		}
	}
	
	public void addRowInt(ArrayList<Integer> linha) {
		for (int inteiro : linha) {
			this.colunas.add(new Dado(inteiro));
		}
	}
	
	public void addColuna(String linha) {
		colunas.add(new Dado(linha));
	}

	public void addColuna(int linha) {
		colunas.add(new Dado(linha));
	}
	
	public String toString() {
		String res = "";
		
		for (Dado dado : colunas) {
			if(dado.getString() != null)
				res += dado.getString() + " ";
			else 
				res += dado.getInteiro() + " ";
		}
		return res + '\n';
	}
	
	public int numColumn(){
		return colunas.size();
	}
	
	public String getColuna(int id) {
		return colunas.get(id).getString();
	}
	
	public int getColunaInt(int id) {
		return colunas.get(id).getInteiro();
	}
	
	public void rowClean() {
		colunas = new ArrayList<Dado>();
	}
}

package br.com.ufc.aps.biblioteca.conexao.controller;

import java.util.ArrayList;

import br.com.ufc.aps.biblioteca.conexao.Row;

public class ControllerRow {

	private Row row = null;
		
	public ControllerRow() {
		
	}
	
	public ControllerRow(Row row) {
		this.row = row; 
	}
	
	public void setRow(Row row) {
		this.row = row;
	}
	
	public Row getRow() {
		return row;
	}
	
	public void setRowValues(){				
		ControllerConexao ctrlcConexao = ControllerConexao.getInstance();
		for(int i=0; i < row.numColumn(); i++ ) 
			if(row.getColuna(i) != null)
				ctrlcConexao.setValueColumnString(i+1, row.getColuna(i));
			else 
				ctrlcConexao.setValueColumnInt(i+1, row.getColunaInt(i));
	}
	
	public void getRowValues(ArrayList<String> nomeColunas){	
		ControllerConexao ctrlcConexao = ControllerConexao.getInstance();
		row = new Row();
		
		if(nomeColunas == null)
			nomeColunas = getNameAllColumn();

		for (String nomeColuna : nomeColunas) {
			String valorColuna = ctrlcConexao.getValueColumnString(nomeColuna);
			row.addColuna(valorColuna);
		}
	}

	private ArrayList<String> getNameAllColumn(){
		ControllerConexao ctrlcConexao = ControllerConexao.getInstance();
		ArrayList<String> listString = new ArrayList<>();
		//primeira columa do BD comeca no indice 1
		for(int i=1; i <= ctrlcConexao.getNumColumn(); i++ ) {
			String nomeColuna = ctrlcConexao.getNameColumnName(i);
			listString.add(nomeColuna);			
		}
		return listString;
	}
	
	public boolean nullRow() {
		return (row.equals(null))? true : false;
	}
}

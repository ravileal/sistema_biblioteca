package br.com.ufc.aps.biblioteca.conexao.controller;

import java.util.ArrayList;

import br.com.ufc.aps.biblioteca.conexao.Row;
import br.com.ufc.aps.biblioteca.conexao.Table;

public class ControllerTable {
	
	private Table table = null;
	
	public ControllerTable() {
	}
	
	public void getTableValues(ArrayList<String> colunas){
		ControllerRow ctrlRow = new ControllerRow();
		table = new Table();
		
		do {
			ctrlRow.getRowValues(colunas);
			table.addRow(ctrlRow.getRow());
		}while(nextRow());
	}	
	
	private boolean nextRow() {
		return ControllerConexao.getInstance().nextResult();
	}
	
	public ArrayList<Row> getRows() {
		return table.getRepositorioRow();
	}
	
	public void setTableValues(Row row){
		new ControllerRow(row).setRowValues();
	}
	
	public void viewerTable() {
		System.out.println(table);
	}
	
	public Row getFistRow() {
		return table.getFirstRow();
	}
	
	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}
	
	public boolean nullTable() {
		return (table.equals(null))? true : false;
	}
}

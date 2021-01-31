package br.com.ufc.aps.biblioteca.conexao.query;

import java.util.ArrayList;

import br.com.ufc.aps.biblioteca.conexao.Row;
import br.com.ufc.aps.biblioteca.conexao.Table;
import br.com.ufc.aps.biblioteca.conexao.controller.ControllerTable;

public class QuerySelect extends Query{
	
	private ControllerTable ctrlTable = null;
	
	public QuerySelect() {
		super();
	}

	public QuerySelect(String query) {
		super(query);
		this.execute();
	}

	public void execute() {
		super.executeSimple();
		super.getCtrlConexao().executeStatementQuery();
		result();
	}
	
	public void execute(String query) {
		super.executeSimple(query);
		super.getCtrlConexao().executeStatementQuery(); 
		result();
	}

	public void result() {
		result(null);		
	}
	
	public void result(String colunas) {
		if(!super.getCtrlConexao().nextResult())
			return;
		
		ctrlTable = new ControllerTable();
		ctrlTable.getTableValues(columnFilter(colunas));
	}
	
	public void viwer() {
		result();
		ctrlTable.viewerTable();
	}
	
	public void viwer(String colunas) {
		result(colunas);
		ctrlTable.viewerTable();
	}
	
	public void executeAndViwer() {
		execute();
		result();
	}
	
	public void executeAndViwer(String query) {
		execute(query);
		viwer();
	}
	
	public ArrayList<String> columnFilter(String coluna) {
		if(coluna == null)
			return null;
		
		coluna = coluna.replaceAll(" ", "");
		String colunas[] = coluna.split(",");
		
		ArrayList<String> listColunas = new ArrayList<String>();
		
		for(int i=0; i<colunas.length; i++)
			listColunas.add(colunas[i]);
		
		return listColunas;
	}
	
	public void setQueryAndExecute(String query) {
		super.setQuery(query);
		this.execute();
	}
	
	@Override
	public String toString() {
		return (ctrlTable == null)? null : ctrlTable.toString();
	}

	public ControllerTable getCtrlTable() {
		return (ctrlTable == null)? null : ctrlTable;
	}
	
	public Table getTable() {
		return (ctrlTable == null)? null : ctrlTable.getTable();
	}
	
	public Row getFirstRow() {
		return (ctrlTable == null)? null : ctrlTable.getFistRow();
	}
	
	public ArrayList<Row> getRows(){
		return (ctrlTable == null)? null : ctrlTable.getRows();
	}
	
}

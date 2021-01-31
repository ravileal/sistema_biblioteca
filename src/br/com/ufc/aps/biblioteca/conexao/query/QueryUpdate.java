package br.com.ufc.aps.biblioteca.conexao.query;

import br.com.ufc.aps.biblioteca.conexao.Row;
import br.com.ufc.aps.biblioteca.conexao.controller.ControllerTable;

public class QueryUpdate extends Query{
	
	private Row row = null;
	
	public QueryUpdate() {
		super();
	}
	
	public QueryUpdate(Row row) {
		super();
		this.row = row;
	}
	
	public QueryUpdate(String query) {
		super(query);
	}

	public QueryUpdate(String query, Row row) {
		super(query);
		this.row = row;
		this.execute();
	}
	
	public int executeOnly() {
		super.executeSimple();
		return super.getCtrlConexao().executeStatementUpdate(); 
	}
	
	public int executeOnly(String sql) {
		super.executeSimple(sql);
		return super.getCtrlConexao().executeStatementUpdate(); 
	}
	
	public int execute() {
		super.executeSimple();
		new ControllerTable().setTableValues(row);
		return super.getCtrlConexao().executeStatementUpdate(); 
	}
	
	public int execute(String query) {
		super.executeSimple(query);
		new ControllerTable().setTableValues(row);
		return super.getCtrlConexao().executeStatementUpdate();
	}
	
	public int execute(String query, Row row) {
		super.executeSimple(query);
		new ControllerTable().setTableValues(row);
		return super.getCtrlConexao().executeStatementUpdate();
	}
	
	public Row getRow() {
		return row;
	}

	public void setRow(Row row) {
		this.row = row;
	}

}

package br.com.ufc.aps.biblioteca.conexao.query;

import br.com.ufc.aps.biblioteca.conexao.Row;

public class QueryCreate extends Query{
	
	private Row row = null;
	
	public QueryCreate() {
		super();
	}

	public QueryCreate(Row row) {
		super();
		this.row = row;
	}
	
	public QueryCreate(String query) {
		super(query);
	}

	public void execute() {
		super.executeSimple();
		super.getCtrlConexao().executeStatementUpdate(); 
	}
	
	public void execute(String query) {
		super.executeSimple(query);
		super.getCtrlConexao().executeStatementUpdate();
	}
	
	public Row getRow() {
		return row;
	}

	public void setRow(Row row) {
		this.row = row;
	}

}

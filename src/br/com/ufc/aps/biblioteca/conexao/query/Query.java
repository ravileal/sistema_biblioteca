package br.com.ufc.aps.biblioteca.conexao.query;

import br.com.ufc.aps.biblioteca.conexao.controller.ControllerConexao;

public abstract class Query {
	
	private ControllerConexao ctrlConexao = null;
	private String query = null;
	
	public Query() {
	}
	
	public Query(String query) {
		this.query = query;
	}

	public void executeSimple() {
		ctrlConexao = ControllerConexao.getInstance();
		ctrlConexao.setStatement(query);
	}
	
	public void executeSimple(String query) {
		ctrlConexao = ControllerConexao.getInstance();
		ctrlConexao.setStatement(query);
	}
	
	public ControllerConexao getCtrlConexao() {
		return ctrlConexao;
	}

	public void setCtrlConexao(ControllerConexao ctrlConexao) {
		this.ctrlConexao = ctrlConexao;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
}

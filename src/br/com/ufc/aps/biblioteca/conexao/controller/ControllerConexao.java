package br.com.ufc.aps.biblioteca.conexao.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.ufc.aps.biblioteca.conexao.Conexao;

public class ControllerConexao {
	
	private static ControllerConexao instance;
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet res = null;
	
	private ControllerConexao() {
	}
	
	public static ControllerConexao getInstance() {
		if(instance == null) 
			synchronized (ControllerConexao.class) {
				if(instance == null)
					instance = new ControllerConexao();
			}
		
		return instance;
	}
	
	private void closeConnection(){
		new Conexao().stop(conn);
	}
	
	// funcoes PrepareStatement
	
	public void setPrepareStatement(PreparedStatement pstmt) {
		this.pstmt = pstmt;
	}
	
	public PreparedStatement getPrepareStatement() {
		return pstmt;
	}
	
	// funcoes Statement
	
	public void setStatement(String query) {
		try {
			conn = new Conexao().start();
			pstmt = conn.prepareStatement(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeStatement() {
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	public void executeStatement() {
		try {
			pstmt.executeUpdate();
			closeStatement();
		} catch (SQLException e) {	
			e.printStackTrace();
		}
	}
	*/
	
	public int executeStatementUpdate() {
		try {
			int r = pstmt.executeUpdate();
			closeStatement();
			return r;
		} catch (SQLException e) {	
			e.printStackTrace();
			return 0;
		}
	}
	
	public void executeStatementQuery() {
		try {
			res = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	// funcoes ResultSet
	
	public void closeResultSet() {
		try {
			res.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ResultSet getResultSet() {
		return res;
	}

	// funcoes de manipulacao de colunas bd
	
	public String getNameColumnName(int index) {
		try { //pega a metaData em res, depois pega o nome da coluna de acordo com indice
			return res.getMetaData().getColumnName(index);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String getValueColumnString(String coluna) {
		try {
			return res.getString(coluna);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void setValueColumnString(int indexColumn, String valueColumn) {
		try {
			pstmt.setString(indexColumn, valueColumn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void setValueColumnInt(int indexColumn, int valueColumn) {
		try {
			pstmt.setInt(indexColumn, valueColumn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int getNumColumn() {
		try {
			return res.getMetaData().getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	//verificacao de proximo resultado 
	
	public boolean nextResult() {
		try {
			if(res.next()) 
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		closeResultSet();
		closeStatement();
		closeConnection();
		return false;
	} 
	
}

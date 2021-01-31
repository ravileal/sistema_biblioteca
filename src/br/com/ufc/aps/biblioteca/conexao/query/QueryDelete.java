package br.com.ufc.aps.biblioteca.conexao.query;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class QueryDelete extends Query{
	public QueryDelete() {
		super();
	}

	public QueryDelete(String query) {
		super(query);
		this.execute(); 
	}

	public int execute() {
		super.executeSimple();
		return super.getCtrlConexao().executeStatementUpdate(); 
	}
	
	public int execute(int id) {
		try {
			super.executeSimple();
			PreparedStatement stmt = null;
			stmt = super.getCtrlConexao().getPrepareStatement();
			stmt.setInt(1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return super.getCtrlConexao().executeStatementUpdate(); 
	}
	
	public int execute(String query) {
		super.executeSimple(query);
		return super.getCtrlConexao().executeStatementUpdate(); 
	}

	public int execute(String query, int id) {
		try {
			super.executeSimple(query);
			PreparedStatement stmt = null;
			stmt = super.getCtrlConexao().getPrepareStatement();
			stmt.setInt(1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return super.getCtrlConexao().executeStatementUpdate(); 
	}

}

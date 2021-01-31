package br.com.ufc.aps.biblioteca.conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private String url = "jdbc:postgresql://localhost/APS";
	private String driver = "org.postgresql.Driver";
	private String user = "postgres";
	private String senha = "123";
	
	public Conexao() {
	}

	public Conexao(String url, String bd, String driver, String user, String senha) {
		this.url = url+"/"+bd;
		this.driver = driver;
		this.user = user;
		this.senha = senha;
	}
	
	public Connection start() {
		try {
			Class.forName(driver);
			
			return DriverManager.getConnection(url, user, senha);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void stop(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

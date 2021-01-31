package br.com.ufc.aps.biblioteca.visual.controller;

import br.com.ufc.aps.biblioteca.DAO.AlunoDAO;
import br.com.ufc.aps.biblioteca.model.Aluno;
import br.com.ufc.aps.biblioteca.model.Bibliotecario;

public class FrmLoginController {

	public FrmLoginController() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean authenticateLogin(int opcao, int matricula, String senha) {
		if(opcao == 0)
			return authenticateLoginAluno(matricula, senha);
		else
			return authenticateLoginBibliotecario(matricula, senha);
	}
	
	public boolean authenticateLoginAluno(int matricula, String senha) {
		Aluno aluno = new AlunoDAO().getAluno(matricula);
		
		if(aluno == null || !aluno.getSenha().equals(senha))
			return false;
		else 
			return true;
	}
	
	public boolean authenticateLoginBibliotecario(int matricula, String senha) {
		Bibliotecario bibliotecario = Bibliotecario.getInstance();
		
		if(bibliotecario.getMatricula() != matricula || !bibliotecario.getSenha().equals(senha))
			return false;
		else 
			return true;
	}

}

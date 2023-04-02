package br.unifametro.servlets;

import static java.lang.Integer.valueOf;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unifametro.dao.AlunoDAO;
import br.unifametro.entidades.Aluno;

@WebServlet("/CadastroAluno")
public class CadastroAluno extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	
    private AlunoDAO dao = new AlunoDAO();
    
    /**
     * Método que recebe requisições Http do Tipo Post e cadastra o Aluno.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dao.cadastrar(new Aluno(
        		valueOf(request.getParameter("idade")), 
        		request.getParameter("nome")));
    }

    /**
     * Método que recebe requisições Http do Tipo GET e direciona o usuário para o formulário de cadastro.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("cadastro-de-aluno.html").forward(request, response);
    }

}

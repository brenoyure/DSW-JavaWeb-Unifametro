package br.unifametro.servlets;

import static java.lang.Integer.valueOf;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unifametro.entidades.Aluno;

@WebServlet("/CadastroAluno")
public class CadastroAluno extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
    /**
     * Método que recebe requisições Http do Tipo GET e direciona o usuário para o formulário de cadastro.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.getRequestDispatcher("cadastro-de-aluno.html").forward(request, response);
    	
    	PrintWriter writer = response.getWriter();
    	writer.println(getFormularioCadastro());

    	
    }

    /**
     * Método que recebe requisições Http do Tipo Post e cadastra o Aluno.
     * Após o cadastro, o objeto aluno será atribuído à Session, 
     * e em seguida o usuário é redirecionado para a página do jogo.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Aluno aluno = new Aluno(valueOf(request.getParameter("idade")),request.getParameter("nome"));
    	request.getSession().setAttribute("aluno", aluno);
    	response.sendRedirect("Jogo");
    }
    
    private String getFormularioCadastro() {
    	return "<!DOCTYPE html>\n"
    			+ "<html lang=\"pt-BR\">\n"
    			+ "\n"
    			+ "<head>\n"
    			+ "    <meta charset=\"UTF-8\">\n"
    			+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
    			+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
    			+ "    <link rel=\"stylesheet\" href=\"./styles/style.css\">\n"
    			+ "    <link rel=\"stylesheet\" href=\"./styles/cadastro-aluno-links-container-styles.css\">\n"
    			+ "    <script type=\"text/javascript\" src=\"./scripts/script.js\"></script>\n"
    			+ "    <title>Cadastro de Aluno</title>\n"
    			+ "</head>\n"
    			+ "\n"
    			+ "<body>\n"
    			+ "\n"
    			+ "    <div class=\"container\">\n"
    			+ "        <div class=\"formulario\">\n"
    			+ "            <form action=\"\" method=\"post\" id=\"formulario-cadastro\">\n"
    			+ "                <h1 class=\"form-header\">Formulario de Cadastro</h1>\n"
    			+ "\n"
    			+ "                <label class=\"form-label\" for=\"nome\">Nome: </label>\n"
    			+ "                <input required class=\"form-input\" type=\"text\" name=\"nome\" id=\"nome\" placeholder=\"Insira seu Nome\">\n"
    			+ "                <br><br>\n"
    			+ "\n"
    			+ "                <label class=\"form-label\" for=\"idade\">Idade: </label>\n"
    			+ "                <input required class=\"form-input\" type=\"number\" name=\"idade\" id=\"idade\" oninput=\"verificaIdade()\"\n"
    			+ "                    placeholder=\"Insira sua Idade\">\n"
    			+ "                <br><br>\n"
    			+ "\n"
    			+ "                <input class=\"form-button\" type=\"submit\" value=\"Enviar\">\n"
    			+ "                <input class=\"form-button\" type=\"reset\" value=\"Limpar\">\n"
    			+ "\n"
    			+ "            </form>\n"
    			+ "        </div>\n"
    			+ "    </div>\n"
    			+ "\n"
    			+ "    <div class=\"links-container\">\n"
    			+ "        <div class=\"container-links\">\n"
    			+ "            <h2 class=\"links-header\">Opcoes</h2>\n"
    			+ "            <a class=\"links\" href=\"/AP1-SW\">Voltar a Pagina Inicial</a>\n"
    			+ "        </div>\n"
    			+ "    </div>\n"
    			+ "\n"
    			+ "\n"
    			+ "</body>\n"
    			+ "\n"
    			+ "</html>";
    }

}

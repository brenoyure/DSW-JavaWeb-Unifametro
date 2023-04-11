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
    	return """
               <!DOCTYPE html>
               <html lang="pt-BR">
               
               <head>
                   <meta charset="UTF-8">
                   <meta http-equiv="X-UA-Compatible" content="IE=edge">
                   <meta name="viewport" content="width=device-width, initial-scale=1.0">
                   <link rel="stylesheet" href="./styles/style.css">
                   <link rel="stylesheet" href="./styles/cadastro-aluno-links-container-styles.css">
                   <script type="text/javascript" src="./scripts/script.js"></script>
                   <title>Cadastro de Aluno</title>
               </head>
               
               <body>
               
                   <div class="container">
                       <div class="formulario">
                           <form action="" method="post" id="formulario-cadastro">
                               <h1 class="form-header">Formulario de Cadastro</h1>
               
                               <label class="form-label" for="nome">Nome: </label>
                               <input required class="form-input" type="text" name="nome" id="nome" placeholder="Insira seu Nome">
                               <br><br>
               
                               <label class="form-label" for="idade">Idade: </label>
                               <input required class="form-input" type="number" name="idade" id="idade" oninput="verificaIdade()"
                                   placeholder="Insira sua Idade">
                               <br><br>
               
                               <input class="form-button" type="submit" value="Enviar">
                               <input class="form-button" type="reset" value="Limpar">
               
                           </form>
                       </div>
                   </div>
               
                   <div class="links-container">
                       <div class="container-links">
                           <h2 class="links-header">Opcoes</h2>
                           <a class="links" href="/AP1-SW">Voltar a Pagina Inicial</a>
                       </div>
                   </div>
               
               
               </body>
               
               </html>""";
    }

}

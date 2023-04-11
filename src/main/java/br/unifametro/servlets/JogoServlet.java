package br.unifametro.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unifametro.entidades.Aluno;

@WebServlet("/Jogo")
public class JogoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Método que recebe requisições Http do Tipo GET e direciona o usuário para o
	 * formulário de cadastro.
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.println(getFormularioJogo(request));
	}

	/**
	 * Método que recebe os números, através de uma requisição Http do tipo Post e
	 * retorna o maior e menor número.
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int num1 = Integer.parseInt(request.getParameter("Numero1"));
		int num2 = Integer.parseInt(request.getParameter("Numero2"));
		int num3 = Integer.parseInt(request.getParameter("Numero3"));
		int num4 = Integer.parseInt(request.getParameter("Numero4"));
		int num5 = Integer.parseInt(request.getParameter("Numero5"));

		int[] numeros = { num1, num2, num3, num4, num5 };
		int[] resultado = getResultado(numeros);

		System.out.println("Menor: " + resultado[0]);
		System.out.println("Maior: " + resultado[1]);
		
		request.getSession().setAttribute("resultado", resultado);
		response.sendRedirect("Resultado");

	}

	/**
	 * Recebe um vetor contendo os números que serão verificados. <br>E Retorna um vetor
	 * resultado, em que na posição [0] está o menor número e na posição [1] está o
	 * maior.
	 * 
	 * @param numeros
	 * @return vetor contendo o resultado
	 */
	private int[] getResultado(int[] numeros) {

		int menor = numeros[0];
		int maior = numeros[0];

		for (int numero : numeros) {

			if (numero > maior)
				maior = numero;

			if (numero < menor)
				menor = numero;
		}

		int[] resultado = {menor, maior};
		return resultado;

	}

	private String getFormularioJogo(HttpServletRequest request) {
		
		Aluno aluno = (Aluno) request.getSession().getAttribute("aluno");
		
		return String.format("""
                                     <!DOCTYPE html>
                                     <html lang="pt-BR">
                                     
                                     <head>
                                         <meta charset="UTF-8">
                                         <meta http-equiv="X-UA-Compatible" content="IE=edge">
                                         <meta name="viewport" content="width=device-width, initial-scale=1.0">
                                         <link rel="stylesheet" href="./styles/style.css">
                                         <link rel="stylesheet" href="./styles/jogo-links-container-styles.css">
                                         <script type="text/javascript" src="./scripts/script.js"></script>
                                         <title>Jogo do Maior N\u00famero</title>
                                     </head>
                                     
                                     <body>
                                     
                                         <div class="container">
                                             <div class="formulario">
                                                 <form action="" method="post">
                                                     <h1 class="form-header">Jogo do Maior Numero</h1>
                                     
                                                     <label class="form-game-label" for="Numero1">1: </label>
                                                     <input required class="form-game-input" type="number" name="Numero1" id="Numero1" value="0">
                                     
                                                     <label class="form-game-label" for="Numero2">2: </label>
                                                     <input required class="form-game-input" type="number" name="Numero2" id="Numero2" value="0">
                                                     <br><br>
                                     
                                                     <label class="form-game-label" for="Numero3">3: </label>
                                                     <input required class="form-game-input" type="number" name="Numero3" id="Numero3" value="0">
                                     
                                                     <label class="form-game-label" for="Numero4">4: </label>
                                                     <input required class="form-game-input" type="number" name="Numero4" id="Numero4" value="0">
                                                     <br><br>
                                     
                                                     <label class="form-game-label" for="Numero5" id="Number5-label">5: </label>
                                                     <input required class="form-game-input" type="number" name="Numero5" id="Numero5" value="0">
                                                     <br><br>
                                     
                                                     <button class="form-button" type="submit">Enviar</button>
                                                     <button class="form-button" type="reset">Limpar</button>
                                     
                                                 </form>
                                             </div>
                                         </div>
                                     
                                         <div class="links-container">
                                             <div class="container-links">
                                                 <br>
                                                 <h3 class="links-header">Jogador(a): %s | Idade: %d anos.</h3>
                                                 <br>
                                                 <a class="links" href="CadastroAluno">Alterar Cadastro do Jogador(a)</a>
                                                 <a class="links" href="/AP1-SW">Pagina Inicial</a>
                                             </div>
                                         </div>
                                     
                                     
                                     </body>
                                     
                                     </html>""", aluno.getNome(), aluno.getIdade());
	}

}

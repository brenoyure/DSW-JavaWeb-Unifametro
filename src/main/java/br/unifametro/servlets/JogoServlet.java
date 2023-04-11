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
		
		return String.format("<!DOCTYPE html>\n" + "<html lang=\"pt-BR\">\n" + "\n" + "<head>\n" + "    <meta charset=\"UTF-8\">\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
				+ "    <link rel=\"stylesheet\" href=\"./styles/style.css\">\n"
				+ "    <link rel=\"stylesheet\" href=\"./styles/jogo-links-container-styles.css\">\n"
				+ "    <script type=\"text/javascript\" src=\"./scripts/script.js\"></script>\n"
				+ "    <title>Jogo do Maior Número</title>\n" + "</head>\n" + "\n" + "<body>\n" + "\n"
				+ "    <div class=\"container\">\n" + "        <div class=\"formulario\">\n"
				+ "            <form action=\"\" method=\"post\">\n"
				+ "                <h1 class=\"form-header\">Jogo do Maior Numero</h1>\n" + "\n"
				+ "                <label class=\"form-game-label\" for=\"Numero1\">1: </label>\n"
				+ "                <input required class=\"form-game-input\" type=\"number\" name=\"Numero1\" id=\"Numero1\" value=\"0\">\n"
				+ "\n" + "                <label class=\"form-game-label\" for=\"Numero2\">2: </label>\n"
				+ "                <input required class=\"form-game-input\" type=\"number\" name=\"Numero2\" id=\"Numero2\" value=\"0\">\n"
				+ "                <br><br>\n" + "\n"
				+ "                <label class=\"form-game-label\" for=\"Numero3\">3: </label>\n"
				+ "                <input required class=\"form-game-input\" type=\"number\" name=\"Numero3\" id=\"Numero3\" value=\"0\">\n"
				+ "\n" + "                <label class=\"form-game-label\" for=\"Numero4\">4: </label>\n"
				+ "                <input required class=\"form-game-input\" type=\"number\" name=\"Numero4\" id=\"Numero4\" value=\"0\">\n"
				+ "                <br><br>\n" + "\n"
				+ "                <label class=\"form-game-label\" for=\"Numero5\" id=\"Number5-label\">5: </label>\n"
				+ "                <input required class=\"form-game-input\" type=\"number\" name=\"Numero5\" id=\"Numero5\" value=\"0\">\n"
				+ "                <br><br>\n" + "\n"
				+ "                <button class=\"form-button\" type=\"submit\">Enviar</button>\n"
				+ "                <button class=\"form-button\" type=\"reset\">Limpar</button>\n" + "\n"
				+ "            </form>\n" + "        </div>\n" + "    </div>\n" + "\n"
				+ "    <div class=\"links-container\">\n" + "        <div class=\"container-links\">\n"
				+ "            <br>\n" + "            <h3 class=\"links-header\">" + "Jogador(a): %s | Idade: %d anos.</h3>\n" + "            <br>\n"
				+ "            <a class=\"links\" href=\"CadastroAluno\">Alterar Cadastro do Jogador(a)</a>\n"
				+ "            <a class=\"links\" href=\"/AP1-SW\">Pagina Inicial</a>\n" + "        </div>\n"
				+ "    </div>\n" + "\n" + "\n" + "</body>\n" + "\n" + "</html>", aluno.getNome(), aluno.getIdade());
	}

}

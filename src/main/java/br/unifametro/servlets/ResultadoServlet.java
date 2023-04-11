package br.unifametro.servlets;

import static java.lang.String.format;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Resultado")
public class ResultadoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		writer.println(getPaginaResultado(request));
	}
	
	private String getPaginaResultado(HttpServletRequest request) {
		
		int[] resultado = (int[])request.getSession().getAttribute("resultado");
		int menor = resultado[0];
		int maior = resultado[1];
		
		return format(
				"<!DOCTYPE html>\n"
				+ "<html lang=\"pt-BR\">\n"
				+ "\n"
				+ "<head>\n"
				+ "    <meta charset=\"UTF-8\">\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
				+ "    <link rel=\"stylesheet\" href=\"./styles/resultado-container-styles.css\">\n"
				+ "    <link rel=\"stylesheet\" href=\"./styles/style.css\">\n"
				+ "    <script type=\"text/javascript\" src=\"./scripts/script.js\"></script>\n"
				+ "    <title>Resultado</title>\n"
				+ "</head>\n"
				+ "\n"
				+ "<body>\n"
				+ "\n"
				+ "    <div class=\"container\">\n"
				+ "\n"
				+ "        <div class=\"links-container\">\n"
				+ "\n"
				+ "            <div class=\"container-links\">\n"
				+ "\n"
				+ "                <div class=\"container-resultado\">\n"
				+ "                    <h2 class=\"resultado-header\">Resultado</h2>\n"
				+ "                    <label class=\"form-label\">Menor Numero: <span>%d</span></label>\n"
				+ "                    <label class=\"form-label\">Maior Numero: <span>%d</span></label>\n"
				+ "                </div>\n"
				+ "                <h2 class=\"links-header\">Opcoes</h2>\n"
				+ "                <a class=\"links\" href=\"/AP1-SW\">Pagina Inicial</a>\n"
				+ "                <a class=\"links\" href=\"Jogo\">Jogar Novamente</a>\n"
				+ "            </div>\n"
				+ "\n"
				+ "        </div>\n"
				+ "\n"
				+ "    </div>\n"
				+ "\n"
				+ "\n"
				+ "</body>\n"
				+ "\n"
				+ "</html>"
				
				, menor, maior);
	}
	
}

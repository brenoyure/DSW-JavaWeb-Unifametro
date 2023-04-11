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
		
		return format("""
                              <!DOCTYPE html>
                              <html lang="pt-BR">
                              
                              <head>
                                  <meta charset="UTF-8">
                                  <meta http-equiv="X-UA-Compatible" content="IE=edge">
                                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                                  <link rel="stylesheet" href="./styles/resultado-container-styles.css">
                                  <link rel="stylesheet" href="./styles/style.css">
                                  <script type="text/javascript" src="./scripts/script.js"></script>
                                  <title>Resultado</title>
                              </head>
                              
                              <body>
                              
                                  <div class="container">
                              
                                      <div class="links-container">
                              
                                          <div class="container-links">
                              
                                              <div class="container-resultado">
                                                  <h2 class="resultado-header">Resultado</h2>
                                                  <label class="form-label">Menor Numero: <span>%d</span></label>
                                                  <label class="form-label">Maior Numero: <span>%d</span></label>
                                              </div>
                                              <h2 class="links-header">Opcoes</h2>
                                              <a class="links" href="/AP1-SW">Pagina Inicial</a>
                                              <a class="links" href="Jogo">Jogar Novamente</a>
                                          </div>
                              
                                      </div>
                              
                                  </div>
                              
                              
                              </body>
                              
                              </html>""", menor, maior);
	}
	
}

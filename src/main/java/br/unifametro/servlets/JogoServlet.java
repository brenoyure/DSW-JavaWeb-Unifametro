package br.unifametro.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Jogo")
public class JogoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Método que recebe requisições Http do Tipo GET e direciona o usuário para o
     * formulário de cadastro.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        request.getRequestDispatcher("jogo.html").forward(request, response);
    }

    /**
     * Método que recebe os números, através de uma requisição Http do tipo Post e
     * retorna o maior e menor número.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int num1 = Integer.parseInt(request.getParameter("Numero1"));
            int num2 = Integer.parseInt(request.getParameter("Numero2"));
            int num3 = Integer.parseInt(request.getParameter("Numero3"));
            int num4 = Integer.parseInt(request.getParameter("Numero4"));
            int num5 = Integer.parseInt(request.getParameter("Numero5"));
            int maior = num1;
            int menor = num1;

            int[] numeros = { num1, num2, num3, num4, num5 };

            for (int numero : numeros) {

                if (numero > maior)
                    maior = numero;

                if (numero < menor)
                    menor = numero;

            }

        } catch (NumberFormatException e) {
            response.sendRedirect("Jogo");
        }

        finally {
            response.sendRedirect("Jogo");
        }

    }

}

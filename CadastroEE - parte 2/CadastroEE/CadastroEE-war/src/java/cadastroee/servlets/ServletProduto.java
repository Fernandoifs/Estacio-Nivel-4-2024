package cadastroee.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import cadastroee.model.Produto;
import cadastroee.controller.ProdutoFacadeLocal;

@WebServlet(name = "ServletProduto", urlPatterns = {"/ServletProduto"})
public class ServletProduto extends HttpServlet {

    @EJB
    private ProdutoFacadeLocal facade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lista de Produtos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Lista de Produtos</h1>");

            if (facade == null) {
                out.println("<p>Erro: EJB ProdutoFacadeLocal não injetado</p>");
            } else {
                out.println("<p>EJB ProdutoFacadeLocal injetado com sucesso</p>");
                List<Produto> produtos = facade.findAll();
                
                if (produtos == null || produtos.isEmpty()) {
                    out.println("<p>Nenhum produto encontrado</p>");
                } else {
                    out.println("<ul>");
                    for (Produto produto : produtos) {
                        out.println("<li>" + produto.getProduto() + " - " + produto.getPreco() + "</li>");
                    }
                    out.println("</ul>");
                }
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}

package by.kagan.elibrary.Controllers;
import by.kagan.elibrary.DAOs.BookDAO;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/books")
public class BooksController extends HttpServlet {
    private final BookDAO bookDAO = new BookDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("bookies", bookDAO.showAll());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.setContentType("text/html");
        request.getRequestDispatcher("/WEB-INF/Views/books.jsp").forward(request, response);
    }
}

package by.kagan.elibrary.Controllers;

import by.kagan.elibrary.DAOs.BookDAO;
import by.kagan.elibrary.Models.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/books/new")
public class AddBookController extends HttpServlet {
    private final BookDAO bookDAO = new BookDAO();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.getRequestDispatcher("/WEB-INF/Views/newbook.jsp").forward(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Book book = new Book(request.getParameter("name"), request.getParameter("author"), Integer.parseInt(request.getParameter("year")), Double.parseDouble(request.getParameter("cost")));
        try {
            bookDAO.newBook(book);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("/books");
    }
}

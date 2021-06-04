package by.kagan.elibrary.DAOs;

import by.kagan.elibrary.Models.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "daka16052002";
    private static final String URL = "jdbc:postgresql://localhost:1605/booksdb";
    private static int ID = 2;
    private static Connection connection;

    static {
        try{
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException classNotFoundException){
            classNotFoundException.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public List<Book> showAll() throws SQLException {
        String sql = "SELECT*FROM books";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<Book> bookList = new ArrayList<>();
        while (resultSet.next()){
            Book book = new Book();
            book.setId(resultSet.getInt("id"));
            book.setName(resultSet.getString("name"));
            book.setAuthor(resultSet.getString("author"));
            book.setYear(resultSet.getInt("year"));
            book.setCost(resultSet.getDouble("cost"));
            bookList.add(book);
        }
        return bookList;
    }
    public void newBook(Book book) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT*FROM books");
        while(resultSet.next())
            ID = resultSet.getInt("id");
        ID++;
        book.setId(ID);
        String sql = "INSERT INTO books VALUES (" + book.getId() + ",'"+book.getName()+"', '" + book.getAuthor() + "', " + book.getYear() + ", " + book.getCost() + ")";
        statement.execute(sql);
    }


}

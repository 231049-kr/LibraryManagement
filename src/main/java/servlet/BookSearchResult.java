package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.BookSearchDAO;
import model.Book;

@WebServlet("/BookSearchResult")
public class BookSearchResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BookSearchResult() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String category = request.getParameter("category");
		String publisher = request.getParameter("publisher");
		String book_id = request.getParameter("book_id");
		
		BookSearchDAO dao = new BookSearchDAO();
		
		List<Book> books = dao.search(book_id, title, author, category, publisher);
		
		request.setAttribute("books", books);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/BookSearchResult.jsp");

		dispatcher.forward(request, response);
	}

}

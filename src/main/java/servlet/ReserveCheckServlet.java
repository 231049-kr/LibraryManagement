package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.BookDAO;
import model.Book;

/**
 * Servlet implementation class ReserveCheckServlet
 */
@WebServlet("/ReserveCheckServlet")
public class ReserveCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    try {
	        BookDAO dao = new BookDAO();
	        List<Book> bookList = dao.selectAllBooks();
	        request.setAttribute("bookList", bookList);
	        
	        // ✓ forward() を追加
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Reserve.jsp"); 
	        dispatcher.forward(request, response);
	    } catch (Exception e) {
	        request.setAttribute("error", "データの取得に失敗しました");
	        request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
	    }
	}
}

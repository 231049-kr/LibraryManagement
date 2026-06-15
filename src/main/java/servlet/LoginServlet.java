package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp")
	       .forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("password");
		
		//空白チェック
		
		if(id != null && id.length() != 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/LoginResult.jsp");
			dispatcher.forward(request, response);
		}
		if(pass != null && pass.length() != 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/LoginResult.jsp");
			dispatcher.forward(request, response);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/Usermenuscreen.jsp");
		dispatcher.forward(request, response);
		
	}

}

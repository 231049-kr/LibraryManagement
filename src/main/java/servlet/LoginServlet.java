package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.AccountsDAO;
import model.User;


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
		User user = new User();
		String id = request.getParameter("id");
		String pass = request.getParameter("password");
		String test = null;
		//空白チェック
		
		if(id != null && id.length() > 0) {
			
			test = "WEB-INF/jsp/Usermenuscreen.jsp";
			
		}
		if(pass != null && pass.length() > 0) {
			
			test = "WEB-INF/jsp/Usermenuscreen.jsp";
		}
		
		if(test == null) {
			test = "WEB-INF/jsp/LoginResult.jsp";
		}
		
		AccountsDAO dao = new AccountsDAO();
		User loginUser = dao.findByUser(user);
		
		if(loginUser != null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			
<<<<<<< HEAD
			url = "WEB-INF/jsp/Usermenuscreen.jsp";
		}*/
		//データベース接続時には以下をコメントアウトする。完成時に削除する
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
=======
			test = "WEB-INF/jsp/Usermenuscreen.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(test);
>>>>>>> branch 'master' of https://github.com/231049-kr/LibraryManagement
		dispatcher.forward(request, response);
	}

}

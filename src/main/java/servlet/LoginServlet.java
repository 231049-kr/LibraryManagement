package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.User;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/jsp/Usermenuscreen.jsp")
	       .forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		User user = new User();
		String id = request.getParameter("id");
		String pass = request.getParameter("password");
		String url = null;
		//空白チェック
		
		if(id != null && id.length() > 0) {
			
			url = "WEB-INF/jsp/Usermenuscreen.jsp";
			
		}
		if(pass != null && pass.length() > 0) {
			
			url = "WEB-INF/jsp/Usermenuscreen.jsp";
		}
		
		if(url == null) {
			url = "WEB-INF/jsp/LoginResult.jsp";
		}
		
		/*AccountsDAO dao = new AccountsDAO();
		User loginUser = dao.findByUser(user);
		
		if(loginUser != null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			
			url = "WEB-INF/jsp/Usermenuscreen.jsp";
		}*/
		//データベース接続時には以下をコメントアウトする。完成時に削除する
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}

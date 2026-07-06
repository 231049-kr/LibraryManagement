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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    
	    String id = request.getParameter("id");  // JSPと合わせて修正
	    String pass = request.getParameter("password");
	    String url = "WEB-INF/jsp/LoginResult.jsp";
	    
	    // バリデーション: 両方の入力値が必須
	    if (id == null || id.isEmpty() || pass == null || pass.isEmpty()) {
	        request.setAttribute("error", "IDとパスワードを入力してください");
	    } else {
	        User user = new User();
	        user.setId(id);
	        user.setPass(pass);
	        
	        AccountsDAO dao = new AccountsDAO();
	        User loginUser = dao.findByUser(user);
	        
	        if (loginUser != null) {
	            HttpSession session = request.getSession();
	            session.setAttribute("loginUser", loginUser);
	            url = "WEB-INF/jsp/Usermenuscreen.jsp";
	        } else {
	            request.setAttribute("error", "ログイン情報が正しくありません");
	        }
	    }
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	}
}
package model;

import dao.AccountsDAO;

public class LoginLogic {
	public boolean execute(User user) {
		
		AccountsDAO dao = new AccountsDAO();
		User account = dao.findByUser(user);
		
		return account != null;
	}
}

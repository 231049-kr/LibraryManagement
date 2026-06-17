package dao;

import java.sql.DriverManager;
import java.util.ArrayList;

public class List<Book> search(String title, String name, String category) {
	
	List<Book> list = new ArrayList<>();
	
	StringBuilder sql = new STringBuilder("SELECT * FROM books WHERE 1=1");
	
	if (!title.isEmpty()) {
		sql.append(" AND title LIKE ?");
	}
	
	if (!name.isEmpty()) {
		sql.append(" AND name LIKE ?");
	}
	
	if (!category.isEmpty()) {
		sql.append(" AND category LIKE ?");
	}
	//sql部分は後で要動作確認
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/library",
				"root",
				"password"
				);
		
		PrepareStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, "%" + title + "%");
		
				
	}
}

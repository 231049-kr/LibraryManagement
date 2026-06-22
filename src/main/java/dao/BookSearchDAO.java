package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
		ps.setString(2, "%" + name + "%");
		ps.setString(3, "%" + category + "%");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Book book = new Book();
			
			book.setId(rs.getInt("id"));
			book.setTitle(rs.getString("title"));
			book.setName(rs.getString("name"));
			book.setCategory(rs.getString("category"));
			
			list.add(book);
		}
		
		rs.close();
		ps.close();
		con.close();
		
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	return list;
}

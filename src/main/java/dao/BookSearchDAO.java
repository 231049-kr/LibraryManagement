package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Book;
public class BookSearchDAO {
	public List<Book> search(String title, String name, String category) {
		
		List<Book> list = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder("SELECT * FROM books WHERE 1=1");
		
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
			
			PreparedStatement ps = con.prepareStatement(sql.toString());
			
			int index = 1;
			
			if(!title.isEmpty()) {
				ps.setString(index++, "%" + title + "%");
			}
			if(!name.isEmpty()) {
				ps.setString(index++, "%" + name + "%");
			}
			if(!category.isEmpty()) {
				ps.setString(index++, "%" + category + "%");
			}
			
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
}
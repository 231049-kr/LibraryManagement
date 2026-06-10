package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class AccountsDAO {
	
	private final String JDBC_URL = "後で記入";
	private final String DB_USER = "root";
	private final String DB_PASS = "password";
	
	public User findByUser(User user) {
		
		//JDBCドライバを読み込む
		try {
			
			Class.forName("org.h2.Driver");
			
		} catch(ClassNotFoundException e) {
			
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		//DBへ接続
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			
			//SELECT文
			String sql = "SELECT //この先記入";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, user.getId());
			pStmt.setString(2, user.getPass());
			
			ResultSet rs = pStmt.executeQuery();
			
			if(rs.next()) {
				//ユーザデータが存在すればデータを取得
				//そのユーザーを表すAccountインスタンスを生成
				String id = rs.getString("");
				String pass = rs.getString("");
				String name = rs.getString("");
				
				user = new User(id, pass, name);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return user;
	}
}

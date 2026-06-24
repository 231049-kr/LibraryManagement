package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Book;

/**
 * 図書情報をMySQLに格納・取得するDAO（Data Access Object）クラス
 * JDBCドライバを使用してデータベース操作を行います
 */
public class BookDAO {
	
	// JDBC接続情報
	private static final String DB_URL = "jdbc:mysql://localhost:3306/library_db";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "password"; 
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	/**
	 * MySQLに接続します
	 * 
	 * @return データベース接続オブジェクト
	 * @throws SQLException データベース接続エラー
	 * @throws ClassNotFoundException JDBCドライバが見つからない
	 */
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(DB_DRIVER);
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	}
	
	/**
	 * 図書情報をデータベースに挿入します
	 * 
	 * @param book 挿入する図書オブジェクト
	 * @return 挿入に成功したかどうか（true：成功、false：失敗）
	 */
	public static boolean insertBook(Book book) {
		String sql = "INSERT INTO books (bid, bname) VALUES (?, ?)";
		
		try (Connection conn = getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, book.getBid());
			pstmt.setString(2, book.getBname());
			
			int result = pstmt.executeUpdate();
			System.out.println("✓ 図書が正常に挿入されました: " + book.toString());
			return result > 0;
			
		} catch (SQLException | ClassNotFoundException e) {
			System.err.println("✗ 図書の挿入に失敗しました");
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 図書IDで図書情報を検索します
	 * 
	 * @param bid 検索する図書ID
	 * @return 図書オブジェクト（見つからない場合はnull）
	 */
	public static Book selectBookById(String bid) {
		String sql = "SELECT * FROM books WHERE bid = ?";
		
		try (Connection conn = getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, bid);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				Book book = new Book();
				book.setBid(rs.getString("bid"));
				book.setBname(rs.getString("bname"));
				System.out.println("✓ 図書が見つかりました: " + book.toString());
				return book;
			}
			
			System.out.println("✗ 図書ID '" + bid + "' は見つかりませんでした");
			return null;
			
		} catch (SQLException | ClassNotFoundException e) {
			System.err.println("✗ 図書の検索に失敗しました");
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * すべての図書情報を取得します
	 * 
	 * @return 図書オブジェクトのリスト
	 */
	public static List<Book> selectAllBooks() {
		List<Book> books = new ArrayList<>();
		String sql = "SELECT * FROM books";
		
		try (Connection conn = getConnection();
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql)) {
			
			while (rs.next()) {
				Book book = new Book();
				book.setBid(rs.getString("bid"));
				book.setBname(rs.getString("bname"));
				books.add(book);
			}
			
			System.out.println("✓ " + books.size() + "件の図書が取得されました");
			return books;
			
		} catch (SQLException | ClassNotFoundException e) {
			System.err.println("✗ すべての図書の取得に失敗しました");
			e.printStackTrace();
			return books;
		}
	}
	
	/**
	 * 図書情報を更新します
	 * 
	 * @param book 更新する図書オブジェクト
	 * @return 更新に成功したかどうか
	 */
	public static boolean updateBook(Book book) {
		String sql = "UPDATE books SET bname = ? WHERE bid = ?";
		
		try (Connection conn = getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, book.getBname());
			pstmt.setString(2, book.getBid());
			
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("✓ 図書が正常に更新されました: " + book.toString());
			} else {
				System.out.println("✗ 図書ID '" + book.getBid() + "' は見つかりませんでした");
			}
			return result > 0;
			
		} catch (SQLException | ClassNotFoundException e) {
			System.err.println("✗ 図書の更新に失敗しました");
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 図書情報を削除します
	 * 
	 * @param bid 削除する図書ID
	 * @return 削除に成功したかどうか
	 */
	public static boolean deleteBook(String bid) {
		String sql = "DELETE FROM books WHERE bid = ?";
		
		try (Connection conn = getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, bid);
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("✓ 図書ID '" + bid + "' が正常に削除されました");
			} else {
				System.out.println("✗ 図書ID '" + bid + "' は見つかりませんでした");
			}
			return result > 0;
			
		} catch (SQLException | ClassNotFoundException e) {
			System.err.println("✗ 図書の削除に失敗しました");
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * テーブルが存在しない場合は作成します
	 * 初期化時に一度だけ実行してください
	 */
	public static void createTableIfNotExists() {
		String sql = "CREATE TABLE IF NOT EXISTS books (" +
					 "bid VARCHAR(50) PRIMARY KEY, " +
					 "bname VARCHAR(255) NOT NULL, " +
					 "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
					 ")";
		
		try (Connection conn = getConnection();
			 Statement stmt = conn.createStatement()) {
			
			stmt.executeUpdate(sql);
			System.out.println("✓ テーブル 'books' の確認/作成が完了しました");
			
		} catch (SQLException | ClassNotFoundException e) {
			System.err.println("✗ テーブルの作成に失敗しました");
			e.printStackTrace();
		}
	}
}

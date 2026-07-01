package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Book;

/**
 * 図書情報をMySQLに格納・取得するDAO（Data Access Object）クラス
 * JDBCドライバを使用してデータベース操作を行います
 */
public class BookDAO {
	
	// JDBC接続情報（環境変数から取得、デフォルト値あり）
	private static final String DB_URL = System.getenv("DB_URL") != null 
		? System.getenv("DB_URL") 
		: "jdbc:mysql://localhost:3306/tutorial_memo_db";
	
	private static final String DB_USER = System.getenv("DB_USER") != null 
		? System.getenv("DB_USER") 
		: "appuser";
	
	private static final String DB_PASSWORD = System.getenv("DB_PASSWORD") != null 
		? System.getenv("DB_PASSWORD") 
		: "password";
	
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
		String sql = "INSERT INTO books (title, author, publisher, category, quantity) VALUES (?, ?, ?, ?, ?)";
		
		try (Connection conn = getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getPublisher());
			pstmt.setString(4, book.getCategory());
			pstmt.setInt(5, book.getQuantity());
			
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
	 * @param bookId 検索する図書ID
	 * @return 図書オブジェクト（見つからない場合はnull）
	 */
	public static Book selectBookById(int bookId) {
		String sql = "SELECT book_id, title, author, publisher, category, quantity, created_at FROM books WHERE book_id = ?";
		
		try (Connection conn = getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setInt(1, bookId);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				Book book = new Book();
				book.setBookId(rs.getInt("book_id"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setCategory(rs.getString("category"));
				book.setQuantity(rs.getInt("quantity"));
				
				Timestamp ts = rs.getTimestamp("created_at");
				if (ts != null) {
					book.setCreatedAt(ts.toLocalDateTime());
				}
				
				System.out.println("✓ 図書が見つかりました: " + book.toString());
				return book;
			}
			
			System.out.println("✗ 図書ID '" + bookId + "' は見つかりませんでした");
			return null;
			
		} catch (SQLException | ClassNotFoundException e) {
			System.err.println("✗ 図書の検索に失敗しました");
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * カテゴリーで図書情報を検索します
	 * 
	 * @param category 検索するカテゴリー
	 * @return 図書オブジェクトのリスト
	 */
	public static List<Book> selectBooksByCategory(String category) {
		List<Book> books = new ArrayList<>();
		String sql = "SELECT book_id, title, author, publisher, category, quantity, created_at FROM books WHERE category = ?";
		
		try (Connection conn = getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, category);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Book book = new Book();
				book.setBookId(rs.getInt("book_id"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setCategory(rs.getString("category"));
				book.setQuantity(rs.getInt("quantity"));
				
				Timestamp ts = rs.getTimestamp("created_at");
				if (ts != null) {
					book.setCreatedAt(ts.toLocalDateTime());
				}
				
				books.add(book);
			}
			
			System.out.println("✓ カテゴリー'" + category + "' の図書 " + books.size() + "件が取得されました");
			return books;
			
		} catch (SQLException | ClassNotFoundException e) {
			System.err.println("✗ 図書の検索に失敗しました");
			e.printStackTrace();
			return books;
		}
	}
	
	/**
	 * タイトルで図書情報を検索します（部分一致）
	 * 
	 * @param titleKeyword 検索するキーワード
	 * @return 図書オブジェクトのリスト
	 */
	public static List<Book> selectBooksByTitleKeyword(String titleKeyword) {
		List<Book> books = new ArrayList<>();
		String sql = "SELECT book_id, title, author, publisher, category, quantity, created_at FROM books WHERE title LIKE ?";
		
		try (Connection conn = getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, "%" + titleKeyword + "%");
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Book book = new Book();
				book.setBookId(rs.getInt("book_id"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setCategory(rs.getString("category"));
				book.setQuantity(rs.getInt("quantity"));
				
				Timestamp ts = rs.getTimestamp("created_at");
				if (ts != null) {
					book.setCreatedAt(ts.toLocalDateTime());
				}
				
				books.add(book);
			}
			
			System.out.println("✓ キーワード'" + titleKeyword + "' で " + books.size() + "件が見つかりました");
			return books;
			
		} catch (SQLException | ClassNotFoundException e) {
			System.err.println("✗ 図書の検索に失敗しました");
			e.printStackTrace();
			return books;
		}
	}
	
	/**
	 * すべての図書情報を取得します
	 * 
	 * @return 図書オブジェクトのリスト
	 */
	public static List<Book> selectAllBooks() {
		List<Book> books = new ArrayList<>();
		String sql = "SELECT book_id, title, author, publisher, category, quantity, created_at FROM books ORDER BY book_id DESC";
		
		try (Connection conn = getConnection();
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery(sql)) {
			
			while (rs.next()) {
				Book book = new Book();
				book.setBookId(rs.getInt("book_id"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				book.setCategory(rs.getString("category"));
				book.setQuantity(rs.getInt("quantity"));
				
				Timestamp ts = rs.getTimestamp("created_at");
				if (ts != null) {
					book.setCreatedAt(ts.toLocalDateTime());
				}
				
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
		String sql = "UPDATE books SET title = ?, author = ?, publisher = ?, category = ?, quantity = ? WHERE book_id = ?";
		
		try (Connection conn = getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getPublisher());
			pstmt.setString(4, book.getCategory());
			pstmt.setInt(5, book.getQuantity());
			pstmt.setInt(6, book.getBookId());
			
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("✓ 図書が正常に更新されました: " + book.toString());
			} else {
				System.out.println("✗ 図書ID '" + book.getBookId() + "' は見つかりませんでした");
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
	 * @param bookId 削除する図書ID
	 * @return 削除に成功したかどうか
	 */
	public static boolean deleteBook(int bookId) {
		String sql = "DELETE FROM books WHERE book_id = ?";
		
		try (Connection conn = getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setInt(1, bookId);
			int result = pstmt.executeUpdate();
			
			if (result > 0) {
				System.out.println("✓ 図書ID '" + bookId + "' が正常に削除されました");
			} else {
				System.out.println("✗ 図書ID '" + bookId + "' は見つかりませんでした");
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
					 "book_id INT NOT NULL AUTO_INCREMENT COMMENT '図書ID'," +
					 "title VARCHAR(255) NOT NULL COMMENT '図書タイトル'," +
					 "author VARCHAR(100) NOT NULL COMMENT '著者名'," +
					 "publisher VARCHAR(100) NOT NULL COMMENT '出版社'," +
					 "category VARCHAR(50) NOT NULL COMMENT 'カテゴリー'," +
					 "quantity INT NOT NULL DEFAULT 1 COMMENT '数量'," +
					 "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '登録日時'," +
					 "PRIMARY KEY (book_id)" +
					 ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_unicode_ci";
		
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

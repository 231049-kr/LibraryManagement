package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Book;

/**
 * 図書情報を検索するDAO（Data Access Object）クラス
 * 複数の条件を組み合わせた動的検索に対応しています
 */
public class BookSearchDAO {
	
	/**
	 * 複数条件で図書を検索
	 * 
	 * @param title 図書タイトル（キーワード）- nullまたは空文字列で条件なし
	 * @param author 著者名（キーワード）- nullまたは空文字列で条件なし
	 * @param category カテゴリー - nullまたは空文字列で条件なし
	 * @return マッチした図書オブジェクトのリスト
	 */
	public List<Book> search(String book_id,String title, String author, String category, String publisher) {
		List<Book> books = new ArrayList<>();
		
		// SQLの動的構築
		StringBuilder sql = new StringBuilder(
			"SELECT book_id, title, author, publisher, category, quantity, created_at FROM books WHERE 1=1"
		);
		
		// 条件を追加
		if(book_id != null && !book_id.isEmpty()) {
			sql.append(" AND book_id = ?");
		}
		
		if (title != null && !title.isEmpty()) {
			sql.append(" AND title LIKE ?");
		}
		
		if (author != null && !author.isEmpty()) {
			sql.append(" AND author LIKE ?");
		}
		
		if (category != null && !category.isEmpty()) {
			sql.append(" AND category LIKE ?");
		}
		
		if (publisher != null && !publisher.isEmpty()) {
			sql.append(" AND publisher LIKE ?");
		}
		
		sql.append(" ORDER BY book_id DESC");
		
		try (Connection conn = BookDAO.getConnection();
			 PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
			
			int index = 1;

			if (book_id != null && !book_id.isEmpty()) {
			    pstmt.setString(index++, "%" + book_id + "%");
			}

			if (title != null && !title.isEmpty()) {
			    pstmt.setString(index++, "%" + title + "%");
			}

			if (author != null && !author.isEmpty()) {
			    pstmt.setString(index++, "%" + author + "%");
			}

			if (category != null && !category.isEmpty()) {
			    pstmt.setString(index++, "%" + category + "%");
			}

			if (publisher != null && !publisher.isEmpty()) {
			    pstmt.setString(index++, "%" + publisher + "%");
			}
			// クエリ実行
			
			ResultSet rs = pstmt.executeQuery();
			
			// 結果を処理
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
			
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		return books;
	}
}

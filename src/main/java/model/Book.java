package model;

import java.time.LocalDateTime;

/**
 * 図書情報を表すモデルクラス
 */
public class Book {
	private int bookId;           // 図書ID (AUTO_INCREMENT)
	private String title;         // 図書タイトル
	private String author;        // 著者名
	private String publisher;     // 出版社
	private String category;      // カテゴリー
	private int quantity;         // 数量
	private LocalDateTime createdAt;  // 登録日時
	
	// デフォルトコンストラクタ
	public Book() {}
	
	// コンストラクタ（主要フィールド）
	public Book(String title, String author, String publisher, String category, int quantity) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.category = category;
		this.quantity = quantity;
	}
	
	// コンストラクタ（すべてのフィールド）
	public Book(int bookId, String title, String author, String publisher, String category, int quantity, LocalDateTime createdAt) {
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.category = category;
		this.quantity = quantity;
		this.createdAt = createdAt;
	}
	
	// ゲッター・セッター
	public int getBookId() {
		return bookId;
	}
	
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	/**
	 * 図書の情報を文字列で返す
	 */
	@Override
	public String toString() {
		return "Book [" +
				"bookId=" + bookId +
				", title='" + title + '\'' +
				", author='" + author + '\'' +
				", publisher='" + publisher + '\'' +
				", category='" + category + '\'' +
				", quantity=" + quantity +
				", createdAt=" + createdAt +
				']';
	}
}

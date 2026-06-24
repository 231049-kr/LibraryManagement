package model;

public class Book {
	private int id;
	private String title;
	private String name;
	private String category;
	
	public Book() {}
	public Book(int id, String title, String name,  String category ) {
		this.id = id;
		this.title = title;
		this.name = name;
		this.category = category;
	}
	
<<<<<<< HEAD
	public int getId() {return id;}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {return title;}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {return name;}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {return category;}
	public void setCategory(String category) {
		this.category = category;
=======
	public Book(String bname) {
		this.bname = bname;
		this.bid = BookIDGenerator.generateWithPrefix();
	}
	
	// Getter/Setter
	public String getBname() {
		return bname;
	}
	
	public void setBname(String bname) {
		this.bname = bname;
	}
	
	public String getBid() {
		return bid;
	}
	
	public void setBid(String bid) {
		this.bid = bid;
	}
	
	/**
	 * 図書の情報を表示用の文字列で返す
	 */
	@Override
	public String toString() {
		return "Book [図書名=" + bname + ", 図書ID=" + bid + "]";
>>>>>>> branch 'master' of https://github.com/231049-kr/LibraryManagement
	}
}

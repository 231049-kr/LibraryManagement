package model;

public class Book {
	private String bname;
	private String bid;
	
	public Book() {}
	public Book(String bname, String bid) {
		this.bname = bname;
		this.bid = bid;
	}
	
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
	}
}

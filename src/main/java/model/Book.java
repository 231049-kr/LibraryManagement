package model;

public class Book {
	private String bname;
	private String bid;
	
	public Book() {}
	public Book(String bname, String bid) {
		this.bname = bname;
		this.bid = bid;
	}
	
	public String getbname() {return bname;}
	public String getbid() {return bid;}
}


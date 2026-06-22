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
	}
}


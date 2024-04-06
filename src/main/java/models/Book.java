package models;

public class Book {
private int id;
private String name;
private String code;
private String category;
private Author author;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public Author getAuthor() {
	return author;
}
public void setAuthor(Author author) {
	this.author = author;
}

}

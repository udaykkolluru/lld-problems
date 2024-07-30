package model;

import java.util.Date;
import java.util.UUID;

public class Comments {

	private String id;
	private Date createDate;
	private Author author;
	private String content;

	public Comments(Author author, String content) {
		this.id = UUID.randomUUID().toString();
		this.createDate = new Date();
		this.author = author;
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Author getAuthor() {
		return author;
	}

	public String getContent() {
		return content;
	}

	@Override
	public String toString() {
		return "Comments [id=" + id + ", author=" + author.getUsername() + ", content=" + content + "]";
	}
	
	
	

}

package model;

public class Vote {

	private Author author;

	private int value;

	public Vote(Author author, int value) {
		super();
		this.author = author;
		this.value = value;
	}

	public Author getAuthor() {
		return author;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Vote [author=" + author.getUsername() + ", value=" + value + "]";
	}

	
	
	

}

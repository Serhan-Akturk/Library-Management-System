package edu.cuny.csi.csc330.finalProject;

public class Book {

	private String bookID;
	private String title;
	private String author;
	private String yearOfPub;
	private String description;

	public Book(String bookID, String title, String author, String yearOfPub, String description) {
		super();
		this.bookID = bookID;
		this.title = title;
		this.author = author;
		this.yearOfPub = yearOfPub;
		this.description = description;
	}

	public String getBookID() {
		return bookID;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getYearOfPub() {
		return yearOfPub;
	}

	public String getDescription() {
		return description;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setYearOfPub(String yearOfPub) {
		this.yearOfPub = yearOfPub;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookID == null) ? 0 : bookID.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bookID == null) {
			if (other.bookID != null)
				return false;
		} else if (!bookID.equals(other.bookID))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\n[bookID= " + bookID + ", title= " + title + ", author= " + author + ", yearOfPub= " + yearOfPub
				+ ", description= " + description + "]" + "\n";
	}

}

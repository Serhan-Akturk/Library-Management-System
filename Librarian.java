package edu.cuny.csi.csc330.finalProject;

import java.util.Map;
import java.io.IOException;
import java.util.Scanner;

public class Librarian extends User {

	private Scanner input = new Scanner(System.in);

	public Librarian() {
	}

	// adds book to library by ID.
	public void addBookToLibrary() {
		// prompt
		System.out.print("Please enter the book ID you would like to add: ");
		String id = input.next();
		System.out.print("Please enter the amount of the book you would like to add: ");
		Integer value = input.nextInt();
		int count = 0;

		for (Map.Entry<Book, Integer> ele : Library.bookList.entrySet()) {
			Book book = (Book) ele.getKey();
			if (book.getBookID().equals(id)) {
				// This will get the current amount of books in the library and add the amount
				// you want to it.
				Library.bookList.put(book, ele.getValue() + value);
				System.out.println("Successfully added book: " + book.getTitle() + " by ID.\n");
				count++;
			}
		}
		if (count == 0) {
			System.out.println("Can't add a book that doesn't exist.");
		}
	}

	public void removeBooksByTitle() {
		// prompt
		System.out.print("Please enter the title of the book you would like to remove: ");
		String title = input.next();
		int count = 0;

		for (Map.Entry<Book, Integer> ele : Library.bookList.entrySet()) {
			Book book = (Book) ele.getKey();
			// checks Book by title to remove 1 book from library
			if (book.getTitle().equals(title) && ele.getValue() > 0) {
				Library.bookList.put(book, ele.getValue() - 1);
				System.out.println("Successfully removed book: " + book.getTitle() + " by title\n");
				count++;
			}
		}

		if (count == 0) {
			System.out.println("No books found with that title.");
		}
	}

	public void removeBooksByAuthor() {
		// prompt
		System.out.print("Please enter the author of the book you would like to remove: ");
		String author = input.next();
		int count = 0;

		for (Map.Entry<Book, Integer> ele : Library.bookList.entrySet()) {
			Book book = (Book) ele.getKey();
			// checks Book by author to remove 1 book from library
			if (book.getAuthor().equals(author) && ele.getValue() > 0) {
				Library.bookList.put(book, ele.getValue() - 1);
				System.out.println("Successfully removed book: " + book.getTitle() + " by author\n");
				count++;
			}
		}

		if (count == 0) {
			System.out.println("No books found with that author.");
		}
	}

	public void removeBooksById() {
		System.out.print("Please enter the ID of the book you would like to remove: ");
		String id = input.next();
		int count = 0;

		for (Map.Entry<Book, Integer> ele : Library.bookList.entrySet()) {
			Book book = (Book) ele.getKey();
			// checks Book by id to remove 1 book from library
			if (book.getBookID().equals(id) && ele.getValue() > 0) {
				Library.bookList.put(book, ele.getValue() - 1);
				System.out.println("Successfully removed book: " + book.getTitle() + " by ID");
				count++;
			}
		}

		if (count == 0) {
			System.out.println("No books found with that ID.");
		}
	}
}
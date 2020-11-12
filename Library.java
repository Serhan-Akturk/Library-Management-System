package edu.cuny.csi.csc330.finalProject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Library {
	protected static HashMap<Book, Integer> bookList;
	private String menuSelection;
	private User currentUser;
	private Scanner input = new Scanner(System.in);

	public Library() {
		bookList = new HashMap<Book, Integer>();
		init(); // in the constructor to create all the books
	}

	private void init() {
		// creating books
		Book book1 = new Book("ID1", "title1", "author1", "YearOfPub1", "Description1"); //books for testing
		
		Book book2 = new Book("ID2", "title2", "author2", "YearOfPub2", "Description2"); 
		
		Book book3 = new Book("ID3", "title3", "author3", "YearOfPub3", "Description3"); 
		
		Book book4 = new Book("9781859985670", " The Great Gatsby", "F. Scott Fitzgerald", "1925", "The novel chronicles an era "+ "\nthat Fitzgerald himself dubbed the \"Jazz Age\". Following the shock and chaos of World War I, "
				+ "\nAmerican society enjoyed unprecedented levels of prosperity during the \"roaring\" 1920s as the "
				+ "\neconomy soared. At the same time, Prohibition, the ban on the sale and manufacture of alcohol as "
				+ "\nmandated by the Eighteenth Amendment, made millionaires out of bootleggers and led to an increase "
				+ "\nin organized crime, for example the Jewish mafia. Although Fitzgerald, like Nick Carraway in his "
				+ "\nnovel, idolized the riches and glamor of the age, he was uncomfortable with the unrestrained "
				+ "\nmaterialism and the lack of morality that went with it, a kind of decadence.");
		
		Book book5 = new Book("9780786160563", "War and Peace", "Leo Tolstoy", "1865", "Epic in scale, War and Peace "
				+ "\ndelineates in graphic detail events leading up to Napoleon's invasion of Russia, and the impact "
				+ "\nof the Napoleonic era on Tsarist society, as seen through the eyes of five Russian aristocratic"
				+ "\n families.");
		
		Book book6 = new Book("9781481506205", "Hamlet", "William Shakespeare", "1605", "The Tragedy of Hamlet, Prince of Denmark, "
				+ "\nor more simply Hamlet, is a tragedy by William Shakespeare, believed to have been written between "
				+ "\n1599 and 1601. The play, set in Denmark, recounts how Prince Hamlet exacts revenge on his uncle "
				+ "\nClaudius, who has murdered Hamlet's father, the King, and then taken the throne and married "
				+ "\nGertrude, Hamlet's mother. The play vividly charts the course of real and feigned madness—from "
				+ "\noverwhelming grief to seething rage—and explores themes of treachery, revenge, incest, and moral "
				+ "\ncorruption.");
		
		Book book7 = new Book("9781480559912", "To the Lighthouse", "Virginia Wolf", "1927", "A landmark novel of high"
				+ "\n modernism, the text, centering on the Ramsay family and their visits to the Isle of Skye in "
				+ "\nScotland between 1910 and 1920, skillfully manipulates temporality and psychological exploration. "
				+ "\nThe novel includes little dialogue and almost no action; most of it is written as thoughts and "
				+ "\nobservations. The novel recalls the power of childhood emotions and highlights the impermanence"
				+ "\n of adult relationships. Among the book's many tropes and themes are those of loss, subjectivity, "
				+ "\nand the problem of perception.");
		
		Book book8 = new Book("9781405503877", "Catch22", "Joseph Heller", "1961", "Catch-22 is a satirical, historical"
				+ "\n novel by the American author Joseph Heller, first published in 1961. The novel, set during the "
				+ "\nlater stages of World War II from 1943 onwards, is frequently cited as one of the great literary "
				+ "\nworks of the twentieth century. It has a distinctive non-chronological style where events are "
				+ "\ndescribed from different characters' points of view and out of sequence so that the time line "
				+ "\ndevelops along with the plot.");
		
		Book book9 = new Book("9781846572562", "To Kill a Mockingbird", "Harper Lee", "1960", "As a Southern Gothic novel"
				+ "\nand a Bildungsroman, the primary themes of To Kill a Mockingbird involve racial injustice and the "
				+ "\ndestruction of innocence. Scholars have noted that Lee also addresses issues of class, courage and"
				+ "\n compassion, and gender roles in the American Deep South. The story takes place during three years "
				+ "\nof the Great Depression in the fictional \"tired old town\" of Maycomb, Alabama. The narrator, "
				+ "\nsix-year-old Scout Finch, lives with her older brother Jem and their widowed father Atticus, "
				+ "\na middle-aged lawyer.");
		
		Book book10 = new Book("9781503275928", "Heart of Darkness", "Joseph Conrad", "1902", "The story details an "
				+ "\nincident when Marlow, an Englishman, took a foreign assignment from a Belgian trading company as "
				+ "\na ferry-boat captain in Africa. Although Conrad does not specify the name of the river, at this "
				+ "\ntime Congo Free State, the location of the large and important Congo River, was a private colony "
				+ "\nof Belgium's King Leopold II. Marlow is employed to transport ivory downriver; however, his more "
				+ "\npressing assignment is to return Kurtz, another ivory trader, to civilization in a cover up. Kurtz "
				+ "\nhas a reputation throughout the region.");

		// optional adding books to library
		bookList.put(book1, 5);
		bookList.put(book2, 1);
		bookList.put(book3, 1);
		bookList.put(book4, 0);
		bookList.put(book5, 0);
		bookList.put(book6, 0);
		bookList.put(book7, 0);
		bookList.put(book8, 0);
		bookList.put(book9, 0);
		bookList.put(book10, 0);

	}

	// this menu is for the student
	protected void menuMainStudent() throws IOException {
		while (true) {
			System.out.println("====================Student Menu====================");
			System.out.println("\nEnter 1) to borrow a book.");
			System.out.println("Enter 2) to return a book.");
			System.out.println("Enter 3) to search for a book.");
			System.out.println("Enter 4) to see all books in stock.");
			System.out.println("Enter 5) to see all books.");
			System.out.println("Enter 6) to see book(s) you have checked out.");
			System.out.println("Enter 7) to go back to main menu.");
			System.out.println("Enter 8) to quit.");
			menuAfterLoginStudent();
		}
	}

	// this menu is for the librarian
	protected void menuMainLibrarian() throws IOException {
		while (true) {
			System.out.println("====================Librarian Menu====================");
			System.out.println("\nEnter 1) to add a book by ID.");
			System.out.println("Enter 2) to remove a book by ID.");
			System.out.println("Enter 3) to remove a book by title.");
			System.out.println("Enter 4) to remove a book by author.");
			System.out.println("Enter 5) to search for a book.");
			System.out.println("Enter 6) to see all books in stock.");
			System.out.println("Enter 7) to see all books.");
			System.out.println("Enter 8) to add a user.");
			System.out.println("Enter 9) to delete a user.");
			System.out.println("Enter 10) to go back to main menu.");
			System.out.println("Enter 11) to quit.");
			menuAfterLoginLibrarian();
		}
	}

	private void menuAfterLoginStudent() throws IOException {
		Book temp;
		menuSelection = input.nextLine();
		switch (menuSelection) {
		case "1":
			temp = searchForBook();
			if (temp != null)
				borrowBook(temp);
			else {
				System.out.println("No book found in library with that name, author or ID");
			}
			break;
		case "2":
			temp = searchForBook();
			if (temp != null)
				returnBook(temp);
			else {
				System.out.println("Can't return a book that never existed.");
			}
			break;
		case "3":
            temp = searchForBook();
            if (temp != null)
                borrowBook(temp);
            else
                System.out.println("Book is not in stock");
            break;
		case "4":
			displayBooksInStock();
			break;
		case "5":
			displayAllBooks();
			break;
		case "6":
			currentUser.getBorrowedBooks();
			break;
		case "7":
			demo();
			break;
		case "8":
			System.out.println("Exiting now...");
			System.exit(0);
		default:
			System.out.println("Not a valid selection! Enter a valid selection!");
		}
	}

	private void menuAfterLoginLibrarian() throws IOException {
		Book temp;
		Librarian librarian = new Librarian();
		menuSelection = input.nextLine();
		switch (menuSelection) {
		case "1":
			librarian.addBookToLibrary();
			break;
		case "2":
			librarian.removeBooksById();
			break;
		case "3":
			librarian.removeBooksByTitle();
			break;
		case "4":
			librarian.removeBooksByAuthor();
			break;
		case "5":
            temp = searchForBook();
            if (temp != null)
                borrowBook(temp);
            else
                System.out.println("Book is not in stock");
            break;
		case "6":
			displayBooksInStock();
			break;
		case "7":
			displayAllBooks();
			break;
		case "8":
			currentUser.addUser();
			break;
		case "9":
			currentUser.deleteUser();
			break;
		case "10":
			demo();
			break;
		case "11":
			System.out.println("Exiting now...");
			System.exit(0);
		default:
			System.out.println("Not a valid selection! Enter a valid selection!");
		}
	}

	public void returnBook(Book returnBook) throws IOException {
		System.out.println(returnBook);
		System.out.println("Do you want to return this book? y/n");
		String temp = input.nextLine();
		if (temp.equals("y")) {
			if (currentUser.userReturnBook(returnBook)) {
				bookList.put(returnBook, bookList.get(returnBook) + 1);
				System.out.println("Book was returned!");			
			}			
			else
				System.out.println("You don't have that book! Book was not returned!");
		} 
		else if (temp.equals("n")) {
			System.out.println("Book was not returned!");
		}
	}

	public void borrowBook(Book borrowBook) throws IOException {
		System.out.println(borrowBook);
		System.out.println("Do you want to borrow this book? y/n");
		String temp = input.nextLine();
		if (temp.equals("y")) {
			if (bookList.get(borrowBook) > 0) {
				bookList.put(borrowBook, bookList.get(borrowBook) - 1);
				currentUser.userBorrowBook(borrowBook);
				System.out.println("Book was Borrowed!\n");
			} else {
				System.out.println("That book is not in stock!");
			}

		} else if (temp.equals("n")) {
			System.out.println("Book was not Borrowed!\n");
		}

	}

	// Prints all the books even if they're not in stock
	public void displayAllBooks() {
		System.out.println("==================== All Library Books ====================\n");
		for (Map.Entry<Book, Integer> entry : bookList.entrySet()) {
			String key = entry.getKey().toString();
			Integer value = entry.getValue();
			System.out.println("Book Info: " + key + "Amount in Stock: " + value + "\n");
		}
	}

	// Displays books that are in stock
	public void displayBooksInStock() {
		System.out.println("==================== Library Books that are in stock ====================\n\n");
		for (Map.Entry<Book, Integer> entry : bookList.entrySet()) {
			String key = entry.getKey().toString();
			Integer value = entry.getValue();
			if (value > 0) {
				System.out.println("Book Info: " + key + "Amount in Stock: " + value + "\n");
			}
		}
	}

	public Book searchForBook() {
		System.out.println("Enter book name, author, or ID: ");
		String searchTerm = input.nextLine();

		// loops through all keys, returns the book if found
		for (Map.Entry<Book, Integer> entry : bookList.entrySet()) {
			Book temp = entry.getKey();
			if ((temp.getBookID().equals(searchTerm) || temp.getTitle().equals(searchTerm)
					|| temp.getAuthor().equals(searchTerm)) && entry.getValue() > 0)
				return temp;
		}
		return null;
	}

	public void login() throws IOException {
        User login = new User();
        login.loadUser();
        currentUser = login;
    }
	
	private void demo() throws IOException {
		String choice;

		System.out.println("Welcome to CSI Library!" + "\n");
		System.out.println("Please select one of the following: \n");
		System.out.println("====================Main Menu====================\n");
		System.out.println("Enter 1) Student");
		System.out.println("Enter 2) Librarian");
		System.out.println("Enter 3) Exit");

		choice = input.nextLine();

		switch (choice) {
		case "1":
			System.out.println("Welcome Student! Please login:");
			login();
			String studentUserName = currentUser.loginUser();
			
			//Checks a list of student userNames to see if the user has permission for student functions.
			if(currentUser.getStudentList().contains(studentUserName)) {
				menuMainStudent();
			} else {
				System.out.println("You are not a student. Please login again!");
				demo();
			}
			break;

		case "2":
			System.out.println("Welcome Librarian! Please login:");
			login();
			String librarianUserName = currentUser.loginUser();
			
			//Checks a list of librarian userNames to see if user has permission for these functions.
			if(currentUser.getLibrarianList().contains(librarianUserName)) {
				menuMainLibrarian();
			} else {
				System.out.println("You do not have sufficient privalages to access the librarian room");
				demo();
			}
			break;
		case "3":
			System.out.println("Exiting Library...");
			System.exit(0);
		default:
			System.out.println("Not a valid selection! Enter a valid selection!");
		}
	}

	public static void main(String[] args) throws IOException {

		Library library = new Library();
		library.demo();

		System.exit(0);
	}
}

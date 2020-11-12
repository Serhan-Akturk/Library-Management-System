package edu.cuny.csi.csc330.finalProject;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class User {

	private String userName;
	private String userPassword;
	private HashMap<String, String> userMap = new HashMap<String, String>(); // map for user login and password
	private HashMap<Book, Integer> borrowedBooks = new HashMap<Book, Integer>(); // map for student borrowed books
	private InputStreamReader reader = new InputStreamReader(System.in);
	private BufferedReader br = new BufferedReader(reader);
	private Scanner scan = new Scanner(System.in);
	//private List<String> studentAccountList = Arrays.asList("student");
	private List<String> studentAccountList = new ArrayList<String>();
	//private List<String> librarianAccountList = Arrays.asList("librarian");
	private List<String> librarianAccountList = new ArrayList<String>();
	
	public User()
	{
		
	}
	public void loadUser() {
		// This is to make sure we have something on file to start.
		userMap.put("student", "student123");
		userMap.put("librarian", "librarian123");
		
		//Keep track of user types so that user can log in their respective accounts.
		studentAccountList.add("student");
		librarianAccountList.add("librarian");
		
	}

	public String loginUser() throws IOException {
		System.out.println("Please enter username: ");
		userName = br.readLine();
		System.out.println("Please enter password: ");
		userPassword = br.readLine();

		String passwordInFile = userMap.get(userName);

		if (passwordInFile != null && passwordInFile.equals(userPassword)) {
			System.out.println("\n" + "Hello " + userName + "!");
		} else {
			System.out.println("Wrong username and/or password, try again\n");
			loginUser();		
		}
		return userName;
	}

	public void addUser() {
		System.out.print("Enter username to be added: ");
		userName = scan.nextLine();
		System.out.print("Enter password: ");
		userPassword = scan.nextLine();
		userMap.put(userName, userPassword);
		studentAccountList.add(userName);
		System.out.println(userName + " has been added to the system");
		System.out.println("map after add user " + userMap);
	}

	public void deleteUser() {
		System.out.print("Enter username to be deleted: ");
		userName = scan.nextLine();

		//Delete from the Array list that tracks the user types
		if (userMap.containsKey(userName)) {
			userMap.remove(userName);
			if(studentAccountList.contains(userName)) {
				studentAccountList.remove(userName);
			}
			if(librarianAccountList.contains(userName)) {
				librarianAccountList.remove(userName);
			}
			System.out.println(userName + " has been deleted from the system.");
		} else {
			System.err.println(userName + " not found in the system");
		}
		System.out.println("map after delete user " + userMap);
	}

	public void userBorrowBook(Book userBorrowBook) {
		if (borrowedBooks.containsKey(userBorrowBook)) {
			borrowedBooks.put(userBorrowBook, borrowedBooks.get(userBorrowBook) + 1);
		}
		else {
			borrowedBooks.put(userBorrowBook, 1);
		}
	}

	public boolean userReturnBook(Book userReturnBook) {
		if (borrowedBooks.containsKey(userReturnBook) && borrowedBooks.get(userReturnBook) > 0){
			borrowedBooks.put(userReturnBook, borrowedBooks.get(userReturnBook) - 1);
			if (borrowedBooks.get(userReturnBook) < 1)
				borrowedBooks.remove(userReturnBook);
		return true;
		}
		return false;
	}
	
	public List<String> getStudentList() {
		return studentAccountList;
	}
	
	public List<String> getLibrarianList() {
		return librarianAccountList;
	}
	
	public void getBorrowedBooks() {
		System.out.println("You have checked out the following book(s):");
		System.out.println(borrowedBooks);
	}


}
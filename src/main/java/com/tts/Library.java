package com.tts;

import java.util.ArrayList;
import java.util.List;

public class Library {
    public List<Book> books = new ArrayList<>();
    private final String address;

    public Library(String address) {
    this.address = address;
    }

    private void returnBook(String bookTitle) {
        for(Book book:books){
            if(book.getTitle().equalsIgnoreCase(bookTitle)) {
                if (book.isBorrowed()) {
                    book.returned();
                    System.out.printf("You successfully returned The %s\n", bookTitle);
                }
            }}
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void printAvailableBooks() {
        boolean empty=true;
        for(Book book: books){
            if(!book.isBorrowed()) {
                empty=false;
                System.out.println(book.getTitle());
            }
        }
        if(empty){
            System.out.println("No book in catalog ");
        }
    }

    private void borrowBook(String bookTitle) {
        boolean found=false;
        for(Book book:books){
            if(book.getTitle().equalsIgnoreCase(bookTitle) ){
                found=true;
                if(!book.isBorrowed() ){
                    book.borrowed();
                    System.out.printf("You successfully borrowed %S\n",bookTitle);
                    break;
                }
                else{
                    System.out.println("Sorry, this book is already borrowed.");
                }
            }}
        if(!found)
            System.out.println("Sorry, this book is not in our catalog.");
    }

    private void printAddress() {
        System.out.println(address);
    }

    private static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }

    public void addBook(Book book) {
        this.books.add(book);
    }






   // Add the missing implementation to this class


    public static void main(String[] args) {
        // Create two libraries



        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }


}





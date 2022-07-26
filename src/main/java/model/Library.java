package model;

import io.DataReader;

public class Library {
    private final int libraryCapacity = 1000;
    private Book[] books = new Book[libraryCapacity];
    private int booksNumber;

    private DataReader dataReader = new DataReader();

    public void addBook(Book book) {
        if (booksNumber < libraryCapacity) {
            books[booksNumber] = book;
            booksNumber++;
        } else
            System.err.println("Library capacity is full!");
    }

    public void printBooks() {
        if (booksNumber == 0)
            System.err.println("Library is empty now!");
        else {
            for (int i = 0; i < booksNumber; i++) {
                System.out.println(books[i]);
            }
        }
    }
}

package model;

import io.DataReader;

public class Library {
    private static final int libraryCapacity = 1000;
    private final Book[] books = new Book[libraryCapacity];
    private final Magazine[] magazines = new Magazine[libraryCapacity];
    private int booksNumber;
    private int magazinesNumber;

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
                System.out.println(books[i].printInfo());
            }
        }
    }

    public void addMagazine(Magazine magazine) {
        if (magazinesNumber < libraryCapacity) {
            magazines[magazinesNumber] = magazine;
            magazinesNumber++;
        } else
            System.err.println("Library capacity is full!");
    }

    public void printMagazines() {
        if (magazinesNumber == 0)
            System.err.println("Library is empty now!");
        else {
            for (int i = 0; i < magazinesNumber; i++) {
                System.out.println(magazines[i].printInfo());
            }
        }
    }
}

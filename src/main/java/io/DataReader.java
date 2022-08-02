package io;

import model.Book;
import model.Magazine;

import java.util.Scanner;

public class DataReader {
    Scanner input = new Scanner(System.in);

    public void close() {
        input.close();
    }

    public int nextInt() {
        int i = input.nextInt();
        input.nextLine();
        return i;
    }

    public Book readAndCreateBook() {
        System.out.println("Add a new book:");
        System.out.print("title:\t");
        String title = input.nextLine();
        System.out.print("author:\t");
            String author = input.nextLine();
        System.out.print("releaseDate:\t");
            int year = nextInt();
        System.out.print("pages:\t");
            int pages = nextInt();
        System.out.print("publisher:\t");
            String publisher = input.nextLine();
        System.out.print("isbn:\t");
            String isbn =  input.nextLine();
        System.out.println("The addition of a new book was successful.");
        return new Book(title, author, year, pages, publisher, isbn);
    }

    public Magazine readAndCreateMagazine() {
        System.out.println("Add a new Magazine:");
        System.out.print("title:\t");
        String title = input.nextLine();
        System.out.print("publisher:\t");
        String publisher = input.nextLine();
        System.out.print("year:\t");
        int year = nextInt();
        System.out.print("month:\t");
        int month = nextInt();
        System.out.print("day:\t");
        int day = nextInt();
        System.out.print("language:\t");
        String language =  input.nextLine();
        System.out.println("The addition of a new magazine was successful.");
        return new Magazine(title, publisher, year, month, day, language);
    }
}
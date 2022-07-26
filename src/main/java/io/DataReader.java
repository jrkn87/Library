package io;

import model.Book;

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
        Book book = new Book();
        System.out.println("Add a new book:");
        System.out.print("title:\t");
            book.setTitle(input.nextLine());
        System.out.print("author:\t");
            book.setAuthor(input.nextLine());
        System.out.print("releaseDate:\t");
            book.setReleaseDate(input.nextInt());
        System.out.print("pages:\t");
            book.setPages(input.nextInt());input.nextLine();
        System.out.print("publisher:\t");
            book.setPublisher(input.nextLine());
        System.out.print("isbn:\t");
            book.setIsbn(input.nextLine());
        return book;
    }
}
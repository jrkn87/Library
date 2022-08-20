package io;

import model.Book;
import model.Magazine;

import java.util.Scanner;

public class DataReader {
    Scanner input = new Scanner(System.in);
    ConsolePrinter printer;

    public DataReader(ConsolePrinter printer) {
        this.printer = printer;
    }

    public void close() {
        input.close();
    }

    public int nextInt() {
        try {
            return input.nextInt();
        } finally {
            input.nextLine();
        }
    }

    public Book readAndCreateBook() {
        printer.printLine("Add a new book:");
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
        printer.printLine("The addition of a new book was successful.");
        return new Book(title, author, year, pages, publisher, isbn);
    }

    public Magazine readAndCreateMagazine() {
        printer.printLine("Add a new Magazine:");
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
        printer.printLine("The addition of a new magazine was successful.");
        return new Magazine(title, publisher, year, month, day, language);
    }
}
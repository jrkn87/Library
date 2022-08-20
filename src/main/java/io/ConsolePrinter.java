package io;

import model.Book;
import model.Magazine;
import model.Publication;

public class ConsolePrinter {

    public void printBooks(Publication[] publications) {
        int count = 0;
        for (Publication publication : publications) {
            if (publication instanceof Book) {
                printLine(publication.printInfo());
                count++;
            }
        }
        if (count <= 0)
            printLine("Books list it's empty.");
    }

    public void printMagazine(Publication[] publications) {
        int count = 0;
        for (Publication publication : publications) {
            if (publication instanceof Magazine) {
                printLine(publication.printInfo());
                count++;
            }
        }
        if (count <= 0)
            printLine("Magazine list it's empty.");
    }

    public void printLine(String text) {
        System.out.println(text.toUpperCase());
    }
}

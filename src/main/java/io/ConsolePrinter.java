package io;

import io.file.FileType;
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

    public void printAllFileType() {
        for (FileType value : FileType.values()) {
            printOneLine(value.name());
        }
    }

    public void printLine(String text) {
        System.out.println(text.toUpperCase());
    }
    public void printOneLine(String text) {
        System.out.print("[ ");
        System.out.print(text.toUpperCase());
        System.out.print(" ]\n");
    }
}

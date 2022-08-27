package io.file;

import exception.ExportDataException;
import exception.ImportDataException;
import exception.InvalidFileTypeException;
import model.Book;
import model.Library;
import model.Magazine;
import model.Publication;

import java.io.*;
import java.util.Scanner;

public class CsvFileManager implements FileManager {
    private static final String FILE_NAME = "Library.csv";
    @Override
    public Library importData() {
        Library library = new Library();
        try(var scanner = new Scanner(new File(FILE_NAME))) {
            while(scanner.hasNextLine()) {
                String lineCsv = scanner.nextLine();
                String[] splitLine = lineCsv.split(";");
                if (splitLine[0].equals("Magazine")) {
                    library.addPublication(getMagazine(splitLine));
                } else if (splitLine[0].equals("Book")) {
                    library.addPublication(getBook(splitLine));
                } else
                    throw new InvalidFileTypeException("Invalid file type " + splitLine[0]);
            }
        } catch (FileNotFoundException e) {
            throw new ImportDataException("File not found " + FILE_NAME);
        }
        return library;
    }

    private Book getBook(String[] splitLine) {
        String title = splitLine[1];
        String author = splitLine[2];
        int year = Integer.parseInt(splitLine[3]);
        int pages =  Integer.parseInt(splitLine[4]);
        String publisher = splitLine[5];
        String isbn = splitLine[6];
        return new Book(title, author, year, pages, publisher, isbn);
    }

    private Magazine getMagazine(String[] splitLine) {
        String title = splitLine[1];
        String publisher = splitLine[2];
        int year = Integer.parseInt(splitLine[3]);
        int month =  Integer.parseInt(splitLine[4]);
        int day =  Integer.parseInt(splitLine[5]);
        String language = splitLine[6];
        return new Magazine(title, publisher, year, month, day, language);
    }

    @Override
    public void exportData(Library library) {
        try(
            var fw = new FileWriter(FILE_NAME);
            var bw = new BufferedWriter(fw)) {
            for (Publication publication : library.getPublications()) {
                bw.write(publication.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new ExportDataException("File is interrupted " + FILE_NAME);
        }
    }
}

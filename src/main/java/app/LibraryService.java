package app;

import exception.NoSuchOptionException;
import io.ConsolePrinter;
import io.DataReader;
import model.Library;

import java.util.InputMismatchException;

public class LibraryService {
    private Option option;
    private final Library library = new Library();
    private final ConsolePrinter printer = new ConsolePrinter();
    private final DataReader dataReader = new DataReader(printer);

    void loopControl() {
        do {
            printOption();
            option = getOption();

            switch (option) {
                case ADD_BOOK -> addBook();
                case ADD_MAGAZINE -> addMagazine();
                case PRINT_BOOKS -> printBooks();
                case PRINT_MAGAZINES -> printMagazines();
                case EXIT -> exit();
                default -> printer.printLine("There is no such option, try again.");
            }
        } while (option != Option.EXIT);

    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while (!optionOk) {
            try {
                option = Option.valueOfInt(dataReader.nextInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage());
            } catch (InputMismatchException e) {
                printer.printLine("This option is unavailable, try again:");
            }
        }
        return option;
    }

    private void exit() {
        printer.printLine("End of program, Bye!");
        dataReader.close();
    }

    private void addBook() {
        try {
            library.addBook(dataReader.readAndCreateBook());
        } catch (InputMismatchException e) {
            printer.printLine("Error data, please try again.");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Library is full.");
        }
    }

    private void addMagazine() {
        try {
            library.addMagazine(dataReader.readAndCreateMagazine());
        } catch (InputMismatchException e) {
            printer.printLine("Error data, please try again.");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Library is full.");
        }
    }

    private void printBooks() {
        printer.printBooks(library.getPublications());
    }

    private void printMagazines() {
        printer.printMagazine(library.getPublications());
    }

    private void printOption() {
        printer.printLine("Options: ");
        for (Option option : Option.values()) {
            printer.printLine(option.toString());
        }
    }
}

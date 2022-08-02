package app;

import io.DataReader;
import model.Library;

public class LibraryService {
    private static final int EXIT = 0;
    private static final int ADD_BOOK = 1;
    private static final int ADD_MAGAZINE = 2;
    private static final int PRINT_BOOKS = 3;
    private static final int PRINT_MAGAZINES = 4;
    private int option = -1;
    private final Library library = new Library();
    private final DataReader dataReader = new DataReader();

    void loopControl() {
        do {
            printOption();
            option = dataReader.nextInt();

            switch(option) {
                case ADD_BOOK -> addBook();
                case ADD_MAGAZINE -> addMagazine();
                case PRINT_BOOKS -> printBooks();
                case PRINT_MAGAZINES -> printMagazines();
                case EXIT -> exit();
                default -> System.out.println("There is no such option, try again.");
            }
        } while(option != 0);

    }

    private void exit() {
        System.out.println("End of program, Bye!");
        dataReader.close();
    }

    private void addBook() {
        library.addBook(dataReader.readAndCreateBook());
    }
    private void addMagazine() {
        library.addMagazine(dataReader.readAndCreateMagazine());
    }

    private void printBooks() {
        library.printBooks();
    }
    private void printMagazines() {
        library.printMagazines();
    }

    private void printOption() {
        System.out.println("Options: ");
        System.out.println(ADD_BOOK + " add new book");
        System.out.println(ADD_MAGAZINE + " add new magazine");
        System.out.println(PRINT_BOOKS + " print all books");
        System.out.println(PRINT_MAGAZINES + " print all magazines");
        System.out.println(EXIT + " exit");
    }
}

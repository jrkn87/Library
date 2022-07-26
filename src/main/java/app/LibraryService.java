package app;

import io.DataReader;
import model.Library;

public class LibraryService {
    private final int EXIT = 0;
    private final int ADD_BOOK = 1;
    private final int PRINT_BOOKS = 2;
    private int option = -1;
    private Library library = new Library();
    private DataReader dataReader = new DataReader();

    void loopControl() {
        do {
            printOption();
            option = dataReader.nextInt();

            switch(option) {
                case ADD_BOOK -> addBook();
                case PRINT_BOOKS -> printBooks();
                case EXIT -> exit();
                default -> {
                    System.out.println("There is no such option, try again.");
                    dataReader.close();
                }
            }
        } while(option != 0);

    }

    private void exit() {
        System.out.println("End of program, Bye!");
    }

    private void addBook() {
        library.addBook(dataReader.readAndCreateBook());
    }

    private void printBooks() {
        library.printBooks();
    }

    private void printOption() {
        System.out.println("Options: ");
        System.out.println(ADD_BOOK + " add new book");
        System.out.println(PRINT_BOOKS + " print all books");
        System.out.println(EXIT + " exit");
    }
}

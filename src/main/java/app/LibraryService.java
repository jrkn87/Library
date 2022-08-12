package app;

import io.DataReader;
import model.Library;

public class LibraryService {
    private Option option;
    private final Library library = new Library();
    private final DataReader dataReader = new DataReader();

    void loopControl() {
        do {
            printOption();
            option = Option.valueOfInt(dataReader.nextInt());

            switch(option) {
                case ADD_BOOK -> addBook();
                case ADD_MAGAZINE -> addMagazine();
                case PRINT_BOOKS -> printBooks();
                case PRINT_MAGAZINES -> printMagazines();
                case EXIT -> exit();
                default -> System.out.println("There is no such option, try again.");
            }
        } while(option != Option.EXIT);

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
        for (Option option : Option.values()) {
            System.out.println(option);
        }
    }
}

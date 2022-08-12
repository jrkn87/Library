package app;

public enum Option {
    EXIT(0,"exit application"),
    ADD_BOOK(1, "add new book"),
    ADD_MAGAZINE(2,"add new magazine"),
    PRINT_BOOKS(3,"print all books"),
    PRINT_MAGAZINES(4,"print all magazines");

    private int option;
    private String description;

    Option(int option, String description) {
        this.option = option;
        this.description = description;
    }

    public int getOption() {
        return option;
    }

    public String getDescription() {
        return description;
    }

    public static Option valueOfInt(int i) {
        return values()[i];
    }

    @Override
    public String toString() {
        return option + " - " + description;
    }
}

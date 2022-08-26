package model;

import java.io.Serializable;

public class Library implements Serializable {
    private static final int libraryCapacity = 1000;
    private final Publication[] publications = new Publication[libraryCapacity];
    private int publicationSize;

    public Publication[] getPublications() {
        Publication[] result = new Publication[publicationSize];
        for (int i = 0; i < publicationSize; i++) {
            result[i] = publications[i];
        }
        return result;
    }

    public void addBook(Book book) {
        addPublication(book);
    }

    public void addMagazine(Magazine magazine) {
        addPublication(magazine);
    }

    private void addPublication(Publication publication) {
        if (publicationSize == libraryCapacity)
            throw new ArrayIndexOutOfBoundsException();

        publications[publicationSize] = publication;
        publicationSize++;
    }
}

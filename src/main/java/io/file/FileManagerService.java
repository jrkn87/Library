package io.file;

import exception.FileTypeException;
import io.ConsolePrinter;
import io.DataReader;

public class FileManagerService {
    private ConsolePrinter printer;
    private DataReader reader;

    public FileManagerService(ConsolePrinter printer, DataReader reader) {
        this.printer = printer;
        this.reader = reader;
    }

    public FileManager build() {
        printer.printLine("Select file type:");
        return switch(getFileTypeFromUser()){
            case SERIAL -> new SerializableFileManager();
            case CSV -> new CsvFileManager();
            default -> throw new FileTypeException("This type its not implemented yet.");
        };
    }

    public FileType getFileTypeFromUser() {
        FileType fileType = null;
        boolean isTypeOk = false;
        while(!isTypeOk) {
            try {
                printer.printAllFileType();
                fileType =  FileType.valueOf(reader.nextString().toUpperCase());
                isTypeOk = true;
            } catch(IllegalArgumentException e) {
                printer.printLine("Wrong file type. Try again.");
            }
        }
        return fileType;
    }
}

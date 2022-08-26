package io.file;

import exception.ExportDataException;
import exception.ImportDataException;
import model.Library;

import java.io.*;

public class SerializableFileManager implements FileManager{
    private static final String FILE_NAME = "Library.o";

    @Override
    public Library importData() {
        try(
                var fio = new FileInputStream(FILE_NAME);
                var ois = new ObjectInputStream(fio);
                ){
            return (Library)ois.readObject();
        } catch (FileNotFoundException e) {
            throw new ImportDataException("File not found " + FILE_NAME);
        } catch (IOException e) {
            throw new ImportDataException("File is interrupted " + FILE_NAME);
        } catch (ClassNotFoundException e) {
            throw new ImportDataException("File type is incorrectly");
        }
    }

    @Override
    public void exportData(Library library) {
        try(
                var fos = new FileOutputStream(FILE_NAME);
                var oos = new ObjectOutputStream(fos);
                ) {
            oos.writeObject(library);
        } catch (FileNotFoundException e) {
            throw new ExportDataException("File not found " + FILE_NAME);
        } catch (IOException e) {
            throw new ExportDataException("File is interrupted " + FILE_NAME);
        }
    }
}

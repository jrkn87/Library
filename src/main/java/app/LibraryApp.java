package app;

public class LibraryApp {
    final static String APP_VER = "Library [v1.8]";
    public static void main(String[] args) {
        System.out.println(APP_VER);
        System.out.println("[---]");
        new LibraryService().loopControl();
    }
}

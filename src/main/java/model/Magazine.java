package model;

public class Magazine extends Publication {
    private static final String FILE_TYPE = "Magazine";
    private int month;
    private int day;
    private String language;

    public Magazine(String title, String publisher, int year, int month, int day, String language) {
        super(title, publisher, year);
        this.month = month;
        this.day = day;
        this.language = language;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toCsv() {
        return FILE_TYPE + ";"
                +getTitle() + ";"
                +getPublisher() + ";"
                +getYear() + ";"
                +month + ";"
                +day + ";"
                +language;
    }

    public String printInfo() {
        return super.toString()
                + "\', month: \'" + this.month
                + "\', day: \'" + this.day
                + "\', language: \'" + this.language + "\'}";
    }
}

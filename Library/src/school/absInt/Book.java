package school.absInt;

public class Book extends Template implements Repair {

    private String name;
    private String author;
    private int pages;
    private int durability;
    private int year;
    private boolean lended;

    public Book(String name, String author, int pages, int durability, int year) {
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.durability = durability;
        this.year = year;
        this.lended = false; // Bude vždy false ,protože když přidáme knížku tak ještě není přece půjčena
    }
}

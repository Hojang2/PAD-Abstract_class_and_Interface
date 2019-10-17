package school.absInt;

public class Diary extends Template implements Repair {
    private String name;
    private String author;
    private int pages;
    private int durability;
    private boolean lended;

    public Diary(String name, String author, int pages, int durability) {
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.durability = durability;
        this.lended = false;
    }
}

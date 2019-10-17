package school.absInt;

public class Magasine extends Template implements Repair {

    private String name;
    private String author;
    private int pages;
    private int durability;
    private boolean lended;


    public Magasine(String name, String author, int pages){
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.durability = 100;
        this.lended = false;
    }
}

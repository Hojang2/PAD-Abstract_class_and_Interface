package school.absInt;

public class Magasine extends Template implements Repair {

    String name;
    String author;
    int cislo;
    int pages;
    private int durability;
    boolean lended;


    public Magasine(String name, String author, int cislo, int pages, int durability, int year){
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.cislo = cislo;
        this.durability = durability;
        this.lended = false;
    }
    public void repairProduct(){
        this.durability = 100;
        System.out.println("Magasine was repaired");
    }
    public boolean checkProduct(){
        return durability > 0;
    }
}

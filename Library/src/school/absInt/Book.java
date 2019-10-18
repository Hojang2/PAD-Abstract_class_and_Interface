package school.absInt;

public class Book extends Template implements Repair {

    String name;
    String author;
    int pages;
    private int durability;
    int year;
    boolean lended;

    public Book(String name, String author, int pages, int durability, int year) {
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.durability = durability;
        this.year = year;
        this.lended = false; // Bude vždy false ,protože když přidáme knížku tak ještě není přece půjčena
    }
    public void repairProduct(){
        this.durability += 30;
        if(this.durability > 100){
            this.durability = 100;
        }
        System.out.println("Book was repaired");
    }
    public boolean checkProduct(){
        return durability > 0;
    }

    @Override
    public String toString() {
        return  "\n===============================================================" +
                "\nKniha " + name +
                "\nAutor: " + author +
                "\nRok vydání: " + year +
                "\nPočet stran: " + pages +
                "\nStav(%): " + durability + "%" +
                "\nPujčena: " + lended +
                "\n===============================================================";
    }
}

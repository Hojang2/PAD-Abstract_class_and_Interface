package school.absInt;

public class Diary extends Template implements Repair {
    String name;
    String author;
    int pages;
    private int durability;
    boolean lended;

    public Diary(String name, String author, int pages, int durability) {
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.durability = durability;
        this.lended = false;
    }

    public void repairProduct(){
        this.durability += 10;
        if(this.durability > 100){
            this.durability = 100;
        }
        System.out.println("Diary was repaired");
    }

    public boolean checkProduct(){
        return durability > 0;
    }

    @Override
    public String toString() {
        return  "\n===============================================================" +
                "\nDiář " + name +
                "\nAutor: " + author +
                "\nPočet stran: " + pages +
                "\nStav(%): " + durability + "%" +
                "\nPujčena: " + lended +
                "\n===============================================================";
    }
}

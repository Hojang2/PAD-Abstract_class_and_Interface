package school.absInt;

public class Book extends Template {

    private int maxDurability;
    private int minDurability;

    public Book(String name, String author, int pages, String ISBN, int durability){
        super(name, author, pages, ISBN, durability);
        this.maxDurability = 150;
        this.minDurability = 0;
    }

    public void repairProduct(){

        if (this.durability <= this.maxDurability - 30){
            this.durability += 30;
        } else {
            this.durability += this.maxDurability - this.durability;
        }
        System.out.println("Magasine was repaired");
    }

    public boolean checkProduct(){
        return this.durability > minDurability;
    }

    public boolean lendProduct(){
        if (this.checkProduct()){
            this.durability -= 20;
            return true;
        } else {
            System.out.println("This Book is broken, you can't lend it.");
            return false;
        }
    }
    public boolean returnProduct(){
        System.out.println(String.format("Product %s was returned", this.name));
        return true;
    }
}

package school.absInt;

public class Diary extends Template {
    private int maxDurability;
    private int minDurability;

    public Diary(String name, String author, int pages, String ISBN, int durability){
        super(name, author, pages, ISBN, durability);
        this.maxDurability = 100;
        this.minDurability = 0;
    }

    public void repairProduct(){

        if (this.durability <= this.maxDurability - 20){
            this.durability += 20;
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
            this.durability -= 10;
            return true;
        } else {
            System.out.println("This Diary is broken, you can't lend it.");
            return false;
        }
    }
    public boolean returnProduct(){
        System.out.println(String.format("Product %s was returned", this.name));
        return true;
    }
}

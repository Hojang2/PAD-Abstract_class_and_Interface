package school.absInt;

import java.util.ArrayList;

public class Reader{
    int id;
    static int count = 1;
    private String name;
    private ArrayList<Template> lendedBooks;

    public Reader(String name){
        this.id = count;
        this.name = name;
        this.lendedBooks = new ArrayList<Template>();
        count++;
    }
    public boolean lendProduct(Template product){
        if (product.lendProduct()){
            this.lendedBooks.add(product);
            return true;
        }
        return false;
    }

    public boolean returnProduct(String ISBN){
        for (Template product: this.lendedBooks){
            if (product.ISBN == ISBN){
                this.lendedBooks.remove(product);
                return true;
            }
        }
        return false;

    }
    public String toString(){
        return String.format("id:\t%d name:\t%s", this.id, this.name);
    }

    public ArrayList<Template> getLendedBooks() {
        return this.lendedBooks;
    }
}

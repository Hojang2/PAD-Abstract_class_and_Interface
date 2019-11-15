package school.absInt;

import java.io.Serializable;

public abstract class Template implements  Repair, Lend, Serializable{

    protected String name;
    protected String author;
    protected int pages;
    protected String ISBN;
    protected int durability;

    abstract public void repairProduct();
    abstract public boolean checkProduct();
    abstract public boolean lendProduct();
    abstract public boolean returnProduct();
    public Template(String name, String author, int pages, String ISBN, int durability){
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.ISBN = ISBN;
        this.durability = durability;
    }

    @Override
    public String toString() {
        return String.format("name: %s author: %s pages: %d durability: %d", name, author, pages, durability);
    }


}

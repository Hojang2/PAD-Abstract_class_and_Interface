package school.absInt;

import java.util.ArrayList;

public class Library{
    private String name;
    private ArrayList<Reader> readers;
    private ArrayList<Template> deposite;
    private ArrayList<Template> avalible;
    public Library(String name){
        this.name = name;
        this.readers = new ArrayList<Reader>();
        this.deposite = new ArrayList<Template>();
        this.avalible = new ArrayList<Template>();

    }
    public void addReader(Reader person){
        this.readers.add(person);
    }
    public void removeReader(Reader person){
        this.readers.remove(person);
    }
    public void addPublication(Template publication){
        this.deposite.add(publication);
        this.avalible.add(publication);
    }
    public void removePublication(Template publication){
        this.deposite.remove(publication);
        this.avalible.remove(publication);
    }
    public void lendProduct(Reader reader, String ISBN){
        for (Template product: this.avalible){
            if (product.ISBN == ISBN){
                if (reader.lendProduct(product)){
                    this.avalible.remove(product);
                    break;
                }
            }
        }
    }
    public void returnProduct(Reader reader, String ISBN) {
        if (reader.returnProduct(ISBN)) {
            for (Template product : this.deposite) {
                if (product.ISBN == ISBN) {
                    this.avalible.add(product);
                    break;

                }
            }
        }
    }
    public String getAvalible(){
        String tmp = "";
        for (Template t: this.avalible){
            tmp += t.ISBN + "\n";
        }
        return tmp;
    }


}
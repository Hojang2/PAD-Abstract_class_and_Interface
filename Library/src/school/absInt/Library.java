package school.absInt;

import java.io.IOException;
import java.util.ArrayList;
import java.io.Serializable;

public class Library{
    private String name;
    private ArrayList<LibraryReader> readers;
    private ArrayList<Template> deposite;
    private ArrayList<Template> avalible;
    public Library(String name){
        this.name = name;
        this.readers = new ArrayList<LibraryReader>();
        this.deposite = new ArrayList<Template>();
        this.avalible = new ArrayList<Template>();

    }

    public void addReader(LibraryReader person){
        this.readers.add(person);
    }
    public void removeReader(LibraryReader person){
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

    public void lendProduct(LibraryReader reader, String ISBN){
        for (Template product: this.avalible){
            if (product.ISBN == ISBN){
                if (reader.lendProduct(product)){
                    this.avalible.remove(product);
                    break;
                }
            }
        }
    }

    public void returnProduct(LibraryReader reader, String ISBN) {
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

    public String getLen(){
        String tmp = "";
        tmp += this.readers.size() + "\n";
        tmp += this.deposite.size() + "\n";
        tmp += this.avalible.size() + "\n";
        return tmp;
    }

    public void serialization(String dirLoc){
        dirLoc += "/" + this.name;
        try {
            SerializationLibrary.serializeReaders(this.readers, dirLoc + "/readers.ser");
            SerializationLibrary.serializeProducts(this.deposite, dirLoc + "/deposit.ser");
            SerializationLibrary.serializeProducts(this.avalible, dirLoc + "/avalible.ser");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

    }
    public void deserialization(String dirLoc)
    {
        try {
            this.readers = SerializationLibrary.deserializeReaders(dirLoc + "/readers.ser");
            this.deposite = SerializationLibrary.deserializeProducts(dirLoc + "/deposit.ser");
            this.avalible = SerializationLibrary.deserializeProducts(dirLoc + "/avalible.ser");
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

}
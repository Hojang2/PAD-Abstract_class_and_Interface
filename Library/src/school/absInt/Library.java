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
    public void serialization(String readersOut, String depositeOut, String avaliableOut){
        try {
            SerializationLibrary.serializeReaders(this.readers, readersOut);
            SerializationLibrary.serializeProducts(this.deposite, depositeOut);
            SerializationLibrary.serializeProducts(this.avalible, avaliableOut);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

    }
    public void deserialization(String readersSrc, String depositeSrc, String avaliableSrc)
    {
        try {
            this.readers = SerializationLibrary.deserializeReaders(readersSrc);
            this.deposite = SerializationLibrary.deserializeProducts(depositeSrc);
            this.avalible = SerializationLibrary.deserializeProducts(avaliableSrc);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }


}
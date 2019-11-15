package school.absInt;

import java.io.*;
import java.util.ArrayList;

class SerializieLibrary {


    // serialize the given object and save it to file
    public static void serializeReaders(ArrayList<LibraryReader> readers, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (LibraryReader reader : readers) {
            oos.writeObject(reader);
        }
        fos.close();
    }
    public static void serializeProducts(ArrayList<Template> products, String fileName) throws IOException {
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for (Template product : products) {
            oos.writeObject(product);
        }
        fos.close();
    }

    // deserialize to Object from given file
    public static ArrayList<LibraryReader> deserializeReaders(String fileName) throws IOException, ClassNotFoundException {
        ArrayList<LibraryReader> obj = new ArrayList<LibraryReader>();
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object o = null;
        try {
            for (int i=0; i<10; i++) {
                o = ois.readObject();
                obj.add((LibraryReader) o);
            }
        } catch(EOFException e) {
            fis.close();
        }
        return obj;
    }

    public static ArrayList<Template> deserializeProducts(String fileName) throws IOException, ClassNotFoundException {
        ArrayList<Template> obj = new ArrayList<Template>();
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object o = null;
        try {
            for (int i=0; i<10; i++) {
                o = ois.readObject();
                obj.add((Template) o);
            }
        } catch(EOFException e) {
            fis.close();
        }
        return obj;
    }
}
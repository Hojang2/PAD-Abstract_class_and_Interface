package school.absInt;

public class Main {

    public static void main(String[] args) {
        Library lib = new Library("My Library");

        Reader r1 = new Reader("Tom");
        Reader r2 = new Reader("Adam");
        lib.addReader(r1);
        lib.addReader(r2);

        Magasine m = new Magasine("Computer", "Computer Press", 148, "1210-8790", 70);
        Book b = new Book("Hobit", "J.R.R. Tolkien", 300, "978-80-257-1949-7", 40);

        lib.addPublication(m);
        lib.addPublication(b);
        lib.addPublication(b);
        System.out.println(lib.getAvalible());

        lib.lendProduct(r1, "1210-8790");
        lib.lendProduct(r2, "1210-8790");
        lib.lendProduct(r1, "978-80-257-1949-7");
        System.out.println(lib.getAvalible());

        lib.returnProduct(r1, "1210-8790");
        lib.returnProduct(r2, "978-80-257-1949-7");
        System.out.println(lib.getAvalible());

        lib.returnProduct(r2, "978-80-257-1949-7");
        System.out.println(lib.getAvalible());
    }
}

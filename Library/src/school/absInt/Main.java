package school.absInt;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Library lib = new Library("Nase knihiovna");

        lib.addItem(1);
        lib.addItem(3);

        System.out.println(lib);

        lib.showInventory(1);

        lib.showBook(0);

        lib.addItem(2);
        lib.addItem(3);

        lib.lendBook("RUR","Karel_Čapek");

        lib.showBook(0);
    }
}

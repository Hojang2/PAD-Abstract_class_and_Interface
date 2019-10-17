package school.absInt;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library implements Lend{

    List<Book> invOfBooks = new ArrayList<Book>();
    List<Magasine> invOfMagasines = new ArrayList<Magasine>();
    List<Diary> invOfDiaries = new ArrayList<Diary>();

    private String nameOfLibrary;

    public Library(String nameOfLibrary) {
        this.nameOfLibrary = nameOfLibrary;
        System.out.println("Byla vytvořena knihovna " + nameOfLibrary);
        System.out.println("===============================================================");
    }

    @Override
    public String toString() {
        return "\n===============================================================" +
                "Knihovna " + nameOfLibrary +
                "\nPočet knih: " + invOfBooks +
                "\nPočet časopisů: " + invOfMagasines +
                "\nPočet Diářu: " + invOfDiaries +
                "\n===============================================================";
    }

    // 1. Book
    // 2. Magasine
    // 3. Diary
    public void showInventory(int Type){
        switch (Type){
            case 1:
                System.out.println("\n===============================================================");
                System.out.println("Inventář knih: " + getInvOfBooks());
                System.out.println("===============================================================");
                break;

            case 2:
                System.out.println("\n===============================================================");
                System.out.println("Inventář časopisů: " + getInvOfMagasines());
                System.out.println("===============================================================");
                break;

            case 3:
                System.out.println("\n===============================================================");
                System.out.println("Inventář diářů: " + getInvOfDiaries());
                System.out.println("===============================================================");
                break;
        }
    }

    // 1. Book
    // 2. Magasine
    // 3. Diary
    public void addItem(int Type){
        switch (Type){
            case 1:
                addBook();
                break;

            case 2:
                addMagasine();
                break;

            case 3:
                addDiary();
                break;
        }
    }

    private void addBook(){
        String name;
        String author;
        int pages;
        int durability;
        int year;
        Scanner input = new Scanner(System.in);

        System.out.println("/n===============================================================");

        System.out.println("Zadejte název knihy: ");
        name = input.next();

        System.out.println("Zadejte jméno autora: ");
        author = input.next();

        System.out.println("Zadejte rok vydání: ");
        year = input.nextInt();

        System.out.println("Zadejte počet stran: ");
        pages = input.nextInt();

        durability = 0;
        while(durability<=0 && durability>100) {
            System.out.println("Zadejte v jakém stavu je kniha(max 100): ");
            durability = input.nextInt();
            System.out.print("%");
        }

        Book kniha = new Book(name, author, pages, durability, year);
        invOfBooks.add(kniha);

        System.out.println("===============================================================/n");
        System.out.println("Byla přidána kniha " + name);
        System.out.println("Autor: " + author);
        System.out.println("Rok: " + year);
        System.out.println("Počet stran: " + pages);
        System.out.println("Stav(v %): " + durability);
        System.out.println("/n===============================================================");
    }

    private void addMagasine(){
        String name;
        String author;
        int cislo;
        int pages;
        int durability;
        int year;
        Scanner input = new Scanner(System.in);

        System.out.println("/n===============================================================");

        System.out.println("Zadejte název časopisu: ");
        name = input.next();

        System.out.println("Zadejte jméno Nakladatel: ");
        author = input.next();

        System.out.println("Zadejte číslo časopisu: ");
        cislo = input.nextInt();

        System.out.println("Zadejte rok vydání: ");
        year = input.nextInt();

        System.out.println("Zadejte počet stran: ");
        pages = input.nextInt();

        durability = 0;
        while(durability<=0 && durability>100) {
            System.out.println("Zadejte v jakém stavu je časopis(max 100): ");
            durability = input.nextInt();
            System.out.print("%");
        }


        Magasine casopis = new Magasine(name, author, cislo, pages, durability, year);
        invOfMagasines.add(casopis);

        System.out.println("===============================================================/n");
        System.out.println("Byl přidán časopis " + name);
        System.out.print(" č. " + cislo);
        System.out.println("Nakldatelství: " + author);
        System.out.println("Rok: " + year);
        System.out.println("Počet stran: " + pages);
        System.out.println("Stav(v %): " + durability);
        System.out.println("/n===============================================================");
    }

    private void addDiary(){
        String name;
        String author;
        int pages;
        int durability;
        Scanner input = new Scanner(System.in);

        System.out.println("/n===============================================================");

        System.out.println("Zadejte název diáře: ");
        name = input.next();

        System.out.println("Zadejte jméno autora: ");
        author = input.next();

        System.out.println("Zadejte počet stran: ");
        pages = input.nextInt();

        durability = 0;
        while(durability<=0 && durability>100) {
            System.out.println("Zadejte v jakém stavu je diář(max 100): ");
            durability = input.nextInt();
            System.out.print("%");
        }


        Diary diar = new Diary(name, author, pages, durability);
        invOfDiaries.add(diar);

        System.out.println("===============================================================/n");
        System.out.println("Byl přidán diář " + name);
        System.out.println("Autor: " + author);
        System.out.println("Počet stran: " + pages);
        System.out.println("Stav(v %): " + durability);
        System.out.println("/n===============================================================");
    }

    public List<Book> getInvOfBooks() {
        return invOfBooks;
    }

    public List<Magasine> getInvOfMagasines() {
        return invOfMagasines;
    }

    public List<Diary> getInvOfDiaries() {
        return invOfDiaries;
    }
}

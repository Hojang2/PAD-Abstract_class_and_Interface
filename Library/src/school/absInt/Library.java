package school.absInt;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library implements Lend{

    List<Book> invOfBooks = new ArrayList<Book>();
    List<Magasine> invOfMagasines = new ArrayList<Magasine>();
    List<Diary> invOfDiaries = new ArrayList<Diary>();

    private final String nameOfLibrary;

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
    public boolean returnBook(String name, String author) {
        /*  Zadávání operandů ručně
        String name;
        String author;
        Scanner input = new Scanner(System.in);

        System.out.println("Zadej název knihy: ");
        name = input.next();

        System.out.println("Zadej jméno autora: ");
        author = input.next();
        */
        for (Book book : this.invOfBooks) {
            if (name == book.name && author == book.author) {
                if (book.lended) {
                    book.lended = false;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean returnMagasine(String name, String author) {
        /*  Zadávání operandů ručně
        String name;
        String author;
        Scanner input = new Scanner(System.in);

        System.out.println("Zadej název knihy: ");
        name = input.next();

        System.out.println("Zadej jméno autora: ");
        author = input.next();
        */
        for (Magasine magasine : this.invOfMagasines) {
            if (name == magasine.name && author == magasine.author) {
                if (magasine.lended) {
                    magasine.lended = false;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean returnDiary(String name, String author) {
        /*  Zadávání operandů ručně
        String name;
        String author;
        Scanner input = new Scanner(System.in);

        System.out.println("Zadej název knihy: ");
        name = input.next();

        System.out.println("Zadej jméno autora: ");
        author = input.next();
        */
        for (Diary diary : this.invOfDiaries) {
            if (name == diary.name && author == diary.author) {
                if (diary.lended) {
                    diary.lended = false;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean lendBook(String name, String author) {
        /*  Zadávání operandů ručně
        String name;
        String author;
        Scanner input = new Scanner(System.in);

        System.out.println("Zadej název knihy: ");
        name = input.next();

        System.out.println("Zadej jméno autora: ");
        author = input.next();
        */
        for (Book book : this.invOfBooks) {
            if (name == book.name && author == book.author) {
                if (!book.lended) {
                    book.lended = true;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean lendMagasine(String name, String author) {
        /*  Zadávání operandů ručně
        String name;
        String author;
        Scanner input = new Scanner(System.in);

        System.out.println("Zadej název knihy: ");
        name = input.next();

        System.out.println("Zadej jméno autora: ");
        author = input.next();
        */
        for (Magasine magasine : this.invOfMagasines) {
            if (name == magasine.name && author == magasine.author) {
                if (!magasine.lended) {
                    magasine.lended = true;
                    return true;
                }
            }
        }
        return false;
    }
    public boolean lendDiary(String name, String author) {
        /*  Zadávání operandů ručně
        String name;
        String author;
        Scanner input = new Scanner(System.in);

        System.out.println("Zadej název knihy: ");
        name = input.next();

        System.out.println("Zadej jméno autora: ");
        author = input.next();
        */
        for (Diary diary : this.invOfDiaries) {
            if (name == diary.name && author == diary.author) {
                if (!diary.lended) {
                    diary.lended = true;
                    return true;
                }
            }
        }
        return false;
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

    public void showBook(int id){
        System.out.println(invOfBooks.get(id));
    }

    public void showMagasine(int id){
        System.out.println(invOfMagasines.get(id));
    }

    public void showDiary(int id){
        System.out.println(invOfDiaries.get(id));
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
        String author = "";
        int pages;
        int durability;
        int year;
        Scanner input = new Scanner(System.in);

        System.out.println("\n===============================================================");

        System.out.println("Zadejte název knihy: ");
        name = input.next();

        System.out.println("Zadejte jméno autora: ");
        author = input.next();

        System.out.println("Zadejte rok vydání: ");
        year = input.nextInt();

        System.out.println("Zadejte počet stran: ");
        pages = input.nextInt();

        durability = 0;
        while(durability<=0 || durability>100) {
            System.out.println("Zadejte v jakém stavu je kniha(max 100): ");
            durability = input.nextInt();
            System.out.print("%");
        }

        Book kniha = new Book(name, author, pages, durability, year);
        invOfBooks.add(kniha);

        System.out.println("===============================================================\n");
        System.out.println("Byla přidána kniha " + name);
        System.out.println("Autor: " + author);
        System.out.println("Rok: " + year);
        System.out.println("Počet stran: " + pages);
        System.out.println("Stav(v %): " + durability);
        System.out.println("\n===============================================================");
    }

    private void addMagasine(){
        String name;
        String author;
        int cislo;
        int pages;
        int durability;
        int year;
        Scanner input = new Scanner(System.in);

        System.out.println("\n===============================================================");

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
        while(durability<=0 || durability>100) {
            System.out.println("Zadejte v jakém stavu je časopis(max 100): ");
            durability = input.nextInt();
            System.out.print("%");
        }


        Magasine casopis = new Magasine(name, author, cislo, pages, durability, year);
        invOfMagasines.add(casopis);

        System.out.println("===============================================================\n");
        System.out.println("Byl přidán časopis " + name);
        System.out.print(" č. " + cislo);
        System.out.println("Nakldatelství: " + author);
        System.out.println("Rok: " + year);
        System.out.println("Počet stran: " + pages);
        System.out.println("Stav(v %): " + durability);
        System.out.println("\n===============================================================");
    }

    private void addDiary(){
        String name;
        String author;
        int pages;
        int durability;
        Scanner input = new Scanner(System.in);

        System.out.println("\n===============================================================");

        System.out.println("Zadejte název diáře: ");
        name = input.next();

        System.out.println("Zadejte jméno autora: ");
        author = input.next();

        System.out.println("Zadejte počet stran: ");
        pages = input.nextInt();

        durability = 0;
        while(durability<=0 || durability>100) {
            System.out.println("Zadejte v jakém stavu je diář(max 100): ");
            durability = input.nextInt();
            System.out.print("%");
        }


        Diary diar = new Diary(name, author, pages, durability);
        invOfDiaries.add(diar);

        System.out.println("===============================================================\n");
        System.out.println("Byl přidán diář " + name);
        System.out.println("Autor: " + author);
        System.out.println("Počet stran: " + pages);
        System.out.println("Stav(v %): " + durability);
        System.out.println("\n===============================================================");
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

    public boolean lendProduct(String name, String author, String type) {
        boolean answ = false;

        /* Zadávání operandů ručně
        String name;
        String author;
        Scanner input = new Scanner(System.in);

        System.out.println("Zadej název knihy: ");
        name = input.next();

        System.out.println("Zadej jméno autora: ");
        author = input.next();

        System.out.println("Zadej typ produktu: ");
        type = input.next();
        */

        switch (type){
            case "book":
                answ = lendBook(name, author);
                break;
            case "magasine":
                answ = lendMagasine(name, author);
                break;
            case "diary":
                answ = lendDiary(name, author);
                break;
        }
        return answ;
    }
    public boolean returnProduct(String name, String author, String type) {
        boolean answ = false;
        switch (type){
            case "book":
                answ = returnBook(name, author);
                break;
            case "magasine":
                answ = returnMagasine(name, author);
                break;
            case "diary":
                answ = returnDiary(name, author);
                break;
        }
        return answ;
    }

}

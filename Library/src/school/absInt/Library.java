package school.absInt;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library implements Lend{

    List<Book> invOfBooks = new ArrayList<Book>();
    List<Magasine> invOfMagasines = new ArrayList<Magasine>();
    List<Diary> invOfDiaries = new ArrayList<Diary>();

    // 1. Kniha
    // 2. Magasine
    // 3. Diary
    public void addItem(int Type){
        switch (Type){
            case 1:

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

        System.out.println("Zadejte název knihy: ");
        name = input.next();

    }

}

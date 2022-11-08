import javax.accessibility.AccessibleContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class UserInterface {
    Controller controller;
    Scanner sc;

    public UserInterface() {
        controller = new Controller();
        sc = new Scanner(System.in);
        controller.loadFile();
    }

    public void menuText(){
        System.out.println("""
                \nMenu:
                1. add
                2. show
                3. search
                4. edit
                5. delete
                9. exit program""");
    }

    public void startMenu(){
        boolean isRunning = true;
        while(isRunning) {
            menuText();
            switch (readInteger()) {
                case 1 -> addHero();
                case 2 -> showHero();
                case 3 -> searchHero();
                case 4 -> editHero();
                case 5 -> deleteHero();
                case 9 -> {System.out.println("Exiting program");isRunning = false;controller.saveHeroToFile();}
                default -> System.out.println("No menu choice available");
            }
        }
    }

    public void addHero(){
        System.out.println("Add hero information:");
        System.out.print("Hero-name: ");
        String heroName = readString();

        System.out.print("Civil-name: ");
        String civilName = readString();

        System.out.print("Superpower: ");
        String heroPower = readString();

        System.out.print("Hero-age: ");
        int heroAge = readInteger();
        controller.addHero(heroName,civilName,heroPower,heroAge);
    }

    public void sortHeroesByChoiceOne(){
        sortHeroesMenu();
        switch (readInteger()){
            case 1 -> controller.sortChoice("heroName");
            case 2 -> controller.sortChoice("civilName");
            case 3 -> controller.sortChoice("heroPower");
            case 4 -> controller.sortChoice("heroAge");
            default -> controller.sortChoice("heroName");
        }
        controller.testCompare1();
        sortHeroesByChoiceTwo();
    }

    public void sortHeroesByChoiceTwo(){
        sortSecondaryChoice();
        int choice = readInteger();
        if(choice == 1){
            sortHeroesMenu();
            switch (readInteger()) {
                case 1 -> controller.getNewChoice("heroName");
                case 2 -> controller.getNewChoice("civilName");
                case 3 -> controller.getNewChoice("heroPower");
                case 4 -> controller.getNewChoice("heroAge");
                default -> controller.getNewChoice("heroname");
            }
            controller.testCompare2();
        }
    }

    public void showHero() {
        sortHeroesByChoiceOne();
        System.out.println("Superheros in database:");
        if(!controller.getSuperheroes().isEmpty()){
            controller.getSuperheroes().forEach(System.out :: println);
        } else {
            System.out.println("Database is empty...");
        }
    }

    public void searchHero() {
        System.out.print("Search word: ");
        String searchWord = readString();

        ArrayList<Superhero> foundHero = controller.searchHero(searchWord);
        if(!foundHero.isEmpty()){
            System.out.println("Found: ");
            foundHero.forEach(System.out :: println);
        } else {
            System.out.println("No hero found...");
        }
    }

    public void editHero() {
        System.out.println("Function not integrated yet...");
    }
    public void deleteHero() {
        System.out.println("Function not integrated yet...");
    }

    public int readInteger(){
        while(!sc.hasNextInt()){
            System.out.println("Choice not a available. Choose again");
            sc.next();
        }
        return sc.nextInt();
    }

    public String readString(){
        String input = sc.next();
        sc.nextLine();
        return input;
    }

    public void sortHeroesMenu(){
        System.out.println("""
                Sort heroes by:
                1. Hero-name
                2. Civil-name
                3. Hero-power
                4. Hero-age""");
    }

    public void sortSecondaryChoice(){
        System.out.println("""
                Add a secondary sorting attribute?
                1. yes
                2. no""");
    }
}


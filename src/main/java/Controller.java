import java.util.ArrayList;
import java.util.Collections;

public class Controller {
    Database database;
    FileHandler fileHandler;
    AllComparator allComparator;
    AllComparator newChoice;
    boolean editDone = false;

    public Controller(){
        database = new Database();
        fileHandler = new FileHandler();
        allComparator = new AllComparator();
        newChoice = new AllComparator();
    }

    public void addHero(String heroName, String civilName, String heroPower, int heroAge) {
        editDone = true;
        database.addHero(heroName,civilName,heroPower,heroAge);
    }

    public ArrayList<Superhero> getSuperheroes(){
        return database.getSuperheroes();
    }

    public ArrayList<Superhero> searchHero(String searchWord){
        return database.searchHero(searchWord);
    }

    public void saveHeroToFile(){
        if(editDone){
            fileHandler.saveToFile(getSuperheroes());
        }
    }
    public void loadFile(){
        database.loadHeroFile(fileHandler.loadFile());
    }

    public void sortChoice(String attributeChoice){
        allComparator.setAttribute(attributeChoice);
    }

    public void compareOne(){
        Collections.sort(getSuperheroes(), allComparator);
    }

    public void getNewChoice(String choice) {
        newChoice.setAttribute(choice);
    }

    public void compareTwo() {
        Collections.sort(getSuperheroes(), allComparator.thenComparing(newChoice));
    }


}

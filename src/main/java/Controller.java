import java.util.ArrayList;
import java.util.Collections;

public class Controller {
    private Database database;
    private FileHandler fileHandler;
    private AllComparator allComparator;
    private AllComparator newChoice;
    private boolean editDone = false;

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
    public void deleteHero(int remove) {
        editDone = true;
        database.deleteHero(remove);
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

    public void setChoice(String attributeChoice){
        allComparator.setAttribute(attributeChoice);
    }

    public void compareOne(){
        Collections.sort(getSuperheroes(), allComparator);
    }

    public void setNewChoice(String choice) {
        newChoice.setAttribute(choice);
    }

    public void compareTwo() {
        Collections.sort(getSuperheroes(), allComparator.thenComparing(newChoice));
    }


}

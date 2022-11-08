import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private File file = new File("src/main/data/superhero.csv");

    public void saveToFile(ArrayList<Superhero> superheroes){
        try {
            PrintStream output = new PrintStream(file);
            for(Superhero hero : superheroes) {
                output.println(hero.getHeroName()+','+
                                hero.getCivilName()+','+
                                hero.getHeroPower()+','+
                                hero.getAge());
            }
            output.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException("You fucked up!");
        }
    }

    public ArrayList<Superhero> loadFile(){
        ArrayList<Superhero> loadedFile = new ArrayList<>();
        try {
            Scanner reader = new Scanner(file);
            while(reader.hasNext()) {
                String textLines = reader.nextLine();
                String[] attributes = textLines.split(",");
                Superhero superhero = new Superhero(attributes[0],
                                                    attributes[1],
                                                    attributes[2],
                                                    Integer.parseInt(attributes[3]));
                                                    loadedFile.add(superhero);

            }
            reader.close();
            return loadedFile;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

import java.util.ArrayList;

public class Database {
    private ArrayList<Superhero> superheroes = new ArrayList<>();

    public ArrayList<Superhero> getSuperheroes(){
        return superheroes;
    }

    public void loadHeroFile(ArrayList<Superhero> superheroes) {
        this.superheroes = superheroes;
    }

    public void addHero(String heroName, String civilName, String heroPower, int heroAge) {
        superheroes.add(new Superhero(heroName,civilName,heroPower,heroAge));
    }

    public ArrayList<Superhero> searchHero(String searchWord){
        ArrayList<Superhero> foundHero = new ArrayList<>();

        for(Superhero superhero : superheroes) {
            if(superhero.getHeroName().contains(searchWord)) {
                foundHero.add(superhero);
            } else if(superhero.getCivilName().contains(searchWord)) {
                foundHero.add(superhero);
            } else if(superhero.getHeroPower().contains(searchWord)) {
                foundHero.add(superhero);
            } else if(Integer.toString(superhero.getAge()).contains(searchWord)) {
                foundHero.add(superhero);
            }
        }
        return foundHero;
    }

}

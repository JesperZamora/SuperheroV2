import java.util.Comparator;

public class AllComparator implements Comparator<Superhero> {
    private String attribute;

    public void setAttribute(String attributeChoice){
        this.attribute = attributeChoice;
    }

    public int compare(Superhero s1, Superhero s2) {
        int result = 0;

        if(attribute.equals("heroName")) {
            result = s1.getHeroName().compareTo(s2.getHeroName());

        } else if(attribute.equals("civilName")){
            result = s1.getCivilName().compareTo(s2.getCivilName());

        } else if(attribute.equals("heroPower"))  {
            result = s1.getHeroPower().compareTo(s2.getHeroPower());

        } else if (attribute.equals("heroAge")) {
            result = Integer.compare(s1.getAge(),s2.getAge());
        }
        return result;
    }
}

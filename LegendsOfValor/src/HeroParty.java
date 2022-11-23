import java.util.ArrayList;
// the heroes which has been selected by the player
public class HeroParty {

    //hero party
    private ArrayList<Hero> heroParty;

    public void init(){
        HeroList heroList = new HeroList();

//        int heroNum = 1;
        int heroNum = Helper.getIntInput("How many heroes do you want to choose?",3);

        System.out.println("Please select " + heroNum + " heroes to build your team!");
        // display hero list


        while (heroParty.size()<heroNum){
            int chosen;
            System.out.println(heroList);
            chosen = Helper.getIntInput("Which hero do you want to choose?",heroList.getHeroList().size());
            heroParty.add(heroList.getHeroList().get(chosen));

        }


//        heroParty.add(heroList.getHeroList().get(16));

        System.out.println("Hero party is all set");
        System.out.println("Here it is ");

        System.out.println(this);
    }

    public HeroParty(){
        heroParty = new ArrayList<>();
    }

    public ArrayList<Hero> getHeroParty() {
        return heroParty;
    }

    @Override
    public String toString() {

        String ret = "";


        int num = 1;
        System.out.println("Hero Information");
        System.out.println("+-------------------------------------------------------------------------------------------------------------------+");
        System.out.println("No |        Name      |   HP   |  Level  |   Strength   |  Agility  | Dexterity | Money | experience | Type | Status");
        System.out.println("+------------------------------------------------------------------------------------------------------------------+");
        for (Hero h : heroParty) {
            System.out.printf("%-4s ", (num++));
            System.out.printf("%-16s", h.getName());
            System.out.printf("%-8s", h.getHp());
            System.out.printf("%-8s", h.getLevel());
            System.out.printf("%-10s", h.getStren());
            System.out.printf("%-10s", h.getAgi());
            System.out.printf("%-11s", h.getDex());
            System.out.printf("%-12s", h.getMoney());
            System.out.printf("%-10s", h.getExp());
            System.out.printf("%-10s", h.getType());
            System.out.printf("%-10s", h.getwheFaint());
            System.out.println();

            if (h.getArmor() != null) {
                System.out.println("Here is the Armors it has.");
                System.out.println(h.getArmor());
            } else {
//                System.out.println("It has no Armor at all!");
            }

            if (h.getWeap() != null) {
                System.out.println("Here is the Weapons it has.");
                System.out.println(h.getWeap());
            } else {
//                System.out.println("It has no Weapon at all!");
            }
        }

        System.out.println("+------------------------------------------------------------------------------------------------------------------+");


        return ret;
    }
}

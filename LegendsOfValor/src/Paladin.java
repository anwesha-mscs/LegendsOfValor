public class Paladin extends Hero{


    public Paladin(String name, int level, int defense, int mana, int strength, int agility, int dexterity, int money, int exp) {
        super(name, level, defense, mana, strength, agility, dexterity, money, exp);

        type = "paladin";

    }

    @Override
    public void levelUp() {
        super.levelUp();

        strength = (int) Math.round(strength *1.3);
        agility = (int) Math.round(agility *1.3);
        dexterity = (int) Math.round(dexterity *1.1);

    }
}

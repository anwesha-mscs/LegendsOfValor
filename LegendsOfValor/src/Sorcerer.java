public class Sorcerer extends Hero{

    public Sorcerer(String name, int level, int defense, int mana, int strength, int agility, int dexterity, int money, int exp) {
        super(name, level, defense, mana, strength, agility, dexterity, money, exp);

        type = "sorcerer";

    }

    @Override
    public void levelUp() {
        super.levelUp();
        stren = (int) Math.round(stren *1.1);
        agi = (int) Math.round(agi *1.3);
        dex = (int) Math.round(dex *1.3);
    }
}

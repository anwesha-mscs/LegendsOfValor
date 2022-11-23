public class Warrior extends Hero{

    public Warrior(String name, int level, int defense, int mana, int strength, int agility, int dexterity, int money, int exp) {
        super(name, level, defense, mana, strength, agility, dexterity, money, exp);

        type = "warrior";

    }

    @Override
    public void levelUp() {
        super.levelUp();
        stren = (int) Math.round(stren *1.3);
        agi = (int) Math.round(agi *1.1);
        dex = (int) Math.round(dex *1.3);
    }
}

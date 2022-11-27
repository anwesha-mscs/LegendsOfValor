public class HeroFactory {
    public static Hero getHero(String heroType, String name, int mana, int strength, int agility, int dexterity, int money, int exp){
        if(heroType == null){
            return null;
        }
        if(heroType.equalsIgnoreCase("Warriors.csv")){
            return new Warrior(name, exp/10 + 1, 0, mana, strength, agility, dexterity, money, exp);

        } else if(heroType.equalsIgnoreCase("Paladins.csv")){
            return new Paladin(name, exp/10 + 1, 0, mana, strength, agility, dexterity, money, exp);

        } else if(heroType.equalsIgnoreCase("Sorcerers.csv")){
            return new Sorcerer(name, exp/10 + 1, 0, mana, strength, agility, dexterity, money, exp);
        }
        return null;
    }
}

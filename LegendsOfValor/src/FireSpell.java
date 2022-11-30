public class FireSpell extends Spell{

    public FireSpell(String name, int pri, int reqLevel, int damage, int mana){
        super(name, pri, reqLevel,damage,mana);
        type = "fire";
    }

    @Override
    public String toString() {
        System.out.printf("%-20s",getName());
        System.out.printf("%-10s",getPrice());
        System.out.printf("%-10s",getLevel());
        System.out.printf("%-10s",getDamage());
        System.out.printf("%-10s",getManaCost());
        System.out.printf("%-10s","fire");
        return "";
    }
}

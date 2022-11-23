public class FireSpell extends Spell{

    public FireSpell(String na, int pri, int reqL, int dmg, int m){
        super(na, pri, reqL,dmg,m);
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

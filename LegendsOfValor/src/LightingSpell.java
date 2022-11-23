public class LightingSpell extends Spell{

    public LightingSpell(String na, int pri, int reqL, int dmg, int m){
        super(na, pri, reqL,dmg,m);
        type = "lighting";
    }

    @Override
    public String toString() {

        System.out.printf("%-20s",getName());
        System.out.printf("%-10s",getPrice());
        System.out.printf("%-10s",getLevel());
        System.out.printf("%-10s",getDamage());
        System.out.printf("%-10s",getManaCost());
        System.out.printf("%-10s","lighting");
        return "";
    }
}

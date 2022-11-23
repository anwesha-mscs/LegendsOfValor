//class weapon for the weapon which hero can use
public class Weapon extends Item {

    // the damage it can help hero to strengthen
    private int damage;

    // the hand needed to use such weapon
    private int haNe;

    // constructor
    public Weapon(String na, int pri, int reqL, int dmg, int hn){
        super(na, pri, reqL);
        damage = dmg;
        haNe = hn;
    }

    //getter and setter below

    public int getDamage() {return damage;}

    public int getHaNe() {return haNe;}

    public void setDamage(int damage) {this.damage = damage;}

    public void setHaNe(int haNe) {this.haNe = haNe;}

    // override the weapon
    @Override
    public String toString() {

        String con="";
        System.out.printf("%-20s",getName());
        System.out.printf("%-10s",getPrice());
        System.out.printf("%-10s",getLevel());
        System.out.printf("%-10s",getDamage());
        System.out.printf("%-12s", getHaNe());
        return con;
    }
}
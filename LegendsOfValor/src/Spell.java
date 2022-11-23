// the class spell for storing it's method and attribute
public abstract class Spell extends Item {

    // maybe we should try enum here (fire/ice/lighting)
    protected String type;

    private int damage;

    // mana it will cost
    private int manaCost;

    // constructor
    public Spell(String na, int pri, int reqL, int dmg, int m){
        super(na, pri, reqL);
        damage = dmg;
        manaCost = m;
    }

    //getter and setter below
    public String getType() {return type;}

    public int getDamage() {return damage;}

    public int getManaCost() {return manaCost;}

    public void setType(String type) {this.type = type;}

    public void setDamage(int damage) {this.damage = damage;}

    public void setManaCost(int manaCost) {this.manaCost = manaCost;}


    @Override
    public String toString() {

        System.out.printf("%-20s",getName());
        System.out.printf("%-10s",getPrice());
        System.out.printf("%-10s",getLevel());
        System.out.printf("%-10s",getDamage());
        System.out.printf("%-10s",getManaCost());
        System.out.printf("%-10s",getType());
        return "";
    }
}
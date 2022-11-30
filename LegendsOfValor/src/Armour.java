// armour which can helps to defend and reduce damage
public class Armour extends Item {
    public Armour(){}

    //the reduction coefficient
    private int reductionRate;

    // constructor
    public Armour(String name, int price, int reqLevel, int damage_reduction){
        super(name, price, reqLevel);
        reductionRate = damage_reduction;
    }

    // get the reduction value
    public int getReductionRate() {return reductionRate;}

    // set the reduction value
    public void setReductionRate(int reductionRate) {this.reductionRate = reductionRate;}


    // print itself
    @Override
    public String toString() {

        System.out.printf("%-20s",getName());
        System.out.printf("%-10s",getPrice());
        System.out.printf("%-10s",getLevel());
        System.out.printf("%-10s", getReductionRate());
        return "";

    }
}

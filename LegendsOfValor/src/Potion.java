// the potion can be used to strengthen the hero
public class Potion extends Item {

    private String attr;

    //value of the potion
    private int val;

    // constructor
    public Potion(String na, int pri, int reqL, int v, String at){
        super(na, pri, reqL);
        attr = at;
        val = v;
    }

    // getter and setter below

    public String getAttr() {return attr;}

    public int getVal() {return val;}

    public void setAttr(String attr) {this.attr = attr;}

    public void setVal(int val) {this.val = val;}



    @Override
    public String toString() {
        System.out.printf("%-20s",getName());
        System.out.printf("%-10s",getPrice());
        System.out.printf("%-10s",getLevel());
        System.out.printf("%-10s", getVal());
        System.out.printf("%-10s", getAttr());
        return "";

    }
}
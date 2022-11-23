//a single unit to form the whole map for the extensibility
public class MapUnit implements Cloneable{

    // store the map type here
    private char t;       //' ' is nothing 'X' is obstacle  'M' is the market  'P' is the hero party

    public MapUnit(char content){
        t = content;
    }

    public char getT(){
        return t;
    }

    public void setT(char t){
        this.t = t;
    }

    // to accomplish the clone for the grid
    @Override
    protected Object clone() {

        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "MapUnit{" +
                t +
                '}'+hashCode();
    }

}
//a single unit to form the whole map for the extensibility
public class MapUnit implements Cloneable{

    // store the map type here
    private char type;       //' ' is nothing 'X' is obstacle  'M' is the market  'P' is the hero party
    //'B' is bush  'C' is Cave 'K' is Koulou  "N" for monster nexus 'n' for hero nexus

    public MapUnit(char content){
        type = content;
    }

    public char getType(){
        return type;
    }

    public void setType(char type){
        this.type = type;
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
                type +
                '}'+hashCode();
    }

}
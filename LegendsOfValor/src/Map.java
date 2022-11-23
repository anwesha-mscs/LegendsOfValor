import java.util.Random;
// the whole map contains a grid  and contains the current location of the hero party
public class Map extends Grid {

    //no one can change my grid
    protected final MapUnit[][] FINAL_GRID;

    // the probability to generate Obstacle is defined here
    private static final double ObsG = 0.2;

    // the probability to generate a market
    private static final double MarkeG = 0.3;

    private final Random ran ;

    //party location -x
    private int xCord;

    //party location -y
    private int yCord;


    //getter and setter below
    public int getxCord() {return xCord;}

    public int getyCord() {return yCord;}

    public void setxCord(int xCord){this.xCord = xCord;}

    public void setyCord(int yCord) {this.yCord = yCord;}

    public Map(int boardSize) {
        super(boardSize);
        ran = new Random();
        init();
        FINAL_GRID = cloneGrid(grid);

    }


    // Initialize the map of the whole game
    public MapUnit[][] init(){

            int i = ran.nextInt(charNum);

            int sha = i/size;
            int der = i%size;

                setxCord(sha);
                setyCord(der);

        setUpMap();

        grid[sha][der].setT(' ');

                return grid;
    }


    // if I don't reset the idiotic grid then the market will not be able to enter again
    public MapUnit[][] resetIdioticGrid(){

        grid = cloneGrid(FINAL_GRID);
        return grid;
    }



    // set up the distribution of none empty object
    public MapUnit[][] setUpMap(){
        int m = (int) (charNum* MarkeG);
        int counter = 0;
        while(counter<m){
            int i = ran.nextInt(size );
            int j = ran.nextInt(size );


            if (grid[i][j].getT() != 'M'){
                grid[i][j].setT('M');
                counter ++;
            }

        }

        int n = (int) (charNum* ObsG);
        counter = 0;
        while(counter< n){
            int i = ran.nextInt(size);
            int j = ran.nextInt(size);
            if (grid[i][j].getT() != 'X' && counter < n){
                grid[i][j].setT('X');
//                grid[i][j].setDis('X');
                counter ++;
            }

        }

        return grid;
    }

    // I believe this is a deep clone
    public MapUnit[][] cloneGrid(MapUnit[][] gr){
        MapUnit[][] iterGrid = new MapUnit[gr.length][gr[0].length];
            for (int x = 0; x < gr.length; x++) {
                for (int y = 0; y < gr[x].length; y++) {
                    iterGrid[x][y] = (MapUnit) gr[x][y].clone();
                }
            }
        return iterGrid;
    }


    // to display the whole map to the player
    @Override
    public String
    toString() {

        System.out.println("The party are now locating at: " + "(" + xCord + "," + yCord + ")" );
        System.out.println("The world of play: ");


        //to indicate where the party is using "Pointer"
        for (int poin = 0; poin < size; poin++) {
            if (yCord == poin){
                System.out.print("  | ");
                break;
            }else {
                System.out.print("    ");

            }

        }
        System.out.println();

        for (int poin = 0; poin < size; poin++) {
            if (yCord == poin){

                System.out.print("  V ");
                break;
            }else {
                System.out.print("    ");

            }

        }
        System.out.println();


        for (int i = 0; i < this.size; ++i) {
            System.out.print("+---");
        }
        System.out.println("+");



        for (int i = 0; i < this.size; ++i) {
            System.out.print("|");
            for (int j = 0; j < this.size; ++j){
                if(xCord == i && yCord ==j){
                    System.out.print(" P |");
                }else {
                    System.out.print(" " + this.FINAL_GRID[i][j].getT() + " |");
                }
            }

            if (i == xCord){

                System.out.print(" <---");
            }
            System.out.println();
            for (int k = 0; k < this.size; ++k) {
                System.out.print("+---");
            }
            System.out.println("+");
        }
        return "";
    }
}

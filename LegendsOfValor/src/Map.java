import java.util.ArrayList;
import java.util.Random;
// the whole map contains a grid  and contains the current location of the hero party
public class Map extends Grid {

    //no one can change my grid
    protected final MapUnit[][] FINAL_GRID;

    public MapUnit[][] getFINAL_GRID() {
        return FINAL_GRID;
    }

    // the probability to generate Obstacle is defined here
    private static final double ObsG = 0.2;

    // the probability to generate a market
    private static final double MarkeG = 0.3;

    private final Random ran;

    //party location -x
    private int xCord;

    //party location -y
    private int yCord;


    // Role list which contains of all of the monster and hero
    private ArrayList<Role> roles;

    //hero list
    private ArrayList<Hero> heroes;
    private ArrayList<Monster> monsters;


    //getter and setter below
//    public int getxCord() {return xCord;}

//    public int getyCord() {return yCord;}

//    public void setxCord(int xCord){this.xCord = xCord;}

//    public void setyCord(int yCord) {this.yCord = yCord;}

    public Map(int boardSize, ArrayList<Role> ro,ArrayList<Hero> he,ArrayList<Monster> mon) {
        super(boardSize);
        ran = new Random();
        roles = ro;
        monsters = mon;
        heroes  = he;
        init();
        FINAL_GRID = cloneGrid(grid);

    }


    // Initialize the map of the whole game
    public MapUnit[][] init() {


        int xyCor[] = getEmptyLocation();
//        setxCord(xyCor[0]);
//        setyCord(xyCor[1]);

//        setUpMap();
        fillInaccessField();

        fillinNexus();

        generateSpecialTerrain('C');
        generateSpecialTerrain('K');
        generateSpecialTerrain('B');


//        grid[sha][der].setT(' ');

        return grid;
    }

    public MapUnit[][] generateSpecialTerrain(char te) {
        int amout = (int) (charNum - 16 - 12);
        amout = (int) (amout * 0.2);

        for (int am = 0; am < amout; am++) {
            int xys[] = getEmptyLocation();
            grid[xys[0]][xys[1]].setType(te);
        }


        return grid;
    }

    public int[] getEmptyLocation() {

        int xy[] = new int[2];

        do {
            int i = ran.nextInt(charNum);

            xy[0] = i / size;
            xy[1] = i % size;
//            System.out.println("random i:"+i);

//            System.out.println("Type:" + grid[xy[0]][xy[1]].getType());

        } while (grid[xy[0]][xy[1]].getType() != ' ');


        return xy;
    }


    // if I don't reset the idiotic grid then the market will not be able to enter again
    public MapUnit[][] resetIdioticGrid() {

        grid = cloneGrid(FINAL_GRID);
        return grid;
    }

    public MapUnit[][] fillInaccessField() {
        fillInaccessColumn(2);
        fillInaccessColumn(5);
        return grid;

    }

    public MapUnit[][] fillInaccessColumn(int c) {
        for (int i = 0; i < 8; i++) {
            grid[i][c].setType('X');

        }
        return grid;

    }


    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public ArrayList<Role> setHasRoleField(){
        for (Hero hero : heroes) {
            grid[hero.x][hero.y].setHasHero(true);
        }

        for (Monster monster : monsters) {
            grid[monster.x][monster.y].setHasMoster(true);

        }



        return roles;
    }

    public MapUnit[][] fillinNexus() {
        for (int i = 0; i < 8; i++) {
            if (i % 3 != 2) {
                grid[0][i].setType('N');
                grid[7][i].setType('n');
            }

        }
        return grid;

    }


    // set up the distribution of none empty object
    public MapUnit[][] setUpMap() {
        int m = (int) (charNum * MarkeG);
        int counter = 0;
        while (counter < m) {
            int i = ran.nextInt(size);
            int j = ran.nextInt(size);


            if (grid[i][j].getType() != 'M') {
                grid[i][j].setType('M');
                counter++;
            }

        }

        int n = (int) (charNum * ObsG);
        counter = 0;
        while (counter < n) {
            int i = ran.nextInt(size);
            int j = ran.nextInt(size);
            if (grid[i][j].getType() != 'X' && counter < n) {
                grid[i][j].setType('X');
//                grid[i][j].setDis('X');
                counter++;
            }

        }

        return grid;
    }

    // I believe this is a deep clone
    public MapUnit[][] cloneGrid(MapUnit[][] gr) {
        MapUnit[][] iterGrid = new MapUnit[gr.length][gr[0].length];
        for (int x = 0; x < gr.length; x++) {
            for (int y = 0; y < gr[x].length; y++) {
                iterGrid[x][y] = (MapUnit) gr[x][y].clone();
            }
        }
        return iterGrid;
    }

    public int displayMonsterOrHero() {


        for (int i = 0; i < this.size; ++i) {
            System.out.print("+---");
        }
        System.out.println("+");


        //modify here to display all the monster and hero
        for (int i = 0; i < this.size; ++i) {
            System.out.print("|");
            for (int j = 0; j < this.size; ++j) {
//                if(xCord == i && yCord ==j){
//                    System.out.print(" P |");
//                }else {
//                    System.out.print(" " + this.FINAL_GRID[i][j].getType() + " |");
//                }

                boolean hasDis = false;

                if (grid[i][j].isHasHero()) {
                    System.out.print(" " + "H" + " |");
                } else if (grid[i][j].isHasMoster()) {
                    System.out.print(" " + "M" + " |");
                }else {
                    System.out.print(" " + " " + " |");

                }



                //  new code
//                for (Role role : roles) {
//                    if (role.getX() == i && role.getY() == j) {
//                        System.out.print(" " + role.getDis() + " |");
//                        hasDis = true;
//                    } else {
//                    System.out.print(" " + this.FINAL_GRID[i][j].getType() + " |");
//                    }
//                }

                // -- new code ended

//                if (!hasDis) {
//                    System.out.print(" " + this.FINAL_GRID[i][j].getType() + " |");
//                    hasDis = false;
//                }


            }

//            if (i == xCord){

//                System.out.print(" <---");
//            }
            System.out.println();
            for (int k = 0; k < this.size; ++k) {
                System.out.print("+---");
            }
            System.out.println("+");
        }
//        return "";


//        for (int i = 0; i < this.size; ++i) {
//            System.out.print("|");
//            for (int j = 0; j < this.size; ++j) {
//
//                if (grid[i][j].isHasHero()) {
//                    System.out.print(" " + "H" + " |");
//                } else if (grid[i][j].isHasMoster()) {
//                    System.out.print(" " + "M" + " |");
//                }else {
//                    System.out.print(" " + " " + " |");
//
//                }
//
//
//
//            }
//
//        }


        return charNum;
    }

    public String drawOneBorder(int row){
        String border="";

        for (int col = 0; col < size; col++) {

            char type=grid[row][col].getType();
            type = type == ' ' ? 'P' :type;
            type = type == 'X' ? 'I' :type;

            border += type;
            border += " - ";
            border += type;
            border += " - ";
            border += type;
//            border += " - ";
            border += "  ";

        }


        return border;
    }

    public String fillContent(int row){

        String content="";



        for (int col = 0; col < size; col++) {

            content+="| ";


            if(grid[row][col].getType() == 'X'){
                content+="X X X";
                content+=" |  ";

//                return content;

            }else {
                String buffer="      ";

                for (Hero hero : heroes) {
                    if(hero.getX() == row && hero.getY() == col){
                        buffer = buffer.replaceFirst("  ","H"+hero.getDis());
                    }
                }

                for (Monster mon : monsters) {
                    if(mon.getX() == row && mon.getY() == col){
//                        System.out.println(mon.getDis());
                        buffer = buffer.replaceFirst("(.{3})  ","$1M"+mon.getDis());
                    }
                }

//            buffer

                content+=buffer;



                content+="|  ";

            }



        }



        return content;
    }





    // to display the whole map to the player
    @Override
    public String
    toString() {

        System.out.println("The world of play: ");

//
//        System.out.println();
//
////        for (int poin = 0; poin < size; poin++) {
////            if (yCord == poin){
////
////                System.out.print("  V ");
////                break;
////            }else {
////                System.out.print("    ");
////
////            }
////
////        }
////        System.out.println();
//
//
//        for (int i = 0; i < this.size; ++i) {
//            System.out.print("+---");
//        }
//        System.out.println("+");
//
//
//        //modify here to display all the monster and hero
//        for (int i = 0; i < this.size; ++i) {
//            System.out.print("|");
//            for (int j = 0; j < this.size; ++j){
////                if(xCord == i && yCord ==j){
////                    System.out.print(" P |");
////                }else {
////                    System.out.print(" " + this.FINAL_GRID[i][j].getType() + " |");
////                }
//
//                boolean hasDis = false;
//
//
//                //  new code
//                for (Role role : roles) {
//                    if(role.getX() == i && role.getY() == j){
//                        System.out.print(" "+role.getDis()+" |");
//                        hasDis = true;
//                    }
//                }
//
//                // -- new code ended
//
//                if (!hasDis) {
//                    System.out.print(" " + this.FINAL_GRID[i][j].getType() + " |");
//                }
//
//
//            }
//
////            if (i == xCord){
//
////                System.out.print(" <---");
////            }
//            System.out.println();
//            for (int k = 0; k < this.size; ++k) {
//                System.out.print("+---");
//            }
//            System.out.println("+");
//        }

        //alex version of cmd display here


       // System.out.println("Alex lll here");

        for (int r = 0; r < size; r++) {
            System.out.println(drawOneBorder(r));
//            System.out.println();
            System.out.println(fillContent(r));
            System.out.println(drawOneBorder(r));
            System.out.println();
        }

























        return "";
    }
}

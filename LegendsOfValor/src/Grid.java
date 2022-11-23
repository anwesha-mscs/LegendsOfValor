//abstract class grid instruct map to create
public abstract class Grid {

    protected int size;

    // map unit is only a character but if I defined a new class for higher extensibility
    protected MapUnit[][]  grid;

    protected int charNum;

    //to create a lot of grid to back up
    protected MapUnit[][] iterGrid;


    // constructor
    public Grid(int s){
        size = s;
        boardInit(s);
        charNum = size*size;
    }

    public int getSize() {return size;}

    public void setSize(int size){
        this.size = size;
    }

    public MapUnit[][] getGrid(){
        return this.grid;
    }

    // initialize the grid    First fill it with empty MapUnit
    public void boardInit(int boardSize){
        grid = new MapUnit[boardSize][boardSize];
        for(int i = 0; i < boardSize; i++){
            for(int j = 0; j < boardSize; j++){
                grid[i][j] = new MapUnit(' ');
            }
        }
    }
}


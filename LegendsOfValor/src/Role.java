//all movable object belongs to a role (Monster and hero)

public abstract class Role {

	protected String name;

	//current HP
	protected int hp;

	// max hp
	protected int maxHP;

	protected int level;

	//defence
	protected int def;
	protected static Map map;
	protected static Market market;


	// save it location in its class
	protected int x;
	protected int y;


	// the lane it belongs to
	protected int laneOri;

	// the lane it current in
	// count from 1      1,2,3
	protected int laneCurr;

	//to differentiate  display on  the map
	private static int num = 0;

	// the character to be displayed on the map
	private char dis;


	// to describe whether the role has faint
	protected boolean wheFaint;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getLaneOri() {
		return laneOri;
	}

	public void setLaneOri(int laneOri) {
		this.laneOri = laneOri;
	}

	public static int getNum() {
		return num;
	}

	public static void setNum(int num) {
		Role.num = num;
	}

	public static void increaseNum() {
		num++;
	}

	public char getDis() {
		return dis;
	}

	public void setDis(char dis) {
		this.dis = dis;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public Role(String na, int le, int de)
	{
//		num ++;
		//		dis = (char) (num+50);

		name = na;
		level = le;
		maxHP = hp = (level*100);
		def = de;
		wheFaint = false;
	}

	public boolean readyToDisplay(int xLoc,int yLoc){
		num++;
		x=xLoc;
		y = yLoc;
		dis = (char) (num+48);
		laneCurr = laneOri = y/3  +1;
		System.out.println("Set lane :"+dis+"lane" +laneCurr);

		return true;
	}

	public void connectMap(Map m,Market mar){
		map = m;
		market = mar;
		System.out.println("after connect map: " +m);
	}



	@Override
	public String toString() {
		return "Role{" +
				"name='" + name + '\'' +
				", hp=" + hp +
				", level=" + level +
				", def=" + def +
				", wheFaint=" + wheFaint +
				'}';
	}

	//getter and setter below

	public String getName() {return name;}

	public int getLevel() {return level;}

	public int getHp() {return hp;}

	public int getDef() {return def;}

	public boolean getwheFaint() {return wheFaint;}

	public boolean setWheFaint( boolean whe) {wheFaint = whe;return wheFaint;}

	public void setName(String name) {
		this.name = name;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void setDef(int def) {this.def = def;}

	public void becomeFaint() {
		wheFaint = true;
	}

}

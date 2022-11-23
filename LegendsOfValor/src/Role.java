//all movable object belongs to a role (Monster and hero)

public abstract class Role {

	protected String name;

	protected int hp;

	protected int level;

	//defence
	protected int def;


	// to describe whether the role has faint
	protected boolean wheFaint;

	public Role(String na, int le, int de)
	{
		name = na;
		level = le;
		hp = (level*100);
		def = de;
		wheFaint = false;
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

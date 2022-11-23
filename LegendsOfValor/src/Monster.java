import java.util.Random;

//monster class contains monster's attribute and method
public abstract class Monster extends Role {
	
	private int dmg;
	
	//dodge chance
	protected double dodge;
	
	protected String type;

	// constructor
//	public Monster(String na, int lev, int da, int def, double dod, String ty)
//	{
//		super(na, lev, def);
//		dmg = da;
//		dodge = dod;
//		type = ty;
//
//		hp/=4;
//		hp*=2;
//
//	}

	public Monster(String na, int lev, int da, int def, double dod)
	{
		super(na, lev, def);
		dmg = da;
		dodge = dod;
//		type = ty;

//		hp/=4;
//		hp*=2;

	}

	//getter and setter method below

	public int getDmg() {return dmg;}

	public double getDodge() {return dodge;}

	public String getType() {return type;}

	public void setDmg(int dmg) {this.dmg = dmg;}

	public void setDodge(double dodge) {this.dodge = dodge;}

	public void setType(String type) {this.type = type;}

	// when monster attack a hero
	public void causeDMG(Hero hero) {
		// the corresponding hero deals with the attack
		int eff = hero.loseHP(dmg);
		if (eff != 0) {
			System.out.println("Monster "+ name+" attacked hero " + hero.getName() + " and caused " + dmg + " damage.");
		}
	}

	// monster get attacked by a hero
	public int loseHP(int damage){
		int eff = 0;
		Random random = new Random();
		int temp = random.nextInt(10) + 1;
		// monster has a probability to dodge the attack
		if (temp < (int) (dodge*0.08)){
			System.out.println("Monster" + name + "has dodged an attack");
			return eff;
		} else{
			hp -= damage;
			if(hp <= 0){
				becomeFaint();
				System.out.println("Monster " + name + " has been killed. Good job!");
			}
		}
		return eff;
	}


	@Override
	public String toString() {

		String concate= "";

		concate+=String.format("%-16s",getName());
		concate+=String.format("%-8s",getHp());
		concate+=String.format("%-4s",getLevel());
		concate+=String.format("%-10s", getDmg());
		concate+=String.format("%-10s",getDef());
		concate+=String.format("%-10s",getDodge());
		concate+=String.format("%-16s",getType());
		concate+=String.format("%-10s",getLevel());
		
		return concate;

	}
}

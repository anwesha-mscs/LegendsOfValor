import java.util.ArrayList;
import java.util.Random;

//monster class contains monster's attribute and method
public abstract class Monster extends Role {
	
	private int damage;

	//dodge chance
	protected double dodge_chance;
	
	protected String type;

	public Monster(String name, int level, int damage, int defence, double dodge_chance)
	{
		super(name, level, defence);
		this.damage = damage;
		this.dodge_chance = dodge_chance;
	}

	public boolean oneTurn(ArrayList<Hero> heroes) {
		ArrayList<Hero> heroInLane = new ArrayList<>();
		System.out.println("It is now time for the monsters to play!");
		System.out.println(this.getName() +" will play his turn");
		System.out.println("Monster x value " +x);
		System.out.println("Monster y value " +y);
		//monster has to battle heroes within its range. This is done in the Game class.
		for(Hero hero: heroes){
			if(hero.getLaneCurr() == this.getLaneCurr()){
				heroInLane.add(hero);
				//check if hero has already won
				if(hero.getX()!=0){
					//else check if the hero in the same lane is either above below or beside the monster
					if(hero.getX()-1 == this.getX() || hero.getX()+1 == this.getX() || hero.getX() == this.getX()){
						return true;
					}
				}
			}
		}
		if(x!=0){
			if(map.grid[x-1][y].isHasHero()){
				return true;
			}
		}
		if(y!=0){
			if(map.grid[x][y-1].isHasHero()){
				return true;
			}
		}
		if(x!=0 && y!=0){
			if(map.grid[x-1][y-1].isHasHero()){
				return true;
			}
		}
		updateLocation(heroes);
		return false;
	}

	private void updateLocation(ArrayList<Hero> heroes) {
		if(x!=7 && map.grid[x+1][y].isHasMoster()){
			System.out.println("Monster" +this.name +" is currently stuck!");
			return;
		}
		//this heroes list is only the heroes which are in same lane as monster
		for(Hero hero: heroes){
			//the monster cannot overtake the hero without killing him
			//ideally the code should not reach here - it should return from the previous function itself
			if(!this.getHasWon() && hero.getX() == x+1){
				System.out.println("Hero is in same lane as monster. Monster will have to defeat hero to proceed further");
				return;
			}
		}
		leaveEnter(x+1,y);
	}


	private void leaveEnter(int enterX,int enterY){
		if(enterX == 7){
			System.out.println("The nexus for lane " +laneOri +" has been occupied by monster " +this.name);
			setHasWon(true);
		}

		try {
			char type= map.grid[enterX][enterY].getType();
			if(type=='X'){
				//delete this print
				System.out.println("Mon: The location you are trying to enter is inaccessible");
				//this.updateLocation();
			}
			else if (map.grid[enterX][enterY].isHasHero()) {
				//delete this print
				System.out.println("Mon:There is already a hero there! You can not enter it.");
				//this.updateLocation();
			}
			else if (map.grid[enterX][enterY].isHasMoster()) {
				System.out.println("Mon:There is already a monster there! You can not enter it.");
				//this.updateLocation();
			}
		} catch (Exception e) {
//			throw new RuntimeException(e);
			System.out.println(e.getMessage());
			System.out.println(e);
			System.out.println("Mon:The place you want to enter is out of bounds!!");
			//this.updateLocation();
		}

		System.out.println("Leave enter:");

		System.out.println(getDis()+"Before x y: "+x+y);
		map.grid[x][y].setHasMoster(false);
		map.grid[enterX][enterY].setHasMoster(true);

		x=enterX;
		y=enterY;

		laneCurr = y/3 +1;
		System.out.println(getDis()+"after x y: "+x+y);
	}
	//getter and setter method below

	public int getDmg() {return this.damage;}

	public double getDodge() {return this.dodge_chance;}

	public String getType() {return this.type;}

	public void setDmg(int damage) {this.damage = damage;}

	public void setDodge(double dodge_chance) {this.dodge_chance = dodge_chance;}

	public void setType(String type) {this.type = type;}

	// when monster attack a hero
	public void causeDMG(Hero hero) {
		// the corresponding hero deals with the attack
		int eff = hero.loseHP(damage);
		if (eff != 0) {
			System.out.println("Monster "+ this.name+" attacked hero " + hero.getName() + " and caused " + this.damage + " damage.");
		}
	}

	// monster get attacked by a hero
	public int loseHP(int damage){
		int eff = 0;
		Random random = new Random();
		int temp = random.nextInt(10) + 1;
		// monster has a probability to dodge the attack
		if (temp < (int) (this.dodge_chance*0.08)){
			System.out.println("Monster " + name + " has dodged an attack");
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

		String concatenate= "";

		concatenate+=String.format("%-16s",getName());
		concatenate+=String.format("%-8s",getHp());
		concatenate+=String.format("%-4s",getLevel());
		concatenate+=String.format("%-10s", getDmg());
		concatenate+=String.format("%-10s",getDef());
		concatenate+=String.format("%-10s",getDodge());
		concatenate+=String.format("%-16s",getType());
		concatenate+=String.format("%-10s",getLevel());
		
		return concatenate;

	}
}
